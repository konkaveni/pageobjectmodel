package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.w2a.listeners.CustomListeners;
import com.w2a.utilities.ExcelReader;

public class page {

	public static WebDriver driver;
	public static TopMenu menu;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\com\\w2a\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public static String browser;

	public page() {
		if(driver==null) {
			
			 //loading OR and config properties
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\com\\w2a\\properties\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config file Loaded!!!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\com\\w2a\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR File Loaded!!!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Jenkins Browser filter configuration

			if (System.getenv("Browser") != null && !System.getenv("Browser").isEmpty()) {

				browser = System.getenv("Browser");
			}

			else {

				browser = config.getProperty("Browser");
			}
			config.setProperty("Browser", browser);
		
			
			//Browser Initialization
			if (config.getProperty("Browser").equals("firefox")) {

				driver = new FirefoxDriver();

			} else if (config.getProperty("Browser").equals("chrome")) {
			
				
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");

	    driver= new ChromeDriver(options);
	    log.debug("Chrome Browser Launched Successfully!!!!");
			} else if (config.getProperty("Browser").equals("ie")) {

				driver = new InternetExplorerDriver();
			}
	
	    
			driver.get(config.getProperty("testsiteurl"));
			log.debug("Navigated to:" + config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		    menu= new TopMenu(driver);
			
		
		
		}
		
		}
	
		public static void quit() {

		driver.quit();
	}
		
		 
		//KeyWords
		public static void click(String locator) {

			if (locator.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
			} else if (locator.endsWith("_XPATH")) {
				driver.findElement(By.xpath(OR.getProperty(locator))).click();
			} else if (locator.endsWith("_ID")) {
				driver.findElement(By.id(OR.getProperty(locator))).click();
			}
			log.debug("clicking on an element:"+locator);
			CustomListeners.test.log(Status.INFO, "Clicking on:" + locator);
		}

		public static void type(String locator, String value) {

			if (locator.endsWith("_CSS")) {

				driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
			} else if (locator.endsWith("_XPATH")) {

				driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
			} else if (locator.endsWith("_ID")) {

				driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
			}
			log.debug("Typing in an element: "+locator+"  "+"entered value as:"+value);
			CustomListeners.test.log(Status.INFO, "Typing in:" + locator + "       " + "entered value as:" + value);
		}

		static WebElement dropdown;

		public static void select(String locator, String value) {
			
			if(locator.endsWith("_CSS")) {
			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
			} else if(locator.endsWith("_XPATH")) {
				dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
				} else if(locator.endsWith("_ID")) {
					dropdown = driver.findElement(By.id(OR.getProperty(locator)));
				} 
			Select select = new Select(dropdown);
			select.selectByVisibleText(value);
			log.debug("selecting from an element:"+locator+" "+"value as:"+value);
			CustomListeners.test.log(Status.INFO, "selecting an element:"+locator+" "+"value as:"+value);
		}

		public boolean isElementPresent(By by) {
			try {

				driver.findElement(by);
				return true;

			} catch (NoSuchElementException e) {
				return false;

			}

		}
}
