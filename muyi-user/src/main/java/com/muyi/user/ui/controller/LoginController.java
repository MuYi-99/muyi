package com.muyi.user.ui.controller;

import com.muyi.user.application.service.LoginService;
import com.muyi.user.infrastructure.annotation.PassToken;
import com.muyi.user.ui.dto.base.RequestDto;
import com.muyi.user.ui.dto.base.ResponseDto;
import com.muyi.user.ui.dto.base.ResponseType;
import com.muyi.user.ui.dto.login.LoginRequestBody;
import com.muyi.user.ui.dto.login.LoginResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author yangx
 * @date 2022/3/25 10:44
 */
@RestController
@RequestMapping("/muyi/user")
public class LoginController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseDto login(@RequestBody @Valid RequestDto<LoginRequestBody> requestDto){
        try {
            LoginResponseBody loginResponseBody = loginService.login(requestDto);
            return new ResponseDto(ResponseType.SUCCESS, loginResponseBody);
        } catch (Exception e){
            LOG.error(e.getMessage());
            return new ResponseDto(ResponseType.ERROR, e.getMessage());
        }
    }
}
