package com.runnerClass;



import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.web.configurationReader.ConfigurationReaderHelp;
import com.web.pom.HomePage;

import baseClass.BaseClass;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import sdp.Sdp;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\anandraj\\eclipse-workspace\\Zoho_projec1\\src\\test\\java\\com\\zoho_feature\\zoho.feature", glue="com.stepDefinition", monochrome=true,
dryRun=false,plugin={"pretty",
"html:Report/htmlReport.html",

"json:Report/jsonreport.json",
"junit:Report/junitReport.xml"})
//,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "summary"})
//"com.cucumber.listener.ExtentCucumberFormatter:Report/ExtentRep.html"})
public class RunnerClass extends BaseClass  {
	
	public static WebDriver driver = null;
	@BeforeClass
	public static void setUp() throws IOException {
		String browser = ConfigurationReaderHelp.getInstance().getBrowser();
	//driver = browserLaunch("chrome");
		driver = BaseClass.browserLaunch(browser);
		//driver = browserLaunch(browser);
		//HomePage home= new HomePage(driver);
	}
	
	
	@AfterClass
public static void tearDown() {
	
	closeOrQuit("close");
		
	}

}
