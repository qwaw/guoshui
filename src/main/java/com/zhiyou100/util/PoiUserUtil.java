package com.zhiyou100.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou100.pojo.User;

public class PoiUserUtil {

	public static Workbook export(List<User> users) {
		HSSFWorkbook workbook=new HSSFWorkbook();
		HSSFSheet sheet=workbook.createSheet();
		
		HSSFRow rowName=sheet.createRow(0);
		rowName.createCell(0).setCellValue("用户ID");
		rowName.createCell(1).setCellValue("用户名");
		rowName.createCell(2).setCellValue("账号");
		rowName.createCell(3).setCellValue("部门");
		rowName.createCell(4).setCellValue("性别");
		rowName.createCell(5).setCellValue("邮箱");
		rowName.createCell(6).setCellValue("状态");
		
		for(int i=1;i<=users.size();i++) {
			HSSFRow row=sheet.createRow(i);
			row.createCell(0).setCellValue(""+users.get(i-1).getId());
			row.createCell(1).setCellValue(""+users.get(i-1).getName());
			row.createCell(2).setCellValue(""+users.get(i-1).getAccount());
			row.createCell(3).setCellValue(""+users.get(i-1).getDept());
			row.createCell(4).setCellValue(""+(users.get(i-1).isGender()? '男':'女'));
			row.createCell(5).setCellValue(""+users.get(i-1).getEmail());
			row.createCell(6).setCellValue(""+users.get(i-1).getState());
		}
		return workbook;
	}
	
	public static List<User> importFile(MultipartFile file) throws IOException{
		InputStream in=file.getInputStream();
		String name=file.getOriginalFilename();
		Workbook workbook=null;
		if(name.endsWith(".xls")) {
			workbook=new HSSFWorkbook(in);
		}else {
			workbook=new XSSFWorkbook(in);
		}
		List<User> users=new ArrayList<User>();
		Sheet sheet=workbook.getSheetAt(0);
		if(sheet.getRow(0).getPhysicalNumberOfCells()!=7) {
			return null;
		}else {
			for(int i=1;i<sheet.getPhysicalNumberOfRows();i++) {
				User user=new User();
				user.setId(sheet.getRow(i).getCell(0).getStringCellValue());
				user.setName(sheet.getRow(i).getCell(1).getStringCellValue());
				user.setAccount(sheet.getRow(i).getCell(2).getStringCellValue());
				user.setDept(sheet.getRow(i).getCell(3).getStringCellValue());
				user.setGender(sheet.getRow(i).getCell(4).getStringCellValue().equals("男")?true:false);
				user.setEmail(sheet.getRow(i).getCell(5).getStringCellValue());
				user.setState(sheet.getRow(i).getCell(6).getStringCellValue());
				users.add(user);
			}
			return users;
		}
	}
}
