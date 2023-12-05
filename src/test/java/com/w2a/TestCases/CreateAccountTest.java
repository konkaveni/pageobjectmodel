package com.w2a.TestCases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.page;
import com.w2a.pages.ZohoAppPage;
import com.w2a.pages.crm.accounts.AccountsPage;
import com.w2a.pages.crm.accounts.CreateAccountsPage;
import com.w2a.utilities.TestUtil;

public class CreateAccountTest {

	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void createAccountTest(Hashtable<String,String> data) {
		
		ZohoAppPage app=new ZohoAppPage();
		app.goToCRM();	
		AccountsPage accounts=page.menu.gotoAccounts();		
		CreateAccountsPage cap=accounts.goTOCreateAccounts();
		cap.CreateAccount(data.get("customername"));
	    Assert.fail("Failing the Create Account Test");
		
	}
}
