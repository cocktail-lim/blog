package com.finn.controller;


import com.finn.Result;
import com.finn.ResultInfo;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author finn
 * @since 2022-01-15
 */
@RestController
//@RequestMapping("/user")
public class UserController {

    @GetMapping("/user")
    public Result user(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AbstractAuthenticationToken abstractAuthenticationToken = (AbstractAuthenticationToken)authentication;
        Object details = abstractAuthenticationToken.getDetails();
        System.out.println("Details: " + details.toString());
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken)authentication;
        Object principal = usernamePasswordAuthenticationToken.getPrincipal();
        System.out.println("Principal: " + principal);
        return Result.success().codeAndMessage(ResultInfo.SUCCESS);
    }

}
