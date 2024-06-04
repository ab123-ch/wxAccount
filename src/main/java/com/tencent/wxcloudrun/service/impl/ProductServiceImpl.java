package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.model.Product;
import com.tencent.wxcloudrun.dao.ProductMapper;
import com.tencent.wxcloudrun.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenh
 * @since 2024-06-04
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
