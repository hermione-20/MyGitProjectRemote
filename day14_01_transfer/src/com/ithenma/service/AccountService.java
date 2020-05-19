package com.ithenma.service;

public interface AccountService {
	/**
	  * 转账
	  * @param fromname 转出用户
	  * @param toname 转入用户
	  * @param money 转账金额
	 * @throws Exception 
	  */
	public void transfer(String fromname,String toname,double money) throws  Exception;


}
