package com.itheima.web.action;
/**
 * Struts2�����Ű���
 * @author hermi
 *
 */
public class HelloAction {//������
	
	/**
	 * �ڶ�������ָ���Ķ�������
	 * ������������дҪ��
	 *      1.����public�ģ�
	 *      2.����ֵ������һ��String;
	 *      3.����û�в�����
	 * @return
	 */
	public String sayHello() {
		System.out.println("HelloAction��sayHello����ִ����");
		return "success";//��struts.xml�ļ���result name��ȡֵ���Ӧ
	}

}
