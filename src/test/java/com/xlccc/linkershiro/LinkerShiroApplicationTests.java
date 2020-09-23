package com.xlccc.linkershiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xlccc.linkershiro.entity.User;
import com.xlccc.linkershiro.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class LinkerShiroApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private IUserService userService;
    @Test
    public void test(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getName,"admin");
        User user = userService.getOne(queryWrapper);
        System.out.println(user.toString());

    }

}
