package com.itheima.web.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 使用ActionContext存数据
 * @author hermi
 *
 */
public class Demo1Action extends ActionSupport {
	public String execute() {
		//1.得到ActionContext对象
		ActionContext context=ActionContext.getContext();//这是从当前线程的局部变量中获取引用
		//2.往map中存入数据
		context.put("contextMap", "HelloContextMap");//把数据存到了大map中
		
		//往session中存数据
		//第一种方式：获取key为session的map
		Map<String,Object> sessionAttribute=context.getSession();//得到key为session的小map；
		sessionAttribute.put("sessionMap", "helloSessionMap");
		
		//第二种方式：直接使用原始的HttpSession对象
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("sessionMap1", "helloSessionMap1");
		
		//往servletContext域中存数据
		//第一种方式：获取key为application的map
		Map<String,Object> applicationAttribute=context.getApplication();
		applicationAttribute.put("applicationMap", "hello applicationMap");
		//第二种方式，获取servletContext对象
		ServletContext application=ServletActionContext.getServletContext();
		application.setAttribute("applicationMap1", "hello applicationMap1");
		return SUCCESS;
	}

}
