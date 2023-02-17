
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import dataDriven.Singledata;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
public class ZohoScripit {
	
private WebDriver driver;
	
	public void browserSetUp() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}


	public void sinIn() throws IOException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\anand\\eclipse-workspace\\selenium1\\Driver\\Chrome\\chromedriver.exe");
	//WebDriver driver= new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://www.zoho.com/");
	
	driver.manage().window().maximize();
	WebElement singUP=driver.findElement(By.xpath("//span[text()='Sign Up Now']"));
	singUP.click();
	driver.navigate().to("https://www.zoho.com/in/crm/?zmc=zoho-fa&ireft=ohome");
	}
	
	public void sinUp() throws IOException {
	WebElement fuNmae=driver.findElement(By.xpath("//input[@id='namefield']"));
	String fullName = Singledata.singleData("zoho", 0, 0);
	fuNmae.sendKeys(fullName);
	WebElement email=driver.findElement(By.xpath("//input[@id='email']"));
	String eMail = Singledata.singleData("zoho", 0, 1);
	email.sendKeys("anandraj123@mail.com");
	WebElement pass=driver.findElement(By.xpath("//input[@name='password']"));
	String passWord = Singledata.singleData("zoho", 0, 1);
	pass.sendKeys(passWord);
	WebElement mobileNumber=driver.findElement(By.xpath("//input[@id='mobile']"));
	String mobile = Singledata.singleData("zoho", 0, 1);
	mobileNumber.sendKeys(mobile);
	WebElement signupb=driver.findElement(By.xpath("//input[@id='signupbtn']"));
	signupb.click();
	File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcFile,new File("C:\\Users\\anandraj\\eclipse-workspace\\Zoho_projec1\\screenshot\\img1.png"));
	
	
	
	  
	
	
	}
	
public static void main(String[] args) throws IOException {
	ZohoScripit zoho =new ZohoScripit();
	zoho.browserSetUp();
	zoho.sinIn();
	zoho.sinUp();
}
}
