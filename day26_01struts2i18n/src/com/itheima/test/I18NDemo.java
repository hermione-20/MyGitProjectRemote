package com.itheima.test;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

/**
 * ���ʻ���С����
 * @author hermi
 *
 */
public class I18NDemo {
	@Test
	public void test1() {
		//ʹ��ResourceBundle��getBundle������ȡһ�����󣬲���ʹ�ã���Ϣ��Դ����Դ·��+���ƺ����������Ի���
		//ע���ڸ�����Ϣ��Դ��·��ʱ������Ҫָ�����Դ���͹��Ҵ��롣
		ResourceBundle bundle=ResourceBundle.getBundle("com.itheima.resource.message",Locale.CHINA);
		String key=bundle.getString("key");
		System.out.println(key);
	
	}

}
