package com.xlccc.linkershiro.config;

import com.xlccc.linkershiro.entity.User;
import com.xlccc.linkershiro.service.IUserService;
import com.xlccc.linkershiro.service.impl.PermissionServiceImpl;
import com.xlccc.linkershiro.service.impl.RoleServiceImpl;
import com.xlccc.linkershiro.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Linker
 * @date 2020/9/23 21:25
 * @description：
 */
@Slf4j
public class AuthRealm extends AuthorizingRealm {

    @Resource
    private IUserService userService;

    /**
     * 授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //1.获取principalCollection中的用户
        User user = (User) principals.fromRealm(this.getClass().getName()).iterator().next();
        //2.通过数据库查询当前user的权限
        List<String> permissions = userService.selectPermissionByUserId(user.getId());
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //3.将权限放入shiro中
        simpleAuthorizationInfo.addStringPermissions(permissions);
        //4.返回
        return simpleAuthorizationInfo;
    }

    /**
     * 完成身份认证并返回认证信息
     * 认证失败则返回空
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.用户输入的Token
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        User user = userService.findUserByName(username);

        log.info("doGetAuthenticationInfo() 获取到的密码 -> {}", user.getPassword());

        return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
    }
}
