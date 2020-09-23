package com.xlccc.linkershiro.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xlccc.linkershiro.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao extends BaseMapper<User> {

    /**
     * 通过用户ID查询用户
     *
     * @param id
     * @return
     */
    List<String> selectPermissionByUserId(Integer id);


}
