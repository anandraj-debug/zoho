package com.stepDefinition;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.runnerClass.RunnerClass;
import com.web.configurationReader.ConfigurationReaderHelp;
import com.web.pom.HomePage;

import baseClass.BaseClass;
import dataDriven.Singledata;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sdp.Sdp;

public class StepDefinition extends BaseClass {

	public static WebDriver driver=RunnerClass.driver;
	Sdp sdp=new Sdp(driver);

	@Given("user get into Home Page")
	public void user_get_into_home_page() throws IOException {
		
		String url = ConfigurationReaderHelp.getInstance().getUrl();
		//url("https://www.zoho.com/");
		url(url);
	}

	@When("user click on Signup button")
	public void user_click_on_signup_button() {
		 WebElement signUp = sdp.gethomePage().getsignUp();
		elementClick(signUp);
	}
	
	@Then("user fill details {string} {string} {string} {string} the Signup page")
	public void user_fill_details_the_signup_page(String name, String email1, String password, String phone_Number) throws IOException {
		WebElement fuNmae = sdp.getsignUp().getfuNmae();
		String fullName=name;
		elementSendKeys(fuNmae, fullName);
		
		WebElement email=sdp.getsignUp().getemail();
		String eMail=email1;
		elementSendKeys(email, eMail);
	
		WebElement pass=sdp.getsignUp().getpass();
		String passWord=password;
		elementSendKeys(pass, passWord);
		
		WebElement mobileNumber=sdp.getsignUp().getmobileNumber();
		String mobile=phone_Number;
		elementSendKeys(mobileNumber, mobile);
		
		WebElement signupb=sdp.getsignUp().getsignUp();
		elementClick(signupb);
		takesScreenShot("zoho2");
		
		
//		ExtentHtmlReporter html = new ExtentHtmlReporter("Extent.html");
//	//	ExtentXReporter extentx new ExtentXReporter("localhost");
//		ExtentReports extent = new ExtentReports();
//		extent.createTest(fullName);
		
	}

	
}
