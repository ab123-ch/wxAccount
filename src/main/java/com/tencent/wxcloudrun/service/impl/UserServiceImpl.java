package com.tencent.wxcloudrun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tencent.wxcloudrun.dao.UserMapper;
import com.tencent.wxcloudrun.dto.UserDto;
import com.tencent.wxcloudrun.enums.RoleEnum;
import com.tencent.wxcloudrun.model.User;
import com.tencent.wxcloudrun.service.UserService;
import com.tencent.wxcloudrun.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    private UserUtil userUtil;

    @Override
    public User getUserInfo(UserDto userDto) {
        return userMapper.selectByWxid(userDto);
    }

    @Override
    public List<User> getAllUserInfo(UserDto userDto) {
        User user = userUtil.getUser();
        if(RoleEnum.ALL_ROLE.name().equals(user.getRole())){
            return userMapper.getAllUserInfo();
        }
        return null;
    }

    @Override
    public void save(User user, UserDto userDto) {
        user.setOpenId(userDto.getOpenId());
        user.setUnionId(userDto.getUnionId());
        user.setRole(RoleEnum.DEFAULT_ROLE.name());
        userMapper.insert(user);
    }
}
