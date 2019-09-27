package com.seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class GoogleSearch {


	WebDriver driver;

	public GoogleSearch() {		
		String path = System.getProperty("user.dir");
		String chromedriverpath = path + "\\BROWSERSERVERS\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromedriverpath);
		System.out.println("constructor");
	}

	@BeforeClass
	public void beforeClass() {
		driver=new ChromeDriver();
		System.out.println("driver initialized");
	}

	public void step01_openGoogle() {
		driver.get("https://www.google.com");
		String url=driver.getCurrentUrl();	
		Assert.assertEquals("https://www.google.com/", url);
	}

	@Test(dependsOnMethods="step01_openGoogle")
	public void step02_searchAnything() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys("greeshma elizabeth eapen"+Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//body")).click();
		Thread.sleep(2000);
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
