package com.w2a.pages;

import org.openqa.selenium.By;

import com.w2a.base.page;
import com.w2a.pages.crm.CRMHomePage;

public class ZohoAppPage extends page {
	
	
	
	
	public CRMHomePage goToCRM() {
		click("CRMlink_XPATH");
		click("CRMZoho_XPATH");
		
		return new CRMHomePage();
	}
	
	public void goToSalesIQ() {
		
		driver.findElement(By.xpath("//*[@id=\"apps\"]/div[1]/div/ul/li[3]/a")).click();
	}

}
