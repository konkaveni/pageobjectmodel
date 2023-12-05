package com.w2a.pages.crm.accounts;

import org.openqa.selenium.By;

import com.w2a.base.page;

public class AccountsPage extends page {
	
	
	public CreateAccountsPage goTOCreateAccounts() {
		
		click("CreateAccont_XPATH");
	return new CreateAccountsPage();
	
	}
	
	public void goToImportAccounts() {
		
		
	}

}
