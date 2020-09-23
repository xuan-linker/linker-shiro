package com.xlccc.linkershiro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xlccc.linkershiro.entity.User;

import java.util.List;

public interface IUserService extends IService<User> {
    List<String> selectPermissionByUserId(Integer id);

    User findUserByName(String userName);
}
