package com.itheima.web.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public  class CheckLoginInterceptor1 extends MethodFilterInterceptor {

	/**
	 * ����½�������������հ汾
	 */
	private static final long serialVersionUID = 1L;

	public String doIntercept(ActionInvocation invocation) throws Exception {
		//1.��ȡhttpSession
		HttpSession session=ServletActionContext.getRequest().getSession();
		//2.�ж�session���еĵ�½���
		Object obj=session.getAttribute("user");
		//3.�ж��Ƿ��е�¼���
		if(obj==null) {
			//�û�û�е�¼
			return "input";	
		}
		//4.�û���½�ˣ�����
		String rtValue=invocation.invoke();
		return rtValue;
		
	}

}
