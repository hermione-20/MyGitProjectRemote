package com.itheima.web.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ��ȡservletAPI
 * ��ʽһ��ʹ�õ���ServletActionContext;�Ƽ����ַ�ʽ
 * ��ʽ����ʹ�õ�������ע�����ʽ����������Ҫ�Ķ���ע�����������һ��������Ϊ��������
 * @author hermi
 *
 */
public class Demo1Action extends ActionSupport implements ServletRequestAware,ServletResponseAware,ServletContextAware {
	private HttpServletRequest request;
	 private HttpServletResponse response;
	 private ServletContext application;
	 public String execute() {
	  
		//HttpServletRequest request=ServletActionContext.getRequest();
		//HttpServletResponse response=ServletActionContext.getResponse();
		//ServletContext application=ServletActionContext.getServletContext();
		HttpSession session=request.getSession();
		System.out.println(request);
		System.out.println(response);
		System.out.println(application);
		System.out.println(session);
		return null;
	}
	@Override
	public void setServletContext(ServletContext application) {
		this.application=application;
		
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		
	}

}
