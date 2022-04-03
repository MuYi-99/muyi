package com.muyi.user.domain.model.user;
import com.muyi.user.domain.model.login.Login;
import com.muyi.user.domain.model.login.LoginStatus;
import com.muyi.user.infrastructure.uitl.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.sql.Timestamp;

/**
 * 登录用户
 * @author yangx
 * @date 2022/3/25 11:45
 */
public class LoginUser extends User{

    private static final Logger LOG = LoggerFactory.getLogger(LoginUser.class);

    public LoginUser(String username) {
        super(username);
    }

    /**
     * 登录
     **/
    public Login login(String password) {
        Assert.isTrue(isExist(), "用户 " + getUsername() + " 不存在");
        Assert.isTrue(validatePassword(password), "密码不正确");
        // 创建登录模型
        Login login = new Login(this.getUsername());
        // 设置token
        login.setToken(JwtUtil.createToken(this.getId(), password));
        // 设置状态
        login.setStatus(LoginStatus.LOGIN_SUCCESS);
        // 设置登录时间
        login.setLoginTime(new Timestamp(System.currentTimeMillis()));
        LOG.info("用户 {} 登录成功", getUsername());
        return login;
    }

    /**
     * 判断当前用户是否存在
     * @author yangx
     * @date 2022/3/25 11:35
     **/
    public boolean isExist(){
        return true;
    }

    /**
     * 验证密码
     * @author yangx
     * @date 2022/3/25 14:35
     **/
    public boolean validatePassword(String password){
        return true;
    }

}
