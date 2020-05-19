package cn.itcastma.reflect;

import java.lang.reflect.Constructor;

import org.junit.Test;



public class Demo1 {
@Test
public void test1() throws ClassNotFoundException, Exception, IllegalAccessException {
	student stu=(student) m1("cn.itcastma.reflect.student");
}

public Object m1(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
	Class clazz=Class.forName(className);
	return clazz.newInstance();

}

@Test//得到字节码对象的三种方式
public void test2() throws Exception {
//Class clazz=Class.forName("className");
//Class clazz=student.class;
student stu = null;
Class clazz=stu.getClass();
clazz.newInstance();
}
@Test
public void test3() throws Exception {
	Class clazz=Class.forName("cn.itcastma.reflect.student");
	Constructor c=clazz.getConstructor();//得到一无参构造函数
	c.newInstance(null);
	}

@Test
public void test4() throws Exception {
	Class clazz=Class.forName("cn.itcastma.reflect.student");
	Constructor c=clazz.getConstructor(String.class);//得到一个参数(String)构造函数
	c.newInstance("TOM");
	}

@Test
public void test5() throws Exception {
	Class clazz=Class.forName("cn.itcastma.reflect.student");
	Constructor c=clazz.getDeclaredConstructor(int.class);//得到一个参数(int)私有构造函数
	c.setAccessible(true);//暴力强转
	c.newInstance(20);
	}

@Test
public void test6() throws Exception {
	Class clazz=Class.forName("cn.itcastma.reflect.student");
	Constructor c=clazz.getDeclaredConstructor(String.class,int.class);//得到一个参数(String)构造函数
	c.setAccessible(true);
	c.newInstance("TOM",25);
	}
}
