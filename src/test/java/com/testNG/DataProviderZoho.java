package com.testNG;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.web.configurationReader.ConfigurationReaderHelp;

import baseClass.BaseClass;

import org.testng.annotations.DataProvider;

import dataDriven.Singledata;
import sdp.Sdp;

public class DataProviderZoho extends BaseClass {
	//public static WebDriver driver=null;
	Sdp sdp;
		@Test(groups={"launch"})
		public void browesersetup() throws IOException {
			String browser = ConfigurationReaderHelp.getInstance().getBrowser();
			String url = ConfigurationReaderHelp.getInstance().getUrl();
			driver=browserLaunch(browser);
			url(url);
			sdp=new Sdp(driver);
			WebElement singUP = sdp.gethomePage().getsignUp();
					//driver.findElement(By.xpath("//span[text()='Sign Up Now']"));
			elementClick(singUP);
			}

		
		@DataProvider(name="data")
		public Object[][] dataMethoad() {
			return new  Object[][] {{"anandRaj","rajanand124@gmail.com","1234","987654321"}, {"anand","anand124@gmail.com","1234","987654321"}};
		}
		
		@Test(priority=1, dataProvider="data", retryAnalyzer= Retryanalyzer.class)
		public void sinUp(String fullname, String e_Mail,String password,String mobilenumber) throws IOException {

			WebElement fuNmae = sdp.getsignUp().getfuNmae();
					//driver.findElement(By.xpath("//input[@id='namefield']"));
			String fullName=fullname;
			elementSendKeys(fuNmae, fullName);
			
			WebElement email =sdp.getsignUp().getemail();
					//driver.findElement(By.xpath("//input[@id='email']"));
			String eMail=e_Mail;
			elementSendKeys(email, eMail);

			WebElement pass =sdp.getsignUp().getpass();
					//driver.findElement(By.xpath("//input[@name='password']"));
			String passWord =password;
			elementSendKeys(pass, passWord);
			
			WebElement mobileNumber = sdp.getsignUp().getmobileNumber();
					//driver.findElement(By.xpath("//input[@id='rmobile']"));
			String mobile =mobilenumber;
			elementSendKeys(mobileNumber, mobile);

			WebElement signupb = sdp.getsignUp().getsignUp();
					//driver.findElement(By.xpath("//input[@id='signupbtn']"));
			elementClick(signupb);
			navigate("refresh", null);
		takesScreenShot(mobile);
			
		}

		@Test(priority=2)
		public void browserClose() {
			closeOrQuit("close");
		}
	}

