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
import com.zhiyou100.pojo.Role;
import com.zhiyou100.pojo.User;
import com.zhiyou100.service.NsfwService;
import com.zhiyou100.util.ResultUtil;

@Controller
@RequestMapping("/nsfw")
public class NsfwController {

	@Autowired
	NsfwService nsfwService;
	
	@RequestMapping("/frame")
	public String frame() {
		return "nsfw/frame";
	}
	
	@RequestMapping("/home_top")
	public String home_top() {
		return "nsfw/top";
	}
	
	@RequestMapping("/home_left")
	public String home_left() {
		return "nsfw/left";
	}
	
	@RequestMapping("/role/addUI")
	public String role_addUI() {
		return "nsfw/role/addUI";
	}
	
	@RequestMapping("/user/addUI")
	public String user_addUI() {
		return "nsfw/user/addUI";
	}
	
	@RequestMapping("/role/listUI")
	public String role_listUI(HttpSession session, @RequestParam(required=true,defaultValue="1")Integer pageNum) {
		PageHelper.startPage(pageNum,5);
		List<Role> roles=nsfwService.selectAllRoles();
		PageInfo<Role> pageInfo=new PageInfo<>(roles);
		session.setAttribute("rolePage", pageInfo);
		return "nsfw/role/listUI";
	}

	@RequestMapping("/role/getRoleNames")
	@ResponseBody
	public ResultUtil role_getRoleNames(String roleName) {
		int num=nsfwService.selectRoleByName(roleName);
		if(num>0) {
			return ResultUtil.error("当前用户已存在");
		}else {
			return ResultUtil.success("当前用户可以创建", null);
		}
	}
	
	@RequestMapping("/role/addRole")
	public String role_addRole(String name,String[] privilege,String state) {
		int num=nsfwService.role_addRole(name,privilege,state);
		if(num>0) {
			return "nsfw/role/listUI";
		}else {
			return "nsfw/role/addUI";
		}
	}
	
	@RequestMapping("/role/editUI")
	public String role_editUI(String roleId,HttpSession session) {
		Role role=nsfwService.roleEditUI(roleId);
		System.out.println(role);
		session.setAttribute("roleEdit", role);
		return "nsfw/role/editUI";
	}
	
	@RequestMapping("/role/editRole")
	public String role_edit(HttpSession session,String role_id,String name,String[] privilege,String state) {
		int num=nsfwService.roleEditRole(role_id,name,privilege,state);
		return "nsfw/role/listUI";
	}
	
	@RequestMapping("/role/deleteRole")
	public String role_deleteRole(String roleId) {
		int num=nsfwService.roleDeleteRole(roleId);
		return "nsfw/role/listUI";
	}

}
