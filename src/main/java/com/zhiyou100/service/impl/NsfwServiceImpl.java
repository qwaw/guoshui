package com.zhiyou100.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.NsfwMapper;
import com.zhiyou100.pojo.Role;
import com.zhiyou100.pojo.User;
import com.zhiyou100.service.NsfwService;
import com.zhiyou100.util.FileIdUtil;
import com.zhiyou100.util.ResultUtil;

@Service
public class NsfwServiceImpl implements NsfwService{

	@Autowired
	NsfwMapper nsfwMapper;

	@Override
	public List<Role> selectAllRoles(String selectName) {

		return nsfwMapper.selectAllRoles(selectName);
	}

	@Override
	public int selectRoleByName(String roleName) {

		return nsfwMapper.selectRoleByName(roleName);
	}

	@Override
	public int role_addRole(String name, String[] privilege, String state) {
		String id=FileIdUtil.getId();
		int num=nsfwMapper.addRole(id,name,state);
		if(num>0) {
			for(int i=0;i<privilege.length;i++) {
				int num1=nsfwMapper.addRolePrivilege(id,privilege[i]);
			}
			return 1;
		}
		return 0;
	}

	@Override
	public List<User> selectAllUsers() {

		return nsfwMapper.selectAllUsers();
	}

	@Override
	public Role roleEditUI(String roleId) {

		return nsfwMapper.roleEditUI(roleId);
	}

	@Override
	public int roleEditRole(String role_id,String name, String[] privilege, String state) {
		int num=nsfwMapper.roleEditRole(role_id,name,state);
		if (num>0) {
			int num1=nsfwMapper.deletePrivilege(role_id);
			for(int i=0;i<privilege.length;i++) {
				int num2=nsfwMapper.addRolePrivilege(role_id,privilege[i]);
			}
			return 1;
		}
		return 0;
	}

	@Override
	public int roleDeleteRole(String roleId) {
		// TODO Auto-generated method stub
		return nsfwMapper.roleDeleteRole(roleId);
	}

	@Override
	public ResultUtil roleDeleteRoles(String[] roleIds) {
		for(int i = 0 ; i < roleIds.length ; i ++){
			int num = nsfwMapper.roleDeleteRole(roleIds[i]);
		}
		return ResultUtil.success();
	}

}
