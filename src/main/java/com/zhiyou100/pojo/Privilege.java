package com.zhiyou100.pojo;

public class Privilege {

	private String role_id;
	private String code;
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "Privilege [role_id=" + role_id + ", code=" + code + "]";
	}
	
}
