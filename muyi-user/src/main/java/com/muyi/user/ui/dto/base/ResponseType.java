package com.muyi.user.ui.dto.base;

import lombok.Getter;

/**
 * @author yangx
 * @date 2022/3/25 16:04
 */
@Getter
public enum ResponseType {

    /**
     * 成功
     **/
    SUCCESS("success", "成功"),

    /**
     * 失败
     **/
    ERROR("error", "失败");

    private final String code;

    private final String desc;

    ResponseType(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

}
