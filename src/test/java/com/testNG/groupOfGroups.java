package com.testNG;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;
import com.web.configurationReader.ConfigurationReaderHelp;

import baseClass.BaseClass;
import dataDriven.Singledata;
import io.github.bonigarcia.wdm.WebDriverManager;
import sdp.Sdp;

public class groupOfGroups extends BaseClass {
	// private WebDriver driver2=driver;
	Sdp sdp;
	@Test(groups = { "launch" },priority = 0)
	public void browesersetup() throws IOException {
		String browser = ConfigurationReaderHelp.getInstance().getBrowser();
		String url = ConfigurationReaderHelp.getInstance().getUrl();
		driver = browserLaunch(browser);
		url(url);
		sdp=new Sdp(driver);

		WebElement singUP = sdp.gethomePage().getsignUp();
		elementClick(singUP);

	}

	@Test(groups = { "sinUp" },priority = 1)
	@Parameters({"fullName","eMail","passWord","mobile"})
	public void sinUp(String fullName, String eMail,String passWord, String mobile ) throws IOException {
		WebElement fuNmae =sdp.getsignUp().getfuNmae();
		elementSendKeys(fuNmae, fullName);

		WebElement email = sdp.getsignUp().getemail();
		elementSendKeys(email, eMail);

		WebElement pass = sdp.getsignUp().getpass();
		elementSendKeys(pass, passWord);

		WebElement mobileNumber = sdp.getsignUp().getmobileNumber();
		elementSendKeys(mobileNumber, mobile);

		WebElement signupb = sdp.getsignUp().getsignUp();
		elementClick(signupb);
		takesScreenShot("zoho");

	}

	@Test(dependsOnGroups = { "sinUp.*" },priority = 2)
	public void browserClose() {
		closeOrQuit("close");
	}
}
