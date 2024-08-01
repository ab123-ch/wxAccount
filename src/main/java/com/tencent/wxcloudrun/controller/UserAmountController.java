package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.dto.UserDto;
import com.tencent.wxcloudrun.model.Product;
import com.tencent.wxcloudrun.model.User;
import com.tencent.wxcloudrun.service.BusinessService;
import com.tencent.wxcloudrun.service.ProductService;
import com.tencent.wxcloudrun.utils.UserConfigUtil;
import com.tencent.wxcloudrun.utils.UserUtil;
import com.tencent.wxcloudrun.vo.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userAmount")
public class UserAmountController {


    @Autowired
    private BusinessService businessService;

    @Autowired
    private UserUtil userUtil;

    @PostMapping("/getUserAmount")
    public RestResponse getUserAmount() {
        User user = userUtil.getUser();
        return RestResponse.Success(businessService.getUserAmount(user));
    }
}
