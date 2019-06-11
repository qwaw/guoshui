package com.zhiyou100.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou100.pojo.Complain;
import com.zhiyou100.service.NsfwComplainService;
import com.zhiyou100.util.ResultUtil;

@Controller
@RequestMapping("/nsfw/complain")
public class NsfwComplainController {

	@Autowired
	NsfwComplainService nsfwComplainService;
	
	@RequestMapping("/listUI")
	public String listUI(HttpSession session, @RequestParam(required=true,defaultValue="1")Integer pageNum){
		PageHelper.startPage(pageNum,5);
		List<Complain> complain=nsfwComplainService.selectAllComplain();
		PageInfo<Complain> pageInfo=new PageInfo<>(complain);
		session.setAttribute("complainPage", pageInfo);
		return "nsfw/complain/listUI";
	}
	
	@RequestMapping("/annualStatisticChartUI")
	public String annualStatisticChartUI(){
		return "nsfw/complain/annualStatisticChartUI";
	}
	
	@RequestMapping("/complainGetAnnualStatisticData")
	@ResponseBody
	public ResultUtil complainGetAnnualStatisticData(Integer year ){
		return nsfwComplainService.complainGetAnnualStatisticData(year);
	}
}
