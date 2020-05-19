package com.itheima.web.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.itheima.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
/**
 * 检查登陆的拦截器
 * @author hermi
 *
 */
public class CheckLoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//1.获取session对象
		HttpSession session=ServletActionContext.getRequest().getSession();
		//2.在session域中找user对象
		User user=(User) session.getAttribute("user");
		//3.如果有，就放行
		if(user!=null) {
			return invocation.invoke();
		}else {
			//4.如果没有，就返回登陆页面
			return "login";
		}
	}

}
