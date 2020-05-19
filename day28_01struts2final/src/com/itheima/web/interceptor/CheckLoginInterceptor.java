package com.itheima.web.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.itheima.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
/**
 * ����½��������
 * @author hermi
 *
 */
public class CheckLoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//1.��ȡsession����
		HttpSession session=ServletActionContext.getRequest().getSession();
		//2.��session������user����
		User user=(User) session.getAttribute("user");
		//3.����У��ͷ���
		if(user!=null) {
			return invocation.invoke();
		}else {
			//4.���û�У��ͷ��ص�½ҳ��
			return "login";
		}
	}

}
