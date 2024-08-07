package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.dto.UserDto;
import com.tencent.wxcloudrun.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
