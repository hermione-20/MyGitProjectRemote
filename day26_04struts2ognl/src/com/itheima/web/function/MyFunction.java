package com.itheima.web.function;
/**
 * EL表达式的自定义方法
 * 1.编写一个普通类，提供一个实现功能的静态方法；
 * 2.在WEB-INF目录下创建一个拓展名为.tld的xml文件，文件不能放在classes和lib目录下；
 * EL表达式只能支持静态方法调用
 * 3.在jsp页面中使用taglib指令引入外部的标签库/方法库；
 * @author hermi
 *
 */
public class MyFunction {
	public static String toUpperCase(String str) {
		return str.toUpperCase();
	}

}
