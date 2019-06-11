package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.pojo.Role;
import com.zhiyou100.pojo.User;
import com.zhiyou100.util.ResultUtil;

public interface NsfwService {

	List<Role> selectAllRoles(String selectName);
	
	int selectRoleByName(String roleName);

	int role_addRole(String name, String[] privilege, String state);

	List<User> selectAllUsers();

	Role roleEditUI(String roleId);

	int roleEditRole(String role_id,String name, String[] privilege, String state);

	int roleDeleteRole(String roleId);

	ResultUtil roleDeleteRoles(String[] roleIds);

}
