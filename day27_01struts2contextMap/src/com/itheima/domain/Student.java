package com.itheima.domain;

import java.io.Serializable;
/**
 * ��ʾֵջ�Ĵ�ȡ
 * @author hermi
 *
 */
public class Student implements Serializable {
	private String name;
	private int age;
	
	
	public Student() {
		
	}
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
