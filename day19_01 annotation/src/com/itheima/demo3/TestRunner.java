package com.itheima.demo3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRunner {
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		//查看测试类中的方法，哪个有@Mytest就执行哪个方法
		//得到要执行的类的class方法
		Class clazz=SomeDaoImpl.class;
		//得到类中的方法，包括本类中和父类中的所有公共的方法
		Method[]methods=clazz.getMethods();
		//遍历所有方法
		for (Method m : methods) {
			//判断当前方法上是否有@Mytest注解
			m.isAnnotationPresent(Mytest.class);
			//System.out.println(m.getName()+"：当前方法是否有注解"+isExistsAnno);
			if (m.isAnnotationPresent(Mytest.class)){
				m.invoke(clazz.newInstance(),null);
				
			}
		
		}
	}

}
