package com.muyi.user.domain.model.login;

import com.muyi.user.domain.model.user.LoginUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

import java.sql.Timestamp;

/**
 * 登录的模型
 * @author yangx
 * @date 2022/3/25 11:48
 */
@Getter
@Setter
public class Login {

    private String username;

    private Timestamp loginTime;

    private LoginClient loginClient;

    private LoginStatus status;

    private LoginUser loginUser;

    private String token;

    public Login(String username){
        this.setUsername(username);
        this.setLoginUser(new LoginUser(username));
    }

    public void setLoginClient(LoginClient loginClient) {
        Assert.isTrue(null != loginClient, "客户端信息不能为空");
        this.loginClient = loginClient;
    }

    /**
     * 登录注销
     **/
    public void logout(){
        this.setStatus(LoginStatus.LOGIN_LOGOUT);
    }

}
