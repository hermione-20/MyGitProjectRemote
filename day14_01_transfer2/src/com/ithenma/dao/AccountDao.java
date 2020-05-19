package com.ithenma.dao;

import java.sql.SQLException;

import com.itheima.domain.Account;

public interface AccountDao {
	//����/**Ȼ�����س����ֵ����
	 /**
	  * ת��
	  * @param fromname ת���û�
	  * @param toname ת���û�
	  * @param money ת�˽��
	 * @throws Exception 
	  */
	public void updateAccount(String fromname,String toname,double money) throws  Exception;
/**
 * �����˻��޸Ľ��
 * @param toAccount
 */
	public void updateAccount(Account toAccount) throws  Exception;
	
	/**
	 * �����û��������˻���Ϣ
	 * @param fromname
	 * @return
	 * @throws Exception
	 */
public Account findAccountByName(String fromname)throws  Exception;

}
