package com.itheima.util;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.itheima.entity.User;

public class TestResultSerHandler {
	@Test//ArrayHandler:�ʺ�ȡ1����¼���Ѹ�����¼��ÿ��ֵ��װ��һ��������Object[]
	public void test1() throws SQLException {
		QueryRunner qr= new QueryRunner(C3P0Util.getDataSource());
		Object[] arr=qr.query("select * from user where id=?", new ArrayHandler(),1);
		
		for (Object o : arr) {
			System.out.println(o);
			
		}
	}

	@Test
	//ArrayListHandler:�ʺ�ȡ������¼����ÿ����¼��ÿ��ֵ��װ��һ��������Object[]���������װ��һ��List��
	public void test2() throws SQLException {
		QueryRunner qr= new QueryRunner(C3P0Util.getDataSource());
		List<Object[]> query= qr.query("select * from user", new ArrayListHandler());
		//for��Ԫ������  Ԫ������ �� �������飨���ϣ��������ܽ��е����ģ���{���},foreachҲ����ǿforѭ��
		for (Object[] os : query) {
			  for (Object o : os) { 
				  System.out.println(o);
			  }
			 
			System.out.println("..........");
		}
	}
	@Test
	//ColumnListHandler:ȡĳһ�е����ݡ���װ��List�С�
	public void test3() throws SQLException {
		QueryRunner qr= new QueryRunner(C3P0Util.getDataSource());
		List<Object>list=qr.query("select name,password from user", new ColumnListHandler(2));
		for (Object o : list) {
			System.out.println(o);
			
		}
	}
	@Test
	//KeyedHandler:ȡ������¼��ÿһ����¼��װ��һ��Map�У��ٰ����Map��װ������һ��Map�У�keyΪָ�����ֶ�ֵ��
	public void test4() throws SQLException {
		QueryRunner qr= new QueryRunner(C3P0Util.getDataSource());
		//��Map��key�Ǳ��е�ĳ�����ݣ�СMap�е�key�Ǳ������������Դ�Map��key��Object���ͣ�СMap��key��String���ͣ�
		Map<Object,Map<String,Object>>map=qr.query("select * from user", new KeyedHandler(1));
	    
		//for (iterable_type iterable_element : iterable) {}������forѭ��
		
		for (Map.Entry<Object,Map<String,Object>> m : map.entrySet()) {
			System.out.println(m.getKey());//��Map�е�keyֵ����id�е�ֵ
			for (Map.Entry<String, Object> mm : m.getValue().entrySet()) {
				System.out.println(mm.getKey()+"\t"+mm.getValue());//ȡ��СMap�е���������ֵ��
				}
			System.out.println("...............");
		}
	}
	@Test
	//MapHandler:�ʺ�ȡ1����¼���ѵ�ǰ��¼����������ֵ�ŵ�һ��Map��
	public void test5() throws SQLException {
		QueryRunner qr= new QueryRunner(C3P0Util.getDataSource());
		Map<String,Object>map=qr.query("select * from user where id=?", new MapHandler(),8);
		
		for (Map.Entry<String, Object> m : map.entrySet()) {
			System.out.println(m.getKey()+"\t"+m.getValue());
			
		}
	}
	
	@Test
	//MapListHandler:�ʺ�ȡ������¼����ÿ����¼��װ��һ��Map�У��ٰ�Map��װ��List��
	public void test6() throws SQLException {
		QueryRunner qr= new QueryRunner(C3P0Util.getDataSource());
		List<Map<String,Object>>list=qr.query("select * from user", new MapListHandler());
		for (Map<String, Object> map : list) {
			for (Map.Entry<String, Object> m : map.entrySet()) {
				System.out.println(m.getKey()+"\t"+m.getValue());
				
			}
			System.out.println("...........");
			
		}
	}
	@Test
	//ScalarHandler:�ʺ�ȡ���е�������
	public void test7() throws SQLException {
		QueryRunner qr= new QueryRunner(C3P0Util.getDataSource());
		Object o=qr.query("select * from user", new ScalarHandler(2));
		System.out.println(o);
	}
	
	@Test
	//BeanHandler��ʾ�ѽ�����е�һ�����ݣ���װ��һ������ר����Խ������ֻ��һ�����ݵ������
	public void test8() throws SQLException {
		QueryRunner qr= new QueryRunner(C3P0Util.getDataSource());
		User user=qr.query("select * from user", new BeanHandler<User>(User.class));
		System.out.println(user);
	}
	
	@Test
	//BeanListHandler:��ʾ�ѽ�����еĶ������ݣ���װ��һ������ļ��ϣ���Խ�������ж������ݡ�
	public void test9() throws SQLException {
		QueryRunner qr= new QueryRunner(C3P0Util.getDataSource());
		List<User> list=qr.query("select * from user", new BeanListHandler<User>(User.class));
		System.out.println(list);
	}
}