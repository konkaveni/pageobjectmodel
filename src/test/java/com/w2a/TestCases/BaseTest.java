package com.w2a.TestCases;

import org.testng.annotations.AfterSuite;

import com.w2a.base.page;

public class BaseTest {

	@AfterSuite
	public void tearDown() {
		
		page.quit();
		
	}
}
