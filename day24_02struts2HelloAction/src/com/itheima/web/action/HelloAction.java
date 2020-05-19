package com.itheima.web.action;
/**
 * Struts2的入门案例
 * @author hermi
 *
 */
public class HelloAction {//动作类
	
	/**
	 * 在动作类中指定的动作方法
	 * 动作方法的书写要求
	 *      1.都是public的；
	 *      2.返回值必须是一个String;
	 *      3.必须没有参数；
	 * @return
	 */
	public String sayHello() {
		System.out.println("HelloAction的sayHello方法执行了");
		return "success";//与struts.xml文件中result name的取值相对应
	}

}
