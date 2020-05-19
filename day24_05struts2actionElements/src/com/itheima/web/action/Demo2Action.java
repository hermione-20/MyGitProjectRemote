package com.itheima.web.action;

import com.opensymphony.xwork2.Action;

/**
 * 创建动作类的第二种方式
 * 创建普通类，实现一个action接口，实现接口中的方法；
 * @author hermi
 *
 */
public class Demo2Action implements Action {

	/**
	 * action接口中的常量：
	 * SUCCESS    "success"   当执行成功后，前往指定的位置；
	 * NONE       "none"      不返回任合结果视图，和return null是一样的；
	 * ERROR      "error"     当执行动作方法，出现异常后，前往指定的位置；
	 * INPUT      "input"     数据回显
	 * LOGIN      "login"     一般用于返回登陆页面
	 */
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
