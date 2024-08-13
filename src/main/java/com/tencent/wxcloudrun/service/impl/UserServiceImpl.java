package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dto.UserDto;
import com.tencent.wxcloudrun.model.User;
import com.tencent.wxcloudrun.dao.UserMapper;
import com.tencent.wxcloudrun.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenh
 * @since 2024-07-31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserInfo(UserDto userDto) {
        return userMapper.selectByWxid(userDto);
    }

    @Override
    public void save(User user, UserDto userDto) {
        user.setOpenId(userDto.getOpenId());
        user.setUnionId(userDto.getUnionId());
        userMapper.insert(user);
    }
}
