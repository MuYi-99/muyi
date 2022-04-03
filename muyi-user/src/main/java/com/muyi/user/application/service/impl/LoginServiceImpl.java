package com.muyi.user.application.service.impl;

import com.muyi.user.application.service.LoginService;
import com.muyi.user.domain.model.login.Login;
import com.muyi.user.domain.model.user.LoginUser;
import com.muyi.user.ui.dto.base.RequestDto;
import com.muyi.user.ui.dto.login.LoginRequestBody;
import com.muyi.user.ui.dto.login.LoginResponseBody;
import org.springframework.stereotype.Service;

/**
 * @author yangx
 * @date 2022/3/25 11:00
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public LoginResponseBody login(RequestDto<LoginRequestBody> requestDto) {
        LoginRequestBody loginRequestBody = requestDto.getBody();
        String username = loginRequestBody.getUsername();
        String password = loginRequestBody.getPassword();
        LoginUser loginUser = new LoginUser(username);
        Login login = loginUser.login(password);
        return new LoginResponseBody(login);
    }

}
