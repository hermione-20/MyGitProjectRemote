package com.itheima.demo3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRunner {
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		//�鿴�������еķ������ĸ���@Mytest��ִ���ĸ�����
		//�õ�Ҫִ�е����class����
		Class clazz=SomeDaoImpl.class;
		//�õ����еķ��������������к͸����е����й����ķ���
		Method[]methods=clazz.getMethods();
		//�������з���
		for (Method m : methods) {
			//�жϵ�ǰ�������Ƿ���@Mytestע��
			m.isAnnotationPresent(Mytest.class);
			//System.out.println(m.getName()+"����ǰ�����Ƿ���ע��"+isExistsAnno);
			if (m.isAnnotationPresent(Mytest.class)){
				m.invoke(clazz.newInstance(),null);
				
			}
		
		}
	}

}
