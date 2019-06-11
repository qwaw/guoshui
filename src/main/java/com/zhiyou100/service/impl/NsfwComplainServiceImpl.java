package com.zhiyou100.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.NsfwComplainMapper;
import com.zhiyou100.pojo.Complain;
import com.zhiyou100.pojo.FusionCharts;
import com.zhiyou100.service.NsfwComplainService;
import com.zhiyou100.util.ResultUtil;

@Service
public class NsfwComplainServiceImpl implements NsfwComplainService{
	@Autowired
	NsfwComplainMapper nsfwComplainMapper;
	
	@Override
	public ResultUtil complainGetAnnualStatisticData(Integer year) {
		List<FusionCharts> fusionCharts = new ArrayList<>();
		for(int i = 1 ; i <= 12 ; i ++ ){
			int num = nsfwComplainMapper.selectCountByMonth( year,i);
			fusionCharts.add(new FusionCharts(""+i , ""+num ));
		}
		
		return ResultUtil.success("" , fusionCharts);
	}

	@Override
	public List<Complain> selectAllComplain() {
		// TODO Auto-generated method stub
		return nsfwComplainMapper.selectAllComplain();
	}

}
