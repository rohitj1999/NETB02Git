package com.cjc;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Webshopxml {
	public class Webshop {
		WebDriver driver;
			
			@BeforeSuite
			public void openBrowser()
			{
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver_win32\\chromedriver.exe");
				
				
				 driver=new ChromeDriver();
			}
			@BeforeTest
			public void enterUrl()
			{
				driver.get("http://demowebshop.tricentis.com/login");
				
			}
			@BeforeClass
			public void maximizeBrowser() {
				
				driver.manage().window().maximize();
			}
			@BeforeMethod
			public void getCookies() 
			{
				Set<Cookie> ck=driver.manage().getCookies();
				System.out.println(ck.size());
				
			}
			/*@Test
			public void aloginCheck() throws InterruptedException
			{
				    driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("vikky7841@gmail.com");
			        
			        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("kjk558");
			        
			        driver.findElement(By.xpath("//input[@id='RememberMe']")).click();
			        
			        driver.findElement(By.xpath("//input[@type='submit']/parent::div")).click();
			        
			        
				
				}*/
		  
			@AfterMethod
			public void captureScreen() throws IOException {
				
				File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("D:\\ScreenShotDemo\\Webshop3.png"));
			}
			@AfterClass
			public void deleteCookies() {
				
				driver.manage().deleteAllCookies();
				System.out.println("Deletecookies");
			}
			@AfterTest
			public void dbConnectionclose()
			{
				System.out.println("DB close");
			}
			@AfterSuite
			public void closeBrowser()
			{
				driver.close();
			}
}
}
