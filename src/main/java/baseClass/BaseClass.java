package baseClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static WebDriver browserLaunch(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("Start-maximized");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);

		}

		else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		// driver.manage().window().maximize();
		return driver;
	}

	public static void url(String url) {
		driver.get(url);
	}

	public static void elementSendKeys(WebElement element, String values) {
		element.sendKeys(values);
	}

	public static void elementClick(WebElement element) {
		element.click();
	}

	public static void elementIsDisplayed(WebElement element) {
		boolean isDisplayed = element.isDisplayed();
		if (isDisplayed == true) {
			System.out.println("WebElement is Displayed : true ");
		} else {
			System.out.println("WebElement is Displayed : no ");
		}
	}

	public static void elementIsenabled(WebElement element) {
		boolean isnabled = element.isEnabled();
		if (isnabled == true) {
			System.out.println("WebElement is isnabled : true ");
		} else {
			System.out.println("WebElement is isnabled : no ");
		}
	}

	public static void elementIsSelected(WebElement element) {
		boolean isSelected = element.isEnabled();
		if (isSelected == true) {
			System.out.println("WebElement is isSelected : true ");
		} else {
			System.out.println("WebElement is isSelected : no ");
		}
	}

	public static void threadSleep(int sleepValue) throws InterruptedException {
		Thread.sleep(sleepValue);
	}

	public static String elementGetText(WebElement element) {
		String elementText = element.getText();
		return elementText;
	}

	public static void elementClear(WebElement element) {
		element.clear();
	}

	public static void elementSelect(WebElement element, String visible, String value, int index) {
		Select elementSelect = new Select(element);
		elementSelect.selectByIndex(0);
		elementSelect.selectByVisibleText(null);
		elementSelect.selectByValue(null);
	}

	public static void takesScreenShot(String imageName) throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile,
				new File("C:\\Users\\anandraj\\eclipse-workspace\\Zoho_projec1\\screenshot\\" + imageName + ".png"));
	}

	public static void closeOrQuit(String action) {
		if (action.equalsIgnoreCase("close")) {
			driver.close();
		}
		else if (action.equalsIgnoreCase("quite")) {
			driver.quit();
		}
		else if (action.equalsIgnoreCase("quiteandclose")) {
			driver.close();
			driver.quit();
		}
	}

	public static void driverMethods(String action) {
		if (action.equalsIgnoreCase("title")) {
			driver.getTitle();
		}
		else if (action.equalsIgnoreCase("switch")) {
			driver.switchTo();
		}
		else if (action.equalsIgnoreCase("currentUrl")) {
			driver.getCurrentUrl();
		}
	}

	public static void navigate(String action, String url) {
		if (action.equalsIgnoreCase("back")) {
			driver.navigate().back();
		}
		else if (action.equalsIgnoreCase("forward")) {
			driver.navigate().forward();
		}
		else if (action.equalsIgnoreCase("refresh")) {
			driver.navigate().refresh();
		}
		else if (action.equalsIgnoreCase("url")) {
			driver.navigate().to(url);
		}
	}

	public static void waits(Duration time) {
		driver.manage().timeouts().implicitlyWait(time);

	}

	public static void selecMethod(WebElement element, String type, String values) {
		Select elementSelect = new Select(element);
		if (type.equalsIgnoreCase("index")) {
			int index = Integer.parseInt(values);
			elementSelect.selectByIndex(index);
		} else if (type.equalsIgnoreCase("value")) {
			elementSelect.selectByValue(values);
		} else if (type.equalsIgnoreCase("text")) {
			elementSelect.selectByVisibleText(values);
		}

		else if (type.equalsIgnoreCase("dsall")) {
			elementSelect.deselectAll();
		}
		else if (type.equalsIgnoreCase("dsindex")) {
			int index = Integer.parseInt(values);
			elementSelect.deselectByIndex(index);
		} else if (type.equalsIgnoreCase("dsbyvalue")) {
			elementSelect.deselectByValue(values);
		} else if (type.equalsIgnoreCase("dsbytext")) {
			elementSelect.deselectByVisibleText(values);
		} else if (type.equalsIgnoreCase("gasoptions")) {
			elementSelect.getAllSelectedOptions();
		} else if (type.equalsIgnoreCase("gfsoption")) {
			elementSelect.getFirstSelectedOption();
		} else if (type.equalsIgnoreCase("goptions")) {
			elementSelect.getOptions();
		} else if (type.equalsIgnoreCase("ismultipule")) {
			elementSelect.isMultiple();
		}
	}

	public static WebElement elementFind(String method, String element) {
		WebElement findElement = null;
		if (method.equals("class")) {
			findElement = driver.findElement(By.className(element));
		} else if (method.equals("css")) {
			findElement = driver.findElement(By.cssSelector(element));
		} else if (method.equals("id")) {
			findElement = driver.findElement(By.id(element));
		} else if (method.equals("link")) {
			findElement = driver.findElement(By.linkText(element));
		} else if (method.equals("partial")) {
			findElement = driver.findElement(By.partialLinkText(element));
		} else if (method.equals("tag")) {
			findElement = driver.findElement(By.tagName(element));
		} else if (method.equals("xpath")) {
			findElement = driver.findElement(By.xpath(element));
		}
	
		return findElement;
	}

	public static void actions(WebElement element, String type) {
		Actions act = new Actions(driver);
		if (type.equalsIgnoreCase("click")) {
			act.click(element).perform();
		} else if (type.equalsIgnoreCase("context")) {
			act.contextClick(element);
		} else if (type.equalsIgnoreCase("double")) {
			act.doubleClick(element);
		}
	}

	public static void javaScriptExecutor(WebElement element, int range, String action) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (action.equalsIgnoreCase("scrollintoview")) {
			js.executeScript("arguments[0].scrollIntoView();", element);
		} else if (action.equalsIgnoreCase("scrollby")) {
			js.executeAsyncScript("window.ScrollBy(0," + range + ");");
		} else if (action.equalsIgnoreCase("click")) {
			js.executeScript("arguments[0].click();", element);
		}
	}
	
	public static void alertSendkeys(String value) {
	driver.switchTo().alert().sendKeys(value);
	}
	public static void alertOptions(String option) {
		if(option.equals("ok")) {
			driver.switchTo().alert().accept();
		}
		else if(option.equals("cancel")) {
			driver.switchTo().alert().dismiss();;
		}
	}
	public static void frameOptins(WebElement element,String option, String value) {
		if(option.equalsIgnoreCase("index")) {
			int index = Integer.parseInt(value);
		driver.switchTo().frame(index);
		}
		else if(option.equalsIgnoreCase("nameorid")) {
		driver.switchTo().frame(value);
		}
		else if(option.equalsIgnoreCase("element")) {
		driver.switchTo().frame(element);
		}
		else if(option.equalsIgnoreCase("parentframe")) {
		driver.switchTo().parentFrame();
		}
	}
	public static void defaultContent(){
		
		driver.switchTo().defaultContent();
		}
	
	
	
	
	
	

}
