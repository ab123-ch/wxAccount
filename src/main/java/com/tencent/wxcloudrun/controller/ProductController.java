package com.tencent.wxcloudrun.controller;


import com.tencent.wxcloudrun.model.Product;
import com.tencent.wxcloudrun.service.BusinessService;
import com.tencent.wxcloudrun.service.ProductService;
import com.tencent.wxcloudrun.vo.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chenh
 * @since 2024-06-04
 */
@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public RestResponse save(@RequestBody Product product) {
        productService.saveInfo(product);
        return RestResponse.Success();
    }

    @PostMapping("/getProduct")
    public RestResponse<Product> getProduct(@RequestParam(required = false) String name) {
        return RestResponse.Success(productService.getProduct(name));
    }

}
