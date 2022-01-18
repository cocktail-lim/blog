package com.finn.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.beans.binding.ObjectExpression;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/*
 * @description:
 * @author: Finn
 * @create: 2022-01-16-16-09
 */

// 放入spring容器中，可以在该类上标明@component，或者在其他类中标识@Bean，并声明方法来得到该对象
public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    // 处理json数据
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if(request == null) System.out.println("null");
        else System.out.println("not null");
        System.out.println(request.getContextPath());

        Map<String, String> map = new HashMap<>(); //存入 username 和 password
        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println(request.getContentType());

        if(request.getDispatcherType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE)
                || request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)){
            if(!request.getMethod().equals("POST")) {
                throw new AuthenticationServiceException(
                        "Authentication Method is not supported: " + request.getMethod());
            }

            try(InputStream is = request.getInputStream()){
                map = objectMapper.readValue(is, Map.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(!map.isEmpty()) {
                String username = map.get("username");
                String password = map.get("password");

                // 打印到控制台
                System.out.println("username: " + username + "       " + "password: " + password);
//                try {
//                    objectMapper.writeValue(System.out, "username: " + username + "++++" + "password: " + password);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }

                if (username == null) {
                    username = "";
                }

                if (password == null) {
                    password = "";
                }
                
                username = username.trim();
                UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
                this.setDetails(request, authRequest);
                return this.getAuthenticationManager().authenticate(authRequest);
            }
            return null;
        }

        return null;
    }
}
