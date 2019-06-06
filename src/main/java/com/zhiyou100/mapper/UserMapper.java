package com.zhiyou100.mapper;

import com.zhiyou100.pojo.User;

public interface UserMapper {

	User findByName(String loginName);

}
