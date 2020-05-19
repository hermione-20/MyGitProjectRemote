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
			
			//分别得到转出和转入账户对象
			Account fromAccount=ad.findAccountByName(fromname);
			Account toAccount=ad.findAccountByName(toname);
			
			//修改各自账户的金额
			fromAccount.setMoney(fromAccount.getMoney()-money);
			toAccount.setMoney(toAccount.getMoney()+money);
			
			//完成转账操作
			ad.updateAccount(fromAccount);
			ad.updateAccount(toAccount);
			ManagerThreadLocal.commit();//提交事务
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ManagerThreadLocal.rollback();//回滚事务
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ManagerThreadLocal.close();//关闭
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
