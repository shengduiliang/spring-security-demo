package org.example.springsecurityformlogin.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;


import java.io.IOException;
import java.util.HashMap;

/**
 * @description:
 * @version: 1.0
 * @date: 2024/6/1 下午2:17
 */
public class CustomerHandler {

    public static void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        HashMap<String, Object> resp = new HashMap<>();
        resp.put("status", 200);
        resp.put("msg", "登录成功");
        response.setHeader(HttpHeaders.CONTENT_TYPE, "application/json;charset=UTF-8");
        response.getWriter().write(new ObjectMapper().writeValueAsString(resp));
    }

    public static void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, Exception exception) throws IOException {
        HashMap<String, Object> resp = new HashMap<>();
        resp.put("status", 401);
        resp.put("msg", "用户名或者密码错误");
        response.setHeader(HttpHeaders.CONTENT_TYPE, "application/json;charset=UTF-8");
        response.getWriter().write(new ObjectMapper().writeValueAsString(resp));
    }
}
