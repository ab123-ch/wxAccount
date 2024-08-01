package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tencent.wxcloudrun.model.User;
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
public interface ProductMapper extends BaseMapper<Product> {

    Integer selectByName(String productName);

    List<Product> getProduct(String name);

    List<Product> getProductByUserInfo(@Param("name") String name, @Param("user") User user);
}
