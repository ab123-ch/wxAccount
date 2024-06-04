package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Business;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chenh
 * @since 2024-06-04
 */
public interface BusinessService extends IService<Business> {
    void saveBusiness(Business business);

    List<Business> getBusiness();

    List<Business> getConfirmBusiness(Boolean enable);

    void modifyConfirmBusiness(Boolean enable,Integer id);
}
