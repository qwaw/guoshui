package com.zhiyou100.mapper;

import java.util.List;

import com.zhiyou100.pojo.Info;

public interface InfoMapper {

	List<Info> getAllInfo();

	Info showInfoOne(String infoId);

}
