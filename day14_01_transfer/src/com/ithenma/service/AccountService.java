package com.ithenma.service;

public interface AccountService {
	/**
	  * ת��
	  * @param fromname ת���û�
	  * @param toname ת���û�
	  * @param money ת�˽��
	 * @throws Exception 
	  */
	public void transfer(String fromname,String toname,double money) throws  Exception;


}
