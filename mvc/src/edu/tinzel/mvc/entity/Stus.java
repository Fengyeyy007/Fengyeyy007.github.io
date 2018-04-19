package edu.tinzel.mvc.entity;

import java.io.Serializable;

public class Stus implements Serializable {
	private int id;
	private String name;
	private String pwd;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Stus(int id, String name, String pwd, int age) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.age = age;
	}
	public Stus(String name, String pwd, int age) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.age = age;
	}
	public Stus() {
		super();
	}
	@Override
	public String toString() {
		return "Stus [id=" + id + ", name=" + name + ", pwd=" + pwd + ", age="
				+ age + "]";
	}
	
}
