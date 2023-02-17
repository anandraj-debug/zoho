package com.zoho.Zoho_projec1;

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
import org.openqa.selenium.support.ui.WebDriverWait;

import com.web.configurationReader.ConfigurationReaderHelp;

import baseClass.BaseClass;
import dataDriven.Singledata;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Zoho extends BaseClass {
//private WebDriver driver;
	public static void Browser() throws IOException {
		String browser = ConfigurationReaderHelp.getInstance().getBrowser();
		driver = browserLaunch(browser);
		//driver = browserLaunch("chrome");
		
		String url = ConfigurationReaderHelp.getInstance().getUrl();

		url(url);
		//url("https://www.zoho.com/");
	}

	public void sinIn() throws IOException {
		WebElement singUP = elementFind("xpath", "//span[text()='Sign Up Now']");
		elementClick(singUP);

	}

	public void sinUp() throws IOException {
		WebElement fuNmae = elementFind("xpath", "//input[@id='namefield']");
		String fullName = Singledata.singleData("zoho", 0, 0);
		elementSendKeys(fuNmae, fullName);

		WebElement email = elementFind("xpath", "//input[@id='email']");
		String eMail = Singledata.singleData("zoho", 0, 1);
		elementSendKeys(email, eMail);

		WebElement pass = elementFind("xpath", "//input[@name='password']");
		String passWord = Singledata.singleData("zoho", 0, 2);
		elementSendKeys(pass, passWord);

		WebElement mobileNumber = elementFind("xpath", "//input[@id='rmobile']");
		String mobile = Singledata.singleData("zoho", 0, 3);
		elementSendKeys(mobileNumber, mobile);

		WebElement signupb = elementFind("xpath", "//input[@id='signupbtn']");
		elementClick(signupb);

		takesScreenShot("zoho1");
		closeOrQuit("close");

	}

	public static void main(String[] args) throws IOException {
		Zoho zoho = new Zoho();
		zoho.Browser();
		zoho.sinIn();
		zoho.sinUp();
	}

}
