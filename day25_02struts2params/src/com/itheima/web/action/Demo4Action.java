package com.itheima.web.action;

import com.itheima.web.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 动态参数封装,第三种情况：模型驱动
 * 要想使用模型驱动，必须数据模型和动作类分开写
 * 
 * 模型驱动步骤：
 * 1.实现一个ModelDriven的接口；
 * 2.实现接口中的抽象方法getModel();
 * 3.在使用数据模型驱动的时候，必须由我们自己实例化
 * 
 * 是由ModelDriven拦截器为我们做的
 * 
 * 实际开发中采用的方式
 * 
 * @author hermi
 *
 */
public class Demo4Action extends ActionSupport implements ModelDriven<User> {
	//定义数据模型对象
	private User user=new User();//使用模型驱动，必须自己实例化模型对象
	
	//该方法返回的是数据模型
	public User getModel() {
		return user;
	}
	
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
