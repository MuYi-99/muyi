package com.muyi.user.ui.dto.base;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;

/**
 * 请求dto
 * @author yangx
 * @date 2022/3/25 10:08
 */
@Getter
@Setter
public class RequestDto<T> implements UIDto{

    @Valid
    private T body;

}
