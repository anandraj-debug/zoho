package com.web.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp {
	
	public static WebDriver driver;
	
	
	public SignUp(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='namefield']")
	private WebElement fuNmae;
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement pass;
	
	@FindBy(xpath = "//input[@id='rmobile']")
	private WebElement mobileNumber;
	
	@FindBy(xpath = "//input[@id='signupbtn']")
	private WebElement signupb;
	
	
	
	
	public WebElement getfuNmae() {
		return fuNmae;
		}
	
	public WebElement getemail() {
		return email;
		
	}
	public WebElement getpass() {
		return pass;
		
	}
	public WebElement getmobileNumber() {
		return mobileNumber;
		
	}
	public WebElement getsignUp() {
		return signupb;
		
	}
}
