package com.muyi.user.infrastructure.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.muyi.user.infrastructure.annotation.PassToken;
import com.muyi.user.infrastructure.uitl.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 权限鉴定拦截器
 * @author yangx
 * @date 2022/3/25 18:23
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        LOG.info("请求：{}", request.getRequestURI());
        String token = request.getHeader(JwtUtil.header);
        // 如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){
            LOG.info("请求通过");
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 检测是否有 PassToken 注解，有则跳过认证
        if(method.isAnnotationPresent(PassToken.class)){
            PassToken passToken = method.getAnnotation(PassToken.class);
            if(passToken.required()){
                LOG.info("跳过验证");
                return true;
            }
        }
        // 校验 token 是否为空
        if(StringUtils.isEmpty(token)){
            response.setStatus(HttpServletResponse.SC_FOUND);
            throw new RuntimeException("token为空，请重新登录");
        }
//        String userId;
        String password = "";
        try {
            // 验证 token 中的 userId
//            userId = JWT.decode(token).getAudience().get(0);
            // 校验token是否合法
            JwtUtil.validateToken(token, password);
        } catch (TokenExpiredException e){
            response.setStatus(HttpServletResponse.SC_FOUND);
            throw new RuntimeException("token已过期，请重新登录", e);
        } catch (Exception e){
            response.setStatus(HttpServletResponse.SC_FOUND);
            throw new RuntimeException("非法的Token，请重新登录", e);
        }
        return true;
    }
}
