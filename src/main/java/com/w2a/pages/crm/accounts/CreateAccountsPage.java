package com.w2a.pages.crm.accounts;

import org.openqa.selenium.By;

import com.w2a.base.page;

public class CreateAccountsPage extends page{
	
	
	public void CreateAccount(String accountName) {
	type("AccountName_XPATH",accountName);
		
		
		 
	}

}
