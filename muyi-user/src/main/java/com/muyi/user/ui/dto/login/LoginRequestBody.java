package com.muyi.user.ui.dto.login;

import com.muyi.user.ui.dto.base.RequestBody;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * @author yangx
 * @date 2022/3/25 10:23
 */
@Getter
@Setter
public class LoginRequestBody extends RequestBody {

    @NotBlank(message = "请输入用户名")
    private String username;

    @NotBlank(message = "请输入密码")
    private String password;

}
