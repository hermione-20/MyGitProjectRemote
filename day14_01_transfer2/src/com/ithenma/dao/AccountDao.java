package com.ithenma.dao;

import java.sql.SQLException;

import com.itheima.domain.Account;

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
/**
 * 根据账户修改金额
 * @param toAccount
 */
	public void updateAccount(Account toAccount) throws  Exception;
	
	/**
	 * 根据用户名查找账户信息
	 * @param fromname
	 * @return
	 * @throws Exception
	 */
public Account findAccountByName(String fromname)throws  Exception;

}
