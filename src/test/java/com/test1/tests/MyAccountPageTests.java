package com.test1.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountPageTests {
  
	private WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\C18888\\Desktop\\Ian\\Software\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void testSuccessfulLogin() throws InterruptedException
	{
		driver.get("http://test1.absofttrinings.com/my-account/");
		driver.findElement(By.id("username")).sendKeys("testuser1");
		driver.findElement(By.id("password")).sendKeys("testpwd1");
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
		
		Assert.assertTrue(
				driver.findElement(By.id("user_info")).getText().contains("testuser1"),
				"Login is not successful");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		driver.quit();
	}
	
}
