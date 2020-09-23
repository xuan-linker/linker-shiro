package com.xlccc.linkershiro.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Linker
 * @date 2020/9/23 22:42
 * @description：
 */
@RestController("/test")
public class TestController {

    @RequiresRoles("admin")
    @RequiresPermissions(value = "add")
    @RequestMapping(value = "/test")
    public String test(HttpServletRequest request, String test) {
        System.out.println(test);
        return "test";
    }

    @RequestMapping(value = "/{page}")
    public String show(@PathVariable("page") String page) {
        return page;
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

}
