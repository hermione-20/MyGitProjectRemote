package com.itheima.util;



import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

public class TestCRUD {
	private Object[][] params;

	@Test
	public void testInsert() throws SQLException {
		//����һ��QueryRunner����
		QueryRunner qr= new QueryRunner(C3P0Util.getDataSource());
		qr.update("insert into user(name,password,email,birthday) values(?,?,?,?)", "tom","123","tom@163.com", new Date());
		
	} 
	
	@Test
	public void testUpdate() throws SQLException {
		//����һ��QueryRunner����
		QueryRunner qr= new QueryRunner(C3P0Util.getDataSource());
		qr.update("update user set name=? ,password=? where id =?", "money","123",4);
		
	} 

	@Test
	public void testDelete() throws SQLException {
		//����һ��QueryRunner����
		QueryRunner qr= new QueryRunner(C3P0Util.getDataSource());
		qr.update("delete from user where id =?", 4);
		
	} 	
	
	@Test//������ֻ��ִ����ͬ��sql���
	public void testBatch() throws SQLException {
		//����һ��QueryRunner����
		QueryRunner qr= new QueryRunner(C3P0Util.getDataSource());
		Object[][]params=new Object[10][];//��ά����ִ�ж��ٴ�sql���
		for (int i = 0; i < params.length; i++) {
			params[i]=new Object[] {"tom1"+i,"123","tom@163.com", new Date()};//��ÿ��ִ��SQL����еģ��Ÿ�ֵ
			
		}
		qr.batch("insert into user(name,password,email,birthday) values(?,?,?,?)", params);
	
		
	} 	
}
