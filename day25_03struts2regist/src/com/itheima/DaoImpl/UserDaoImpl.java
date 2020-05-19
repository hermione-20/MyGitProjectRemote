package com.itheima.DaoImpl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import com.itheima.utils.DBCPUtil;

public class UserDaoImpl implements IUserDao {
	
	private QueryRunner qr=new QueryRunner(DBCPUtil.getDataSource());
	
	

	public User selectUserByUsername(String username) {
		try{
			return qr.query("select * from user where username=?",new BeanHandler<User>(User.class), username);	
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}


	public int addUser(User user) {
		try {
			return qr.update("insert into user(username,password,birthday,hobby,married) values(?,?,?,?,?)",user.getUsername(),user.getPassword(),user.getBirthday(),user.getHobby(),user.isMarried());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
