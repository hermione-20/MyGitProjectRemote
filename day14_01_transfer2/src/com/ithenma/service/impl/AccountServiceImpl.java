package com.ithenma.service.impl;

import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.domain.Account;
import com.itheima.util.ManagerThreadLocal;
import com.ithenma.dao.AccountDao;
import com.ithenma.service.AccountService;

public class AccountServiceImpl implements AccountService {
	

	public void transfer(String fromname, String toname, double money) throws Exception{
		//ad.updateAccount(fromname, toname, money);
		AccountDao ad=new AccountDaoImpl();
		
		try {
			ManagerThreadLocal.startTransaction();//begin
			
			//�ֱ�õ�ת����ת���˻�����
			Account fromAccount=ad.findAccountByName(fromname);
			Account toAccount=ad.findAccountByName(toname);
			
			//�޸ĸ����˻��Ľ��
			fromAccount.setMoney(fromAccount.getMoney()-money);
			toAccount.setMoney(toAccount.getMoney()+money);
			
			//���ת�˲���
			ad.updateAccount(fromAccount);
			ad.updateAccount(toAccount);
			ManagerThreadLocal.commit();//�ύ����
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ManagerThreadLocal.rollback();//�ع�����
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ManagerThreadLocal.close();//�ر�
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
