package com.muyi.user.domain.model.login;

import lombok.Getter;

/**
 * @author yangx
 * @date 2022/3/25 12:19
 */
@Getter
public enum LoginStatus {

    /**
     * 登录成功
     **/
    LOGIN_SUCCESS("00", "登录成功"),

    /**
     * 登录失败
     **/
    LOGIN_FAILED("01", "登录失败"),

    /**
     * 登录注销
     **/
    LOGIN_LOGOUT("02", "登录注销");

    private final String code;

    private final String desc;

    LoginStatus(String code, String desc){
        this.code = code;
        this.desc = desc;
    }
}
