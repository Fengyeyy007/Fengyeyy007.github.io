package edu.tinzel.mvccompany.entity;

import java.io.Serializable;

public class Company implements Serializable {
	private int cmpId;
	private String cmpName;
	private String cmpPwd;
	private String cmpEmail;
	public int getCmpId() {
		return cmpId;
	}
	public void setCmpId(int cmpId) {
		this.cmpId = cmpId;
	}
	public String getCmpName() {
		return cmpName;
	}
	public void setCmpName(String cmpName) {
		this.cmpName = cmpName;
	}
	public String getCmpPwd() {
		return cmpPwd;
	}
	public void setCmpPwd(String cmpPwd) {
		this.cmpPwd = cmpPwd;
	}
	public String getCmpEmail() {
		return cmpEmail;
	}
	public void setCmpEmail(String cmpEmail) {
		this.cmpEmail = cmpEmail;
	}
	public Company(int cmpId, String cmpName, String cmpPwd, String cmpEmail) {
		super();
		this.cmpId = cmpId;
		this.cmpName = cmpName;
		this.cmpPwd = cmpPwd;
		this.cmpEmail = cmpEmail;
	}
	public Company(String cmpName, String cmpPwd, String cmpEmail) {
		super();
		this.cmpName = cmpName;
		this.cmpPwd = cmpPwd;
		this.cmpEmail = cmpEmail;
	}
	public Company() {
		super();
	}
	@Override
	public String toString() {
		return "Company [cmpId=" + cmpId + ", cmpName=" + cmpName + ", cmpPwd="
				+ cmpPwd + ", cmpEmail=" + cmpEmail + "]";
	}
	
}
