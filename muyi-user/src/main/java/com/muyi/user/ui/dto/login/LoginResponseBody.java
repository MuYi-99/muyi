package com.muyi.user.ui.dto.login;

import com.muyi.user.domain.model.login.Login;
import com.muyi.user.ui.dto.base.ResponseBody;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yangx
 * @date 2022/3/25 10:52
 */
@Getter
@Setter
public class LoginResponseBody extends ResponseBody {

    private Login login;

    public LoginResponseBody(Login login){
        this.setLogin(login);
    }

}
