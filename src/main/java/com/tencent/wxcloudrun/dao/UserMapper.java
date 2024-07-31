package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.dto.UserDto;
import com.tencent.wxcloudrun.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chenh
 * @since 2024-07-31
 */
public interface UserMapper extends BaseMapper<User> {

    User selectByWxid(UserDto userInfo);
}
