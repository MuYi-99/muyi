package com.muyi.user.ui.dto.base;

import lombok.Getter;
import lombok.Setter;

/**
 * @author yangx
 * @date 2022/3/25 10:15
 */
@Getter
@Setter
public class ResponseDto {

    private ResponseType responseType;

    private String returnMsg;

    private Object body;

    public ResponseDto(ResponseType responseType, String returnMsg){
        setResponseType(responseType);
        setReturnMsg(returnMsg);
    }

    public ResponseDto(ResponseType responseType, Object body){
        setResponseType(responseType);
        setBody(body);
    }

}
