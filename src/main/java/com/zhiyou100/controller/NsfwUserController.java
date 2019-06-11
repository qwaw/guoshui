package com.zhiyou100.controller;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou100.pojo.User;
import com.zhiyou100.service.NsfwUserService;
import com.zhiyou100.util.PoiUserUtil;
import com.zhiyou100.util.ResultUtil;

@Controller
@RequestMapping("/nsfw/user")
public class NsfwUserController {

	@Autowired
	NsfwUserService nsfwUserService;
	
	@RequestMapping("/listUI")
	public String user_listUI(String userName,HttpSession session, @RequestParam(required=true,defaultValue="1")Integer pageNum) {
		PageHelper.startPage(pageNum,5);
		List<User> users=nsfwUserService.selectAllUsers(userName);
		PageInfo<User> pageInfo=new PageInfo<>(users);
		session.setAttribute("userPage", pageInfo);
		return "nsfw/user/listUI";
	}
	
	@RequestMapping("/deleteUser")
	public String user_deleteUser(String userId) {
		int num=nsfwUserService.userDeleteUser(userId);
		return "nsfw/user/listUI";
	}
	
	@RequestMapping("/deleteUsers")
	@ResponseBody
	public ResultUtil userDeleteUsers(String userIds [] ){
		return nsfwUserService.userDeleteUsers(userIds);
	}

	//导出Excel
	@RequestMapping("/exportExcel")
	public void exportExcel(String userName,@RequestParam(required=true , defaultValue="1") Integer pageNum , HttpServletResponse response){
		PageHelper.startPage(pageNum, 5);
		List<User> users = nsfwUserService.selectAllUsers(userName);
		response.setContentType("application/vnd.ms-excel");
        // 传递中文参数编码
        String codedFileName;
		try {
			codedFileName = java.net.URLEncoder.encode("中文","UTF-8");
			response.setHeader("content-disposition", "attachment;filename=" + codedFileName + ".xls");
	        Workbook workbook = PoiUserUtil.export(users);
	        OutputStream fOut = response.getOutputStream();
	        workbook.write(fOut); 
	        fOut.flush();  
	        fOut.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//导入Excel
	@RequestMapping("/importExcel")
	public String importExcel(MultipartFile file,HttpServletRequest request){
//		System.out.println("fileName："+file.getOriginalFilename());
		try {
			List<User> users=PoiUserUtil.importFile(file);
			if(users==null || users.size()<1) {
				request.setAttribute("addUsersErrorMsg", "导入文件格式不正确");
				return "error";
			}
			nsfwUserService.addBatch(users);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "nsfw/user/listUI";
	}
}
