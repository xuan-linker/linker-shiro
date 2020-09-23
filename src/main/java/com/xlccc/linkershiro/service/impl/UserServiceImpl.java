package com.xlccc.linkershiro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlccc.linkershiro.dao.UserDao;
import com.xlccc.linkershiro.entity.User;
import com.xlccc.linkershiro.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {
    @Resource
    private UserDao userDao;

    @Override
    public List<String> selectPermissionByUserId(Integer id) {
        return userDao.selectPermissionByUserId(id);
    }

    @Override
    public User findUserByName(String userName) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(userName != null, User::getName, userName);
        User resultUser = userDao.selectOne(queryWrapper);
        return resultUser;
    }
}
