package com.tencent.wxcloudrun.controller;


import com.tencent.wxcloudrun.dao.UserMapper;
import com.tencent.wxcloudrun.dto.UserDto;
import com.tencent.wxcloudrun.model.User;
import com.tencent.wxcloudrun.service.UserService;
import com.tencent.wxcloudrun.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
public class UserController {

    @Autowired
    private UserUtil userUtil;

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public void login(User user){
        if(Objects.nonNull(user)){
            UserDto userDto = userUtil.getUserDto();
            userService.save(user,userDto);
        }
    }

}
