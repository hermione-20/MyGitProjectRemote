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

@Test//�õ��ֽ����������ַ�ʽ
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
	Constructor c=clazz.getConstructor();//�õ�һ�޲ι��캯��
	c.newInstance(null);
	}

@Test
public void test4() throws Exception {
	Class clazz=Class.forName("cn.itcastma.reflect.student");
	Constructor c=clazz.getConstructor(String.class);//�õ�һ������(String)���캯��
	c.newInstance("TOM");
	}

@Test
public void test5() throws Exception {
	Class clazz=Class.forName("cn.itcastma.reflect.student");
	Constructor c=clazz.getDeclaredConstructor(int.class);//�õ�һ������(int)˽�й��캯��
	c.setAccessible(true);//����ǿת
	c.newInstance(20);
	}

@Test
public void test6() throws Exception {
	Class clazz=Class.forName("cn.itcastma.reflect.student");
	Constructor c=clazz.getDeclaredConstructor(String.class,int.class);//�õ�һ������(String)���캯��
	c.setAccessible(true);
	c.newInstance("TOM",25);
	}
}
