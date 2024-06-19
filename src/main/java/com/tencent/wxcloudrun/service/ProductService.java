package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Product;
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
public interface ProductService extends IService<Product> {

    void saveInfo(Product product);

    List<Product> getProduct(String name);
}
