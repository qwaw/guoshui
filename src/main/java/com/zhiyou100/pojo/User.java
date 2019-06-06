package com.zhiyou100.pojo;

import java.util.Date;
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
	private Set<String> roleName;
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
	public Set<String> getRoleName() {
		return roleName;
	}
	public void setRoleName(Set<String> roleName) {
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dept=" + dept + ", account=" + account + ", password="
				+ password + ", headImg=" + headImg + ", gender=" + gender + ", email=" + email + ", mobile=" + mobile
				+ ", birthday=" + birthday + ", state=" + state + ", memo=" + memo + ", roles=" + roles + ", roleName="
				+ roleName + "]";
	}

}
