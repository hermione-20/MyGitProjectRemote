package com.itheima.web.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
/**
 * ����½��������,�����汾
 */
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckLoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
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
