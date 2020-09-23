package com.xlccc.linkershiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlccc.linkershiro.dao.PermissionDao;
import com.xlccc.linkershiro.entity.Permission;
import com.xlccc.linkershiro.service.IPermissionService;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionDao, Permission> implements IPermissionService {
}
