package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.pojo.Role;
import com.zhiyou100.pojo.User;

public interface NsfwService {

	List<Role> selectAllRoles();
	
	int selectRoleByName(String roleName);

	int role_addRole(String name, String[] privilege, String state);

	List<User> selectAllUsers();

	Role roleEditUI(String roleId);

	int roleEditRole(String role_id,String name, String[] privilege, String state);

	int roleDeleteRole(String roleId);

}
