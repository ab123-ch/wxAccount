package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.dto.UserDto;
import com.tencent.wxcloudrun.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chenh
 * @since 2024-07-31
 */
public interface UserService extends IService<User> {

    void save(User user, UserDto userDto);

    User getUserInfo(UserDto user);

    List<User> getAllUserInfo(UserDto user);
}
