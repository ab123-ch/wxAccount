package com.tencent.wxcloudrun.enums;

/**
 * 权限枚举
 */
public enum RoleEnum {

    ALL_ROLE("全权限"),
    DEFAULT_ROLE("默认权限")
    ;

    private String name;

    RoleEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
