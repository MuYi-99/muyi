package com.muyi.user.infrastructure.uitl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author yangx
 * @date 2022/3/25 16:19
 * <p>
 * JwtToken生成的工具类
 * JWT token的格式：header.payload.signature
 * header的格式（算法、token的类型）,默认：{"alg": "HS512","typ": "JWT"}
 * payload的格式 设置：（用户信息、创建时间、生成时间）
 * signature的生成算法：
 * HMACSHA512(base64UrlEncode(header) + "." +base64UrlEncode(payload),secret)
 */
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtUtil {

    /**
     * 定义Token返回的头部
     **/
    public static String header;

    /**
     * 有效期 分
     **/
    public static long expireTime;

    public void setHeader(String header) {
        JwtUtil.header = header;
    }

    public void setExpireTime(int expireTimeInt) {
        JwtUtil.expireTime = expireTimeInt * 1000L * 60;
    }

    /**
     * 创建TOKEN
     */
    public static String createToken(String userId, String password){
        return JWT.create()
                .withSubject(userId)
                .withExpiresAt(new Date(System.currentTimeMillis() + expireTime))
                .sign(Algorithm.HMAC512(password));
    }


    /**
     * 验证 token
     */
    public static boolean validateToken(String token, String password) {
        JWT.require(Algorithm.HMAC512(password))
                .build()
                .verify(token);
        return true;
    }

}
