package com.itheima.web.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * ʹ��ActionContext������
 * @author hermi
 *
 */
public class Demo1Action extends ActionSupport {
	public String execute() {
		//1.�õ�ActionContext����
		ActionContext context=ActionContext.getContext();//���Ǵӵ�ǰ�̵߳ľֲ������л�ȡ����
		//2.��map�д�������
		context.put("contextMap", "HelloContextMap");//�����ݴ浽�˴�map��
		
		//��session�д�����
		//��һ�ַ�ʽ����ȡkeyΪsession��map
		Map<String,Object> sessionAttribute=context.getSession();//�õ�keyΪsession��Сmap��
		sessionAttribute.put("sessionMap", "helloSessionMap");
		
		//�ڶ��ַ�ʽ��ֱ��ʹ��ԭʼ��HttpSession����
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("sessionMap1", "helloSessionMap1");
		
		//��servletContext���д�����
		//��һ�ַ�ʽ����ȡkeyΪapplication��map
		Map<String,Object> applicationAttribute=context.getApplication();
		applicationAttribute.put("applicationMap", "hello applicationMap");
		//�ڶ��ַ�ʽ����ȡservletContext����
		ServletContext application=ServletActionContext.getServletContext();
		application.setAttribute("applicationMap1", "hello applicationMap1");
		return SUCCESS;
	}

}
