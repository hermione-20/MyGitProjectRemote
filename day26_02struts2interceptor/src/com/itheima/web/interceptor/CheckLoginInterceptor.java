package com.itheima.web.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
/**
 * 检查登陆的拦截器,初级版本
 */
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckLoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//1.获取httpSession
		HttpSession session=ServletActionContext.getRequest().getSession();
		//2.判断session域中的登陆标记
		Object obj=session.getAttribute("user");
		//3.判断是否有登录标记
		if(obj==null) {
			//用户没有登录
			return "input";	
		}
		//4.用户登陆了，放行
		String rtValue=invocation.invoke();
		return rtValue;
		
	}

}
