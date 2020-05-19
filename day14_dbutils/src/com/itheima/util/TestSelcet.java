package com.itheima.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.itheima.entity.User;

public class TestSelcet {
	
	@Test
	public void testSelect() throws SQLException{
		//创建一个Queryrunner对象
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		List<User> list= qr.query("select * from user", new ResultSetHandler <List<User>>() {
       //当query方法执行sql语句后，将结果集以参数形式传递过来
			public List<User> handle(ResultSet rs) throws SQLException {
				List<User>list = new ArrayList<User>();
				while (rs.next()) {
					User u=new User();
					u.setId(rs.getInt(1));
					u.setName(rs.getString(2));
					u.setPassword(rs.getString(3));
					u.setEmail(rs.getString(4));
					u.setBirthday(rs.getDate(5));
					list.add(u);				
				}
			   return list;
			}
		
		});
		for (User user : list) {
			System.out.println(user);
			
		}
		
	}
	
	@Test
	public void testSelect2() throws SQLException{
		//创建一个Queryrunner对象
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());	
		//执行查询语句，并返回结果集
		List<User> list=qr.query("select * from user where id=? and name=?", new BeanListHandler<User>(User.class),2,"lisi");
		for (User user : list) {
			System.out.println(user);
			
		}
	}
	}

