package com.itheima.web.action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * ��̬������װ
 * @author hermi
 *
 */
public class Demo1Action extends ActionSupport {
	private String username;
	private int age;
	public String addUser() {
		System.out.println(username+","+age);
		return null;//�������κϽ����ͼ��NONE����
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
