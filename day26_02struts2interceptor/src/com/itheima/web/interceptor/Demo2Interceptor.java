package com.itheima.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * �Զ���������
 * 1.�½�һ����ͨ�࣬�̳�AbstractInterceptor�࣬ʵ��һ�����󷽷�intercept��
 * 2����struts.xml������������
 * 2.1����������
 * 2.2ʹ��������
 * @author hermi
 *
 */
public class Demo2Interceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("Demo2Interceptor��������������,ִ�ж�������֮ǰ");
		//����.�������һ�����������͵�����һ�������������û�У��͵��ﶯ������
		String rtValue =invocation.invoke();//���ǽ����ͼ������
		System.out.println("Demo2Interceptor��������������,ִ�ж�������֮��");
		System.out.println(rtValue);
		return rtValue;
	}

}
