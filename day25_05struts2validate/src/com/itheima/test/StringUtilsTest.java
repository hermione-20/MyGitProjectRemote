package com.itheima.test;

import org.apache.commons.lang3.StringUtils;
/**
 * 针对java.lang包中String的扩展
 * @author hermi
 *
 */
public class StringUtilsTest {
	public static void main(String[] args) {
		String s1=null;
		String s2="";
		String s3="    ";
		//isEmpty验证字符串是否为null或者空字符串，但是不去空格；
		//以下结果为true. true,false;
		System.out.println(StringUtils.isEmpty(s1));
		System.out.println(StringUtils.isEmpty(s2));
		System.out.println(StringUtils.isEmpty(s3));
		
		
		//isBlank验证字符串是否为null或者空字符串，去空格；
		//以下结果为true. true,true;
		System.out.println(StringUtils.isBlank(s1));
		System.out.println(StringUtils.isBlank(s2));
		System.out.println(StringUtils.isBlank(s3));
	}

}
