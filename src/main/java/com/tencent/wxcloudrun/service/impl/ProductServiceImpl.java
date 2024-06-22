package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.model.Product;
import com.tencent.wxcloudrun.dao.ProductMapper;
import com.tencent.wxcloudrun.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
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
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public void saveInfo(Product product) {
        if(Objects.isNull(product)){
            throw new RuntimeException("项目信息不能为空");
        }
        checkData(product);
        if(Objects.isNull(product.getId())){
            productMapper.insert(product);
        }else{
            productMapper.updateById(product);
        }

    }

    @Override
    public List<Product> getProduct(String name) {
        return productMapper.getProduct(name);

    }

    private void checkData(Product product) {
        product.setCreateTime(new Date());
        String productName = product.getProductName();
        BigDecimal amount = product.getAmount();
        if(StringUtils.isEmpty(productName)){
            throw new RuntimeException("项目名称不能为空");
        }
        if(Objects.isNull(amount)){
            throw new RuntimeException("金额不能为空");
        }
        product.setProductName(productName.trim());
        Integer count = productMapper.selectByName(product.getProductName());
        if(Objects.nonNull(count) && count >0){
            throw new RuntimeException("项目名称已存在");
        }
    }
}
