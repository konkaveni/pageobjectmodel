package com.w2a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.w2a.base.page;

public class LoginPage extends page {
	
	
	public ZohoAppPage doSignIn(String username,String password) {
		
		type("email_ID",username);
		click("nextbtn_ID");
		type("password_ID",password);
		click("nextbtn_ID");
		
		return new ZohoAppPage();
	}

}
