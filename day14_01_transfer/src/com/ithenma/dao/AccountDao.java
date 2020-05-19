package com.ithenma.dao;

import java.sql.SQLException;

public interface AccountDao {
	//输入/**然后点击回车出现的这个
	 /**
	  * 转账
	  * @param fromname 转出用户
	  * @param toname 转入用户
	  * @param money 转账金额
	 * @throws Exception 
	  */
	public void updateAccount(String fromname,String toname,double money) throws  Exception;

}
