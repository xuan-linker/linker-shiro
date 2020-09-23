package com.xlccc.linkershiro.controller;

import com.xlccc.linkershiro.controller.param.UserLoginParam;
import com.xlccc.linkershiro.controller.param.UserLogoutParam;
import com.xlccc.linkershiro.entity.User;
import com.xlccc.linkershiro.utils.JsonUtils;
import com.xlccc.linkershiro.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.SecurityUtils;

/**
 * @author Linker
 * @date 2020/9/23 20:59
 * @description：
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    private RedisUtils redisUtils;

    @PostMapping("/login")
    public String login(UserLoginParam param) {
        log.info("login() -> {}", param);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(param.getUserName(), param.getPassword());
        Subject subject = SecurityUtils.getSubject();

        subject.login(usernamePasswordToken);
        User user = (User) subject.getPrincipal();
        redisUtils.set("user" + param.getUserName(), JsonUtils.objectToJson(user));
        return "ok";
    }

    @PostMapping("/logout")
    public String logout(UserLogoutParam param) {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
        }
        redisUtils.del("user" + param.getUserName());
        return "ok";
    }
}
