package com.zhiyou100.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.UserMapper;
import com.zhiyou100.pojo.User;
import com.zhiyou100.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper userMapper;

	@Override
	public User findByName(String loginName) {
		if (loginName!=null && loginName.isEmpty()) {
			return userMapper.findByName(loginName);
		}else {
			return null;
		}

	}
}
