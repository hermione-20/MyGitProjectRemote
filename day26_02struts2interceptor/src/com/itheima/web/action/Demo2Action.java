package com.itheima.web.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Demo2Action extends ActionSupport {
	/**
	 * �û���¼�ķ���
	 * @return
	 */
	public String login() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("user", "test");
		return SUCCESS;
	}
	/**
	 * ������ʾ��ҳ������һ��ҳ�涼ִ�д˷���������SUCCESS��
	 */
	public String execute() {
		return SUCCESS;
	}

}
