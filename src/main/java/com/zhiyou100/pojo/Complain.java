package com.zhiyou100.pojo;

import java.util.Date;

public class Complain {

	private String comp_id;
	private String comp_company;
	private String comp_name;
	private String comp_mobile;
	private Integer is_NM;
	private Date comp_time;
	private String comp_title;
	private String to_comp_name;
	private String to_comp_dept;
	private String comp_content;
	private String state;
	
	public String getComp_id() {
		return comp_id;
	}
	public void setComp_id(String comp_id) {
		this.comp_id = comp_id;
	}
	public String getComp_company() {
		return comp_company;
	}
	public void setComp_company(String comp_company) {
		this.comp_company = comp_company;
	}
	public String getComp_name() {
		return comp_name;
	}
	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}
	public String getComp_mobile() {
		return comp_mobile;
	}
	public void setComp_mobile(String comp_mobile) {
		this.comp_mobile = comp_mobile;
	}
	public Integer getIs_NM() {
		return is_NM;
	}
	public void setIs_NM(Integer is_NM) {
		this.is_NM = is_NM;
	}
	public Date getComp_time() {
		return comp_time;
	}
	public void setComp_time(Date comp_time) {
		this.comp_time = comp_time;
	}
	public String getComp_title() {
		return comp_title;
	}
	public void setComp_title(String comp_title) {
		this.comp_title = comp_title;
	}
	public String getTo_comp_name() {
		return to_comp_name;
	}
	public void setTo_comp_name(String to_comp_name) {
		this.to_comp_name = to_comp_name;
	}
	public String getTo_comp_dept() {
		return to_comp_dept;
	}
	public void setTo_comp_dept(String to_comp_dept) {
		this.to_comp_dept = to_comp_dept;
	}
	public String getComp_content() {
		return comp_content;
	}
	public void setComp_content(String comp_content) {
		this.comp_content = comp_content;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Complain [comp_id=" + comp_id + ", comp_company=" + comp_company + ", comp_name=" + comp_name
				+ ", comp_mobile=" + comp_mobile + ", is_NM=" + is_NM + ", comp_time=" + comp_time + ", comp_title="
				+ comp_title + ", to_comp_name=" + to_comp_name + ", to_comp_dept=" + to_comp_dept + ", comp_content="
				+ comp_content + ", state=" + state + "]";
	}
	
}
