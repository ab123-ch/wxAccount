package com.tencent.wxcloudrun.service.impl;

import com.alibaba.fastjson.JSON;
import com.tencent.wxcloudrun.model.Business;
import com.tencent.wxcloudrun.dao.BusinessMapper;
import com.tencent.wxcloudrun.model.Product;
import com.tencent.wxcloudrun.model.User;
import com.tencent.wxcloudrun.service.BusinessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tencent.wxcloudrun.service.ProductService;
import com.tencent.wxcloudrun.utils.UserConfigUtil;
import com.tencent.wxcloudrun.utils.UserUtil;
import com.tencent.wxcloudrun.vo.BusinessEventVo;
import com.tencent.wxcloudrun.vo.UserAmountVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenh
 * @since 2024-06-04
 */
@Service
@Slf4j
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements BusinessService {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserUtil userUtil;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void saveBusiness(Business business) {
        User user = userUtil.getUser();
        if(Objects.isNull(business)){
            throw new RuntimeException("保存信息不能为空");
        }
        business.setEnable(Boolean.FALSE);
        log.info(JSON.toJSONString(business));
        if(Objects.isNull(business.getId())){
            this.getBaseMapper().insert(business);
        }else{
            this.getBaseMapper().updateById(business);
        }
        applicationEventPublisher.publishEvent(new BusinessEventVo(this).setBusinessName(business.getBusinessName()).setUser(userUtil.getUser()));
    }

    @Override
    public List<Business> getBusiness(HttpServletRequest request) {
        return this.getBaseMapper().selectAllBusiness();
    }

    @Override
    public List<Business> getConfirmBusiness(Boolean enable) {
        return this.getBaseMapper().selectConfirmBusiness(enable?1:0);
    }

    @Override
    public List<UserAmountVo> getUserAmount(User user) {
        List<UserAmountVo> userAmountVos = this.getBaseMapper().getUserAmountTotal(user);
        return this.getBaseMapper().getUserAmount(user);
    }

    @Override
    public void modifyConfirmBusiness(Boolean enable,Integer id) {
        this.getBaseMapper().modifyConfirmBusiness(enable?1:0,id);
    }
}
