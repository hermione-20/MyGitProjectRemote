package com.itheima.web.action;

import com.itheima.web.domain.User;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 动态参数封装,第二种情况：
 * 数据模型和动作类分开写
 * @author hermi
 *
 */
public class Demo3Action extends ActionSupport {
	//定义数据模型对象
	private User user;
	
	public String addUser() {
		System.out.println(user.getUsername()+","+user.getAge());
		return null;//不返回任合结果视图，NONE常量
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
