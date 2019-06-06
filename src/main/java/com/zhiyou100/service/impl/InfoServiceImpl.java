package com.zhiyou100.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.InfoMapper;
import com.zhiyou100.mapper.UserMapper;
import com.zhiyou100.pojo.Info;
import com.zhiyou100.pojo.User;
import com.zhiyou100.service.InfoService;
import com.zhiyou100.service.UserService;

@Service
public class InfoServiceImpl implements InfoService{

	@Autowired
	InfoMapper infoMapper;

	@Override
	public List<Info> getAllInfo() {
		return infoMapper.getAllInfo();
	}

	@Override
	public Info showInfoOne(String infoId) {
		return infoMapper.showInfoOne(infoId);
	}

}
