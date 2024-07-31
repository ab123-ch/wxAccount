package com.tencent.wxcloudrun.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private static final long serialVersionUID =1L;

    private String openId;

    private String unionId;

}
