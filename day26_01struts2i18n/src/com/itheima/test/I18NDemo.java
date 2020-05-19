package com.itheima.test;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

/**
 * 国际化的小测试
 * @author hermi
 *
 */
public class I18NDemo {
	@Test
	public void test1() {
		//使用ResourceBundle的getBundle方法获取一个对象，参数使用：消息资源包资源路径+名称和所处的语言环境
		//注意在给定消息资源包路径时，不需要指定语言代码和国家代码。
		ResourceBundle bundle=ResourceBundle.getBundle("com.itheima.resource.message",Locale.CHINA);
		String key=bundle.getString("key");
		System.out.println(key);
	
	}

}
