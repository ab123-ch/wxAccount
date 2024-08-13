package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/amount")
public class AmountController {

    @Autowired
    private BusinessService businessService;

//    @GetMapping("getUserAmountDetail")
//    public RestResponse getUserAmountDetail(){
//        return RestResponse.Success(businessService.getUserAmountDetail());
//    }

}
