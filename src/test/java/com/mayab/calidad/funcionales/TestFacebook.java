package com.mayab.calidad.funcionales;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class TestFacebook {

		private WebDriver driver;
		private String baseURL;
		private boolean acceptNextAlert = true;
		private StringBuffer verificationErrors = new StringBuffer();	

		@Before
		public void setUp() throws Exception {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\eiral\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
			baseURL= "https://www.facebook.com/";
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	}

        @Test
        public void testLoginIncorrecto()throws Exception	{
        	 driver.get("https://www.facebook.com/");
        	    driver.findElement(By.id("email")).click();
        	    driver.findElement(By.id("email")).clear();
        	    driver.findElement(By.id("email")).sendKeys("amigalalis@hotmail.com");
        	    driver.findElement(By.id("pass")).click();
        	    driver.findElement(By.id("pass")).clear();
        	    driver.findElement(By.id("pass")).sendKeys("12345678");
        	    driver.findElement(By.id("u_0_h")).click();
        	    assertTrue(isElementPresent(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[2]/div[2]/form/div/div[1]/div[2]")));
        	  //*[@id="loginform"]/div[1]/div[2]
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























		
