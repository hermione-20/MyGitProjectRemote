package com.itheima.web.action;

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
 * Struts2��EL���ʽ�ĸı�
 * @author hermi
 *
 */
public class Demo3Action extends ActionSupport {
	//���Ƕ������е����ԣ�������Ķ�������Ĭ������valueStack��ջ��
	private String name="�������е�name";
	
	public String execute() {
//		HttpServletRequest request=ServletActionContext.getRequest();
//		request.setAttribute("name","�������е�name");//�����ڴ�Map��һ��keyΪrequest��СMap�е�
		
//		ServletContext application=ServletActionContext.getServletContext();
//		application.setAttribute("name", "Ӧ�����е�name");
//		
		//��ȡActionContext����
		ActionContext context=ActionContext.getContext();
		context.put("name", "ActionContext�е�name");
		return SUCCESS;
	}


//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
}
