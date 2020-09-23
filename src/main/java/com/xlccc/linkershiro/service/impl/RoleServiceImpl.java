package com.xlccc.linkershiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlccc.linkershiro.dao.RoleDao;
import com.xlccc.linkershiro.entity.Role;
import com.xlccc.linkershiro.service.IRoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements IRoleService {
}
