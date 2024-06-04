package com.tencent.wxcloudrun.controller;


import com.tencent.wxcloudrun.model.Business;
import com.tencent.wxcloudrun.service.BusinessService;
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
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    /**
     * 保存业务数据
     * @param business
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public RestResponse saveBusiness(@RequestBody Business business){
        businessService.saveBusiness(business);
        return RestResponse.Success();
    }

    /**
     * 获取所有业务数据
     * @return
     */
    @GetMapping("/getBusiness")
    public RestResponse getBusiness(){

        return RestResponse.Success(businessService.getBusiness());
    }

    /**
     * 根据确认状态获取数据
     * @return
     */
    @GetMapping("/getConfirmBusiness")
    public RestResponse getConfirmBusiness(@RequestParam("enable") Boolean enable){

        return RestResponse.Success(businessService.getConfirmBusiness(enable));
    }

    /**
     * 是否确认数据
     * @return
     */
    @GetMapping("/modifyConfirmBusiness")
    public RestResponse modifyConfirmBusiness(@RequestParam("enable")Boolean enable,@RequestParam("id")Integer id){
        businessService.modifyConfirmBusiness(enable,id);
        return RestResponse.Success();
    }

}
