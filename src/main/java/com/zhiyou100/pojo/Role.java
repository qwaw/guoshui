package com.zhiyou100.pojo;

import java.util.List;
import java.util.Set;

public class Role {

	private String role_id;
	private String name;
	private String state;
	private List<Privilege> privileges;
	private Set<String> privilegeName;
	
	public List<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Set<String> getPrivilegeName() {
		return privilegeName;
	}
	public void setPrivilegeName(Set<String> privilegeName) {
		this.privilegeName = privilegeName;
	}
	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", name=" + name + ", state=" + state + ", privileges=" + privileges
				+ ", privilegeName=" + privilegeName + "]";
	}

}
