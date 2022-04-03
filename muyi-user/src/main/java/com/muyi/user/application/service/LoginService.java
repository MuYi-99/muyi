package com.muyi.user.application.service;

import com.muyi.user.ui.dto.base.RequestDto;
import com.muyi.user.ui.dto.login.LoginRequestBody;
import com.muyi.user.ui.dto.login.LoginResponseBody;


/**
 * @author yangx
 * @date 2022/3/25 10:49
 */
public interface LoginService {

    /**
     * 登录
     * @param requestDto 请求dtp
     * @return 登录响应
     * @author yangx
     * @date 2022/3/25 10:55
     **/
    LoginResponseBody login(RequestDto<LoginRequestBody> requestDto);

}
