package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  //Rule:1 create a deperate POM class
{
private static final String username = null;
//Rule:2 identify all the web elements using 

private static final CharSequence password = null;
		
		@FindBy(id="user-name")
		private WebElement usernameEdt;
		@FindBy(id="password") 
		private WebElement passwordEdt;
		@FindBy(id="login-button") 
		private WebElement lognbtn;
		
		
		// Rule:3 Create a constructor to initialize webelement
		
		public  LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		// Rule:4 provide getter to access the webelement

		public WebElement getUsernameEdt() {
			return usernameEdt;
		}


		public void setUsernameEdt(WebElement usernameEdt) {
			this.usernameEdt = usernameEdt;
		}


		public WebElement getPasswordEdt() {
			return passwordEdt;
		}


		public void setPasswordEdt(WebElement passwordEdt) {
			this.passwordEdt = passwordEdt;
		}


		public WebElement getLognbtn() {
			return lognbtn;
		}


		public void setLognbtn(WebElement lognbtn) {
			this.lognbtn = lognbtn;
		}
		
		public void loginToApp(String username, String password )
		{
			usernameEdt.sendKeys(username);
			passwordEdt.sendKeys(password);
			lognbtn.click();
		}
		
		
		}


