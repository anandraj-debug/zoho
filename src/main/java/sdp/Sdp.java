package sdp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.web.pom.HomePage;
import com.web.pom.SignUp;

public class Sdp {
	 public static WebDriver driver;
	public HomePage hp;
	public SignUp sp;
	
	public Sdp(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this );
	}
	 public HomePage gethomePage() {
		 if(hp==null) {
			  hp = new HomePage(driver);
			 
		 }
		 return hp; 
		 }
	 
	 public SignUp getsignUp() {
		 if(sp==null) {
			 sp = new SignUp(driver);
		 }
		 return sp; 
		 }

}
	
	

