package com.niaa.service.impl.current.account;

import com.niaa.service.api.accoumt.IAccount;

public class CurrentAccount implements IAccount {

	public String getAccountType() {
		return "CurrentAccount";
	}

	public String getAccountId() {
		return "2";
	}

}
