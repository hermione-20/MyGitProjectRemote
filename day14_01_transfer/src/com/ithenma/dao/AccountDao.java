package com.ithenma.dao;

import java.sql.SQLException;

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

}
