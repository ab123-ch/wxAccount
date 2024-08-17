package com.tencent.wxcloudrun.controller;


import com.tencent.wxcloudrun.dto.UserDto;
import com.tencent.wxcloudrun.model.User;
import com.tencent.wxcloudrun.service.UserService;
import com.tencent.wxcloudrun.utils.UserUtil;
import com.tencent.wxcloudrun.vo.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chenh
 * @since 2024-07-31
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserUtil userUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public void login(@RequestBody User user){
        if(Objects.nonNull(user)){
            UserDto userDto = userUtil.getUserDto();
            userService.save(user,userDto);
        }
    }

    @GetMapping("/getUserInfo")
    public RestResponse<User> getUserInfo(){
        UserDto userDto = userUtil.getUserDto();
        log.info("获取到的用户id{}",userDto);
        return RestResponse.Success(userService.getUserInfo(userDto));
    }

    @GetMapping("/getAllUserInfo")
    public RestResponse<User> getAllUserInfo(){
        UserDto userDto = userUtil.getUserDto();
        log.info("获取到的用户id{}",userDto);
        return RestResponse.Success(userService.getAllUserInfo(userDto));
    }

}
