package com.testNG;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dataDriven.Singledata;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SimpleAnnotation {
	private WebDriver driver;
	@BeforeSuite
	public void browesersetup() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}
	@BeforeTest
	public void getWebpage() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.zoho.com/");
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void getWebElement() {
		WebElement singUP=driver.findElement(By.xpath("//span[text()='Sign Up Now']"));
		singUP.click();

	}
	@Test
	public void sinUp() throws IOException {
		
			WebElement fuNmae=driver.findElement(By.xpath("//input[@id='namefield']"));
			String fullName = Singledata.singleData("zoho", 0, 0);
			fuNmae.sendKeys(fullName);
			WebElement email=driver.findElement(By.xpath("//input[@id='email']"));
			String eMail = Singledata.singleData("zoho", 0, 1);
			email.sendKeys("anandraj123@mail.com");
			WebElement pass=driver.findElement(By.xpath("//input[@name='password']"));
			String passWord = Singledata.singleData("zoho", 0, 2);
			pass.sendKeys(passWord);
			WebElement mobileNumber=driver.findElement(By.xpath("//input[@id='rmobile']"));
			String mobile = Singledata.singleData("zoho", 0, 3);
			mobileNumber.sendKeys(mobile);
			WebElement signupb=driver.findElement(By.xpath("//input[@id='signupbtn']"));
			signupb.click();
	}
@AfterMethod
public void screenShot() throws IOException {
	File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcFile,new File("C:\\Users\\anandraj\\eclipse-workspace\\Zoho_projec1\\screenshot\\img1.png"));
	}
@AfterClass
public void deleteCookiees() {
	driver.manage().deleteCookieNamed("store");
}
@AfterSuite
public void browserClose() {
	driver.close();
}
}
