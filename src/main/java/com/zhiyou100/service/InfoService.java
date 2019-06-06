package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.pojo.Info;

public interface InfoService {

	List<Info> getAllInfo();

	Info showInfoOne(String infoId);

}
