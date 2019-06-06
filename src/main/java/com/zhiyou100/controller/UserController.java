package com.zhiyou100.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;
import com.zhiyou100.pojo.User;
import com.zhiyou100.pojo.Info;
import com.zhiyou100.service.InfoService;
import com.zhiyou100.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	InfoService infoService;
	
	@RequestMapping("/getUsers")
	public User getUsers(String username) {
		
		return userService.findByName(username);
	}
	
	//shiro验证跳转
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "loginUI";
	}
	
	//直接请求的路径
	@RequestMapping(value="/login1",method=RequestMethod.POST)
	public String login1(User user,RedirectAttributes redirectAttributes,HttpSession session) {
		try {
			System.out.println(user.getName());
			SecurityUtils.getSubject().login(new UsernamePasswordToken(user.getName(),user.getPassword()));
			session.setAttribute("username", user.getName());
			return "redirect:/gzzy";
		} catch (Exception e) {
			redirectAttributes.addAttribute("msg","用户名或密码错误");
			return "redirect:/login";
		}

	}
	
	//退出登录
	@RequestMapping("/loginOut")
	public String loginOut(RedirectAttributes redirectAttributes) {
		SecurityUtils.getSubject().logout();
		redirectAttributes.addAttribute("msg","您已安全退出");
		return "redirect:/login";
	}
	
	@RequestMapping("/403")
	public String login403() {
		return "noPermissionUI";
	}
	
	@RequestMapping("/gzzy")
	public String user(HttpSession session) {
		String name=(String) session.getAttribute("username");
		//获取当前个人信息
		User user=userService.findByName(name);
		session.setAttribute("user", user);
		//获取当前公告
		List<Info> infos=infoService.getAllInfo();
		session.setAttribute("infos", infos);
		return "home/home";
	}
}
