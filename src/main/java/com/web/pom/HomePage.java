package com.web.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public static WebDriver driver;
	
@FindBy(xpath = "//span[text()='Sign Up Now']")
private WebElement signUp;
	


public  HomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public WebElement getsignUp() {
	return signUp;
	
}

}
