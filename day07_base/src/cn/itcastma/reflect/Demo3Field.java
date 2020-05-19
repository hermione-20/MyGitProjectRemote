package cn.itcastma.reflect;

import java.lang.reflect.Field;

import org.junit.Test;


public class Demo3Field {
	@Test//������������name
	public void test1() throws Exception, Exception {
		student stu=new student();
		Class clazz=student.class;
		Field f=clazz.getField("name");
		System.out.println(f.get(stu));
		
		f.set(stu, "����");
		Field f1=clazz.getField("name");
		System.out.println(f1.get(stu));
		
	}
	
	@Test//����˽�б���name
	public void test2() throws Exception, Exception {
		student stu=new student();
		Class clazz=student.class;
		Field f=clazz.getDeclaredField("age");
		f.setAccessible(true);
		f.set(stu, 18);
		
		Field f1=clazz.getDeclaredField("age");
		f1.setAccessible(true);
		System.out.println(f1.get(stu));
		
	}
}
