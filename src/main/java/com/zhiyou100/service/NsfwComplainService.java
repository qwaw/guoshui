package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.pojo.Complain;
import com.zhiyou100.util.ResultUtil;

public interface NsfwComplainService {

	ResultUtil complainGetAnnualStatisticData(Integer year);

	List<Complain> selectAllComplain();

}
