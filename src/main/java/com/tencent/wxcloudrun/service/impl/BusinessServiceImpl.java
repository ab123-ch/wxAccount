package com.tencent.wxcloudrun.service.impl;

import com.alibaba.fastjson.JSON;
import com.tencent.wxcloudrun.model.Business;
import com.tencent.wxcloudrun.dao.BusinessMapper;
import com.tencent.wxcloudrun.service.BusinessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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


    @Override
    public void saveBusiness(Business business) {
        if(Objects.isNull(business)){
            throw new RuntimeException("保存信息不能为空");
        }
        business.setEnable(Boolean.FALSE);
        if(Objects.isNull(business.getId())){
            this.getBaseMapper().insert(business);
        }else{
            this.getBaseMapper().updateById(business);
        }

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
    public void modifyConfirmBusiness(Boolean enable,Integer id) {
        this.getBaseMapper().modifyConfirmBusiness(enable?1:0,id);
    }
}
