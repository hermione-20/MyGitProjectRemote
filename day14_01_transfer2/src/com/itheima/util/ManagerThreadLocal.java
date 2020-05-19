package com.itheima.util;

import java.sql.Connection;
import java.sql.SQLException;


public class ManagerThreadLocal {
	private static ThreadLocal<Connection> tl=new ThreadLocal<Connection>();
	
	//�õ�һ������
	public static Connection getConnection(){
		Connection conn=tl.get();//�ӵ�ǰ�߳���ȡ��һ������
		if (conn==null) {
			conn=C3P0Util.getConnection();//�ӳ���ȡ��һ��
			tl.set(conn);//��conn������뵽��ǰ�̶߳�����
		}
		return conn;
	}
	
	//��ʼ����
	public static void startTransaction() {
		try {
			Connection conn=getConnection();
			conn.setAutoCommit(false);//�ӵ�ǰ�߳�ȡ���Ķ�������ӣ�����ʼ����
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//�ύ����
	public static void commit() {
		try {
			getConnection().commit();//�ύ����
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void rollback() {
		try {
			getConnection().rollback();//�ع�����
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close() {
		try {
			getConnection().close();//�����ӷŻس���
			tl.remove();//�ѵ�ǰ�߳��е�conn�Ƴ�
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
