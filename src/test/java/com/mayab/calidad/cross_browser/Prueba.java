package com.mayab.calidad.cross_browser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.net.URL;
public class Prueba {
	
	

	public static final String URL = "https://eiralhi90:189f19c0-7e88-4122-890e-57d851b3eb4e@ondemand.us-west-1.saucelabs.com:443/wd/hub";
		 
    public static void main(String[] args) throws Exception {
    	
		  /*DesiredCapabilities caps = DesiredCapabilities.firefox();
		    caps.setCapability("platform", "Windows 10");
		    caps.setCapability("platform", "Linux");
		    caps.setCapability("platform", "macOS 10.13");
		    caps.setCapability("version", "latest");
		    caps.setCapability("name", "firefox");
		    caps.setCapability("extendedDebugging", "true");
		    caps.setCapability("buildNumber", "3.0");*/
    	 DesiredCapabilities caps = DesiredCapabilities.safari();	
		    caps.setCapability("platform", "Windows 10");
		    caps.setCapability("platform", "Linux");
		    caps.setCapability("platform", "macOS 10.13");
		    caps.setCapability("version", "11");
		    caps.setCapability("name", "safari");
		    caps.setCapability("extendedDebugging", "true");
		    caps.setCapability("buildNumber", "3.0");
    	
		    WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
		       driver.get("https://mern-crud.herokuapp.com");
    	
    	driver.get("https://mern-crud.herokuapp.com/");
        driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("eiralhi");
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("eira@hotmail.com");
        driver.findElement(By.name("age")).click();
        driver.findElement(By.name("age")).clear();
        driver.findElement(By.name("age")).sendKeys("20");
        driver.findElement(By.xpath("//div[3]/div[2]/div")).click();
        driver.findElement(By.xpath("//div[2]/div[2]")).click();
        driver.findElement(By.xpath("//form/button")).click();
        
        
        String expected = "Successfully added!";
		String gotMessage="";
		WebElement result = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[4]/div/p"));
		gotMessage = result.getText();
		assertThat(expected,is(equalTo(gotMessage)));
		boolean finalResult = false;
		if(gotMessage.equals("Successfully added!")) {
			finalResult = true;
		}else {
			finalResult = false;
		}
		if (finalResult){
		      ((JavascriptExecutor)driver).executeScript("sauce:job-result=passed");
		    }
		    else {
		      ((JavascriptExecutor)driver).executeScript("sauce:job-result=failed");
		    }
		driver.quit();
		
	  
	}
}


	
	
