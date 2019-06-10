package com.zhiyou100.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.pojo.Info;
import com.zhiyou100.service.InfoService;

@Controller
public class InfoController {

	@Autowired
	InfoService infoService;
	
	@RequestMapping("/gzzy/showInfoOne")
	public String showInfoOne(String infoId,HttpSession session) {
		//获取当前公告
		Info info=infoService.showInfoOne(infoId);
		session.setAttribute("infoOne", info);
		return "home/infoViewUI";
	}
}
