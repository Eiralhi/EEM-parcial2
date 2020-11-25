package com.mayab.calidad.funcionales;

import static org.junit.Assert.*;
import org.openqa.selenium.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class TestGoogle {

	private WebDriver driver;
	private String baseURL;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();	

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\eiral\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		baseURL= "https://www.google.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
		
	@Test
	public void testCaso1() throws Exception {
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("covid");
		driver.findElement(By.id("tsf")).submit();
		 
		driver.findElement(By.xpath("/html/body/div[8]/div[2]/div[10]/div[1]/div[2]/div/div[2]/div[2]/div/div/div[1]/div/div[1]/a/h3/span")).click();
		assertEquals("Coronavirus Disease (COVID-19) pandemic - PAHO/WHO | Pan American Health Organization", driver.getTitle());
	}


	@After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	 
	 private boolean isElementPresent(By by) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		  }

		  private boolean isAlertPresent() {
		    try {
		      driver.switchTo().alert();
		      return true;
		    } catch (NoAlertPresentException e) {
		      return false;
		    }
		  }

		  private String closeAlertAndGetItsText() {
		    try {
		      Alert alert = driver.switchTo().alert();
		      String alertText = alert.getText();
		      if (acceptNextAlert) {
		        alert.accept();
		      } else {
		        alert.dismiss();
		      }
		      return alertText;
		    } finally {
		      acceptNextAlert = true;
		    }
		  }
}