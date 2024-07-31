package com.tencent.wxcloudrun.utils;

import com.tencent.wxcloudrun.dto.UserDto;

public class UserConfigUtil {


    /**
     * 系统默认级别的语言TODO可以成为配置式
     */
    private static final ThreadLocal<UserDto> userThread = new ThreadLocal<UserDto>();

    /**
     * 存用户
     *
     * @param shiroUser
     */
    public static void setUser(UserDto shiroUser) {
        userThread.set(shiroUser);
    }


    /**
     * 获取用户
     *
     * @return
     */
    public static UserDto getUser() {
        return userThread.get();
    }

    /**
     * 获取用户
     *
     * @return
     */
    public static UserDto getUserInfo() {
        return userThread.get();
    }

    public static void clear() {
        userThread.set(null);
        userThread.remove();
    }
}
