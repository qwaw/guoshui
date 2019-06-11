package com.zhiyou100.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhiyou100.pojo.Complain;

public interface NsfwComplainMapper {

	int selectCountByMonth(@Param("year") Integer year,@Param("month") int i);

	List<Complain> selectAllComplain();

	
}
