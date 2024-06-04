package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Business;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chenh
 * @since 2024-06-04
 */
public interface BusinessMapper extends BaseMapper<Business> {
    List<Business> selectAllBusiness();

    List<Business> selectConfirmBusiness(@Param("enable")  Integer enable);

    void modifyConfirmBusiness(@Param("enable") Integer enable,@Param("id") Integer id);
}
