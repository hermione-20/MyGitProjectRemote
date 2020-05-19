package com.itheima.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * 自定义拦截器
 * 1.新建一个普通类，继承AbstractInterceptor类，实现一个抽象方法intercept；
 * 2。在struts.xml中配置拦截器
 * 2.1声明拦截器
 * 2.2使用拦截器
 * @author hermi
 *
 */
public class Demo2Interceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("Demo2Interceptor拦截器：拦截了,执行动作方法之前");
		//放行.如果有下一个拦截器，就到达下一个拦截器，如果没有，就到达动作方法
		String rtValue =invocation.invoke();//就是结果视图的名称
		System.out.println("Demo2Interceptor拦截器：拦截了,执行动作方法之后");
		System.out.println(rtValue);
		return rtValue;
	}

}
