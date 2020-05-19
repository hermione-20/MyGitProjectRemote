package com.itheima.web.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.itheima.domain.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
/**
 * s:checkboxlist标签的使用
 * @author hermi
 *
 */
public class Demo6Action extends ActionSupport {
	//初始化表单用的爱好列表
	private String[] hobbyarr=new String[] {"吃饭","睡觉","写代码"};
	
	//用户提交表单时的数据封装到此属性中
	private String hobby;
	
	public String save() {
		System.out.println(hobby);
		System.out.println(hobbyarr);

		return null;
	}

	public String[] getHobbyarr() {
		return hobbyarr;
	}

	public void setHobbyarr(String[] hobbyarr) {
		this.hobbyarr = hobbyarr;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	
}
