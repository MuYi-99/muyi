package com.muyi.user.domain.model.login;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.util.Assert;
import org.springframework.util.PatternMatchUtils;
import org.springframework.util.StringUtils;

/**
 * @author yangx
 * @date 2022/3/25 17:48
 */
@Getter
@Setter
public class LoginClient {

    private static final String IP_PATTERN = "/((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}/g";

    private String ip;

    public LoginClient(String ip){
        setIp(ip);
    }

    public void setIp(String ip) {
        Assert.isTrue(!StringUtils.isEmpty(ip), "客户端地址不能为空");
        boolean isIllegal = PatternMatchUtils.simpleMatch(IP_PATTERN, ip);
        Assert.isTrue(isIllegal, "非法的客户端地址：" + ip);
        this.ip = ip;
    }
}
