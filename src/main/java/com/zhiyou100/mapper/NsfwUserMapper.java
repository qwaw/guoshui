package com.zhiyou100.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhiyou100.pojo.Role;
import com.zhiyou100.pojo.User;

public interface NsfwUserMapper {

	List<User> selectAllUsers(String userName);

	int addUser(User user);

	int userDeleteUser(String userId);

}
