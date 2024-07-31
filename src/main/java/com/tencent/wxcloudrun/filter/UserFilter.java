package com.tencent.wxcloudrun.filter;

import com.tencent.wxcloudrun.dto.UserDto;
import com.tencent.wxcloudrun.utils.UserConfigUtil;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;


@Slf4j
@WebFilter
public class UserFilter implements Filter {


    private final ConcurrentHashMap<String, String> headerCache = new ConcurrentHashMap<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String openId = request.getHeader("X-WX-OPENID");
        String unionId = request.getHeader("X-WX-UNIONID");
        setUserInfo(openId, unionId);
        log.info("获取用户权限id：：：" + openId);
        System.out.println(openId);
        System.out.println("================================================");
        System.out.println(unionId);
        filterChain.doFilter(request,response);
    }

    private static void setUserInfo(String openId, String unionId) {
        UserDto userDto = new UserDto();
        userDto.setOpenId(openId);
        userDto.setUnionId(unionId);
        UserConfigUtil.setUser(userDto);
    }

    public ConcurrentHashMap<String, String> getHeaderCache() {
        return headerCache;
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
