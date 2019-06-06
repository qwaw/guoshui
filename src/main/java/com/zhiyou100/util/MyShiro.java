package com.zhiyou100.util;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhiyou100.pojo.Role;
import com.zhiyou100.pojo.User;
import com.zhiyou100.service.UserService;

@Component
public class MyShiro extends AuthorizingRealm{

	@Autowired
	UserService userService;
	
	//认证权限
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		//获取登录时输入的用户名
		String loginName=(String) principalCollection.fromRealm(getName()).iterator().next();
		//检查数据库中是否存在该用户
		User user=userService.findByName(loginName);
		if(user!=null) {
			//使用权限信息对象来存放查看出的用户的角色及权限
			SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
			//查询用户的角色
			info.setRoles(user.getRoleName());
			//通过角色得到用户的权限、
			List<Role> roles=user.getRoles();
			for(Role role:roles) {
				info.addStringPermissions(role.getPrivilegeName());
			}
			return info;
		}
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		//使用token保存提交的登录信息
		UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;
		//去数据库中检查是否有此用户
		User user=userService.findByName(token.getUsername());
		if(user!=null) {
			//若存在该用户，则放到登录认证info中
			return new SimpleAuthenticationInfo(user.getName(),user.getPassword(),getName());
		}
		return null;
	}

}
