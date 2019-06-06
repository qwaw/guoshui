package com.zhiyou100.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

	private String id;
	private String name;
	private String dept;
	private String account;
	private String password;
	private String headImg;
	private boolean gender;
	private String email;
	private String mobile;
	private Date birthday;
	private String state;
	private String memo;
	private List<Role> roles;
	private Set<String> rolesName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	//将属性中的role_id全部放到rolesName中
	public Set<String> getRolesName() {
		rolesName =new HashSet<>();
		if(roles!=null && roles.size()>0) {
			for(Role role:roles) {
				rolesName.add(role.getRole_id());
			}
		}
		return rolesName;
	}
	public void setRolesName(Set<String> rolesName) {
		this.rolesName = rolesName;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dept=" + dept + ", account=" + account + ", password="
				+ password + ", headImg=" + headImg + ", gender=" + gender + ", email=" + email + ", mobile=" + mobile
				+ ", birthday=" + birthday + ", state=" + state + ", memo=" + memo + ", roles=" + roles + ", rolesName="
				+ rolesName + "]";
	}

}
