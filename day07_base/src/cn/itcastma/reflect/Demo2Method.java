package cn.itcastma.reflect;

import java.lang.reflect.Method;

import org.junit.Test;



public class Demo2Method {

	@Test//public void m1
public void test1() throws Exception {
	student stu=new student();
	Class clazz=student.class;
	Method m=clazz.getMethod("m1");
	m.invoke(stu, null);//�˷�������Ҫִ��m��������һ����������ʾҪִ���ĸ������еķ������ڶ�������������ʵ�Ρ�
	
}
	
	@Test//public void m2(String name)
	public void test2() throws Exception {
		Class clazz=student.class;
		Method m=clazz.getMethod("m2",String.class);
		m.invoke(clazz.newInstance(), "tom");//�˷�������Ҫִ��m��������һ����������ʾҪִ���ĸ������еķ������ڶ�������������ʵ�Ρ�
		
	}
	
	@Test//public void m4(int age)
	public void test4() throws Exception {
		Class clazz=student.class;
		Method m=clazz.getDeclaredMethod("m4",int.class);//����private���͵���Ҫʹ��getDeclaredMethod��
		m.setAccessible(true);//����private���͵���Ҫ���
		m.invoke(clazz.newInstance(), 18);//invoke�����ķ���ֵ������ִ�з����ķ���ֵ�������void�ķ������򷵻�ֵ��null��
		
	}
	

	@Test//�õ����з���
	public void test7() throws Exception {
		Class clazz=student.class;
		Method[] ms=clazz.getMethods();//�õ����й��õķ���
		System.out.println(ms.length);
		
	}
}
