package com.itheima.test;

import org.apache.commons.lang3.StringUtils;
/**
 * ���java.lang����String����չ
 * @author hermi
 *
 */
public class StringUtilsTest {
	public static void main(String[] args) {
		String s1=null;
		String s2="";
		String s3="    ";
		//isEmpty��֤�ַ����Ƿ�Ϊnull���߿��ַ��������ǲ�ȥ�ո�
		//���½��Ϊtrue. true,false;
		System.out.println(StringUtils.isEmpty(s1));
		System.out.println(StringUtils.isEmpty(s2));
		System.out.println(StringUtils.isEmpty(s3));
		
		
		//isBlank��֤�ַ����Ƿ�Ϊnull���߿��ַ�����ȥ�ո�
		//���½��Ϊtrue. true,true;
		System.out.println(StringUtils.isBlank(s1));
		System.out.println(StringUtils.isBlank(s2));
		System.out.println(StringUtils.isBlank(s3));
	}

}
