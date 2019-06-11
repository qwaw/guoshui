package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.pojo.Role;
import com.zhiyou100.pojo.User;
import com.zhiyou100.util.ResultUtil;

public interface NsfwUserService {

	List<User> selectAllUsers(String userName);

	void addBatch(List<User> users);

	int userDeleteUser(String userId);

	ResultUtil userDeleteUsers(String[] userIds);

}
