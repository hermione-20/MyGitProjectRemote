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
 * s:checkboxlist��ǩ��ʹ��
 * @author hermi
 *
 */
public class Demo6Action extends ActionSupport {
	//��ʼ�����õİ����б�
	private String[] hobbyarr=new String[] {"�Է�","˯��","д����"};
	
	//�û��ύ��ʱ�����ݷ�װ����������
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
