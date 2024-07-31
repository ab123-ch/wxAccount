package com.tencent.wxcloudrun.utils;

import com.tencent.wxcloudrun.dao.UserMapper;
import com.tencent.wxcloudrun.dto.UserDto;
import com.tencent.wxcloudrun.model.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

@Data
@Component
public class UserUtil implements Serializable {

    @Autowired
    private UserMapper userMapper;

    public User getUser(){
        UserDto userInfo = UserConfigUtil.getUser();
        if(Objects.nonNull(userInfo)){
            return userMapper.selectByWxid(userInfo);
        }
        return null;
    }
}
