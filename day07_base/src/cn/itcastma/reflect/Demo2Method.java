package cn.itcastma.reflect;

import java.lang.reflect.Method;

import org.junit.Test;



public class Demo2Method {

	@Test//public void m1
public void test1() throws Exception {
	student stu=new student();
	Class clazz=student.class;
	Method m=clazz.getMethod("m1");
	m.invoke(stu, null);//此方法代表要执行m方法，第一个参数：表示要执行哪个对象中的方法；第二个参数：代表实参。
	
}
	
	@Test//public void m2(String name)
	public void test2() throws Exception {
		Class clazz=student.class;
		Method m=clazz.getMethod("m2",String.class);
		m.invoke(clazz.newInstance(), "tom");//此方法代表要执行m方法，第一个参数：表示要执行哪个对象中的方法；第二个参数：代表实参。
		
	}
	
	@Test//public void m4(int age)
	public void test4() throws Exception {
		Class clazz=student.class;
		Method m=clazz.getDeclaredMethod("m4",int.class);//访问private类型的需要使用getDeclaredMethod。
		m.setAccessible(true);//访问private类型的需要这个
		m.invoke(clazz.newInstance(), 18);//invoke方法的返回值，就是执行方法的返回值。如果是void的方法，则返回值是null。
		
	}
	

	@Test//得到所有方法
	public void test7() throws Exception {
		Class clazz=student.class;
		Method[] ms=clazz.getMethods();//得到所有公用的方法
		System.out.println(ms.length);
		
	}
}
