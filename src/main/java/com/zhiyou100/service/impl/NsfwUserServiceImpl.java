package com.zhiyou100.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.NsfwUserMapper;
import com.zhiyou100.pojo.User;
import com.zhiyou100.service.NsfwUserService;

@Service
public class NsfwUserServiceImpl implements NsfwUserService{

	@Autowired
	NsfwUserMapper nsfwUserMapper;

	@Override
	public List<User> selectAllUsers() {

		return nsfwUserMapper.selectAllUsers();
	}

}
