package com.zhiyou100.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.pojo.User;
import com.zhiyou100.service.UserService;

import net.sf.jsqlparser.statement.create.table.Index;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/getUsers")
	public User getUsers(String username) {
		
		return userService.findByName(username);
	}
	
	@RequestMapping("/login")
	public String login() {
		return "loginUI";
	}
}
