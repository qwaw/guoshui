package com.zhiyou100.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.NsfwUserMapper;
import com.zhiyou100.pojo.User;
import com.zhiyou100.service.NsfwUserService;
import com.zhiyou100.util.ResultUtil;

@Service
public class NsfwUserServiceImpl implements NsfwUserService{

	@Autowired
	NsfwUserMapper nsfwUserMapper;

	@Override
	public List<User> selectAllUsers(String userName) {

		return nsfwUserMapper.selectAllUsers(userName);
	}

	@Override
	public void addBatch(List<User> users) {
		
		for(int i=0;i<users.size();i++) {
			int num=nsfwUserMapper.addUser(users.get(i));
		}
	}

	@Override
	public int userDeleteUser(String userId) {

		return nsfwUserMapper.userDeleteUser(userId);
	}

	@Override
	public ResultUtil userDeleteUsers(String[] userIds) {
		for(int i=0;i<userIds.length;i++) {
			int num=nsfwUserMapper.userDeleteUser(userIds[i]);
		}
		return ResultUtil.success();
	}

}
