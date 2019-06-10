package com.zhiyou100.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou100.pojo.User;
import com.zhiyou100.service.NsfwUserService;

@Controller
@RequestMapping("/nsfw/user")
public class NsfwUserController {

	@Autowired
	NsfwUserService nsfwUserService;
	
	@RequestMapping("/userListUI")
	public String user_listUI(HttpSession session, @RequestParam(required=true,defaultValue="1")Integer pageNum) {
		PageHelper.startPage(pageNum,5);
		List<User> users=nsfwUserService.selectAllUsers();
		PageInfo<User> pageInfo=new PageInfo<>(users);
		session.setAttribute("userPage", pageInfo);
		return "nsfw/user/listUI";
	}
}
