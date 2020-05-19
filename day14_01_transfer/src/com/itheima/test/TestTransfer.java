package com.itheima.test;

import com.ithenma.service.AccountService;
import com.ithenma.service.impl.AccountServiceImpl;

public class TestTransfer {
	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[]args) throws Exception {
		AccountService as =new AccountServiceImpl();
			as.transfer("aaa", "bbb", 100);
			
		
	}

}
