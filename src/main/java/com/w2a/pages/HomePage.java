package com.w2a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.w2a.base.page;

public class HomePage extends page {
	
	
	
	public LoginPage goToSignIn() {
		
		click("signin_XPATH");
		
		return new LoginPage();
	}
	
	
	public void goToSignUp() {
				
		driver.findElement(By.cssSelector("div[class='signupcontainer'] a[class='signUp']")).click();
		
	}


}
