package com.w2a.rough;

import com.w2a.base.page;
import com.w2a.pages.HomePage;
import com.w2a.pages.LoginPage;
import com.w2a.pages.ZohoAppPage;
import com.w2a.pages.crm.CRMHomePage;
import com.w2a.pages.crm.accounts.AccountsPage;
import com.w2a.pages.crm.accounts.CreateAccountsPage;

public class LoginTest {

	public static void main(String[] args) {
		
		
		HomePage home= new HomePage();
		LoginPage login=home.goToSignIn();
		ZohoAppPage app=login.doSignIn("konkaveni@gmail.com","veni@1983");
		app.goToCRM();	
		AccountsPage accounts=page.menu.gotoAccounts();		
		CreateAccountsPage cap=accounts.goTOCreateAccounts();
		cap.CreateAccount("Ravi");
	
		

	}

}
