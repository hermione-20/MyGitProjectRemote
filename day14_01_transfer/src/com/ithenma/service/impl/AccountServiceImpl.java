package com.ithenma.service.impl;

import com.itheima.dao.impl.AccountDaoImpl;
import com.ithenma.dao.AccountDao;
import com.ithenma.service.AccountService;

public class AccountServiceImpl implements AccountService {
	AccountDao ad=new AccountDaoImpl();

	public void transfer(String fromname, String toname, double money) 
			throws Exception {
		ad.updateAccount(fromname, toname, money);

	}

}
