package com.itheima.product.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.product.domain.User;
import com.itheima.product.util.C3P0Util;

public class UserDao {

	public void addUser(User user) throws SQLException  {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		String sql="INSERT INTO USER(username,PASSWORD,gender,email,telephone,introduce,activeCode,state,regisTime)VALUES (?,?,?,?,?,?,?,?,?)";
		
		qr.update(sql,user.getUsername(),user.getPassword(),user.getGender(),user.getEmail(),user.getTelephone(),user.getIntroduce(),user.getActiveCode(),user.getState(),user.getRegisTime()
				);
		
	}
//根据激活码查找用户
	public User FindUserByActiveCode(String activeCode) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from user where activeCode=?", new BeanHandler<User>(User.class),activeCode);
	}
	//修改用户激活状态
	public void activeCode(String activeCode) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		qr.update("update user set state=1 where activeCode=?",activeCode);
		
	}
	//用户登录
	public User findUserByUserNameAndPassword(String username, String password) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from user where username=? and password=?",new BeanHandler<User>(User.class),username,password);
	}
	//根据Id查找用户
	public User findUserById(String id) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from user where id=?", new BeanHandler<User>(User.class),id);
	}
	//修改用户信息
	public void modifyUser(User user) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		qr.update("update user set password=?,gender=?,telephone=? where id=?", user.getPassword(),user.getGender(),user.getTelephone(),user.getId());
		
	}

}
