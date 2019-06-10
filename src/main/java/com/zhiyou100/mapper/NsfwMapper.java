package com.zhiyou100.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhiyou100.pojo.Role;
import com.zhiyou100.pojo.User;

public interface NsfwMapper {

	List<Role> selectAllRoles();

	int selectRoleByName(String roleName);

	int addRole(@Param("id")String id,@Param("name")String name, @Param("state")String state);

	int addRolePrivilege(@Param("roleId")String id, @Param("privilege")String privilege);

	List<User> selectAllUsers();

	Role roleEditUI(String roleId);

	int roleEditRole(@Param("role_id")String role_id, @Param("name")String name, @Param("state")String state);

	int deletePrivilege(String role_id);

	int roleDeleteRole(String roleId);

}
