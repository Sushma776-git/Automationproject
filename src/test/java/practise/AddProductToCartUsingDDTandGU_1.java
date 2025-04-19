package practise;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import Genericutility.FileUtility;
import Genericutility.JavaUtility;
import Genericutility.SeleniumUtility;
import ObjectRepository.LoginPage;

public class AddProductToCartUsingDDTandGU_1 {

public static void main(String[] args) throws IOException 
{
		
		//Create Object Of All Required Utility Classes
		FileUtility fUtil = new FileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		JavaUtility jUtil = new JavaUtility();
		
		// Read Common Data from Property file
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");

		// Read Test Data From Excel File
		String PRODUCTNAME = fUtil.readDataFromExcel("Sheet1", 1, 2);

		// Step 1: Launch the browser
		WebDriver driver = new ChromeDriver();
		sUtil.maxmizeWindow(driver);
		sUtil.addImplictelyWait(driver);
		

		// Step 2: Load the Application
		driver.get("https://www.saucedemo.com");

		// Step 3: login To Application
		//driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		//driver.findElement(By.id("password")).sendKeys(PASSWORD);
		//driver.findElement(By.id("login-button")).click();

		LoginPage IP=new LoginPage(driver);
		IP.loginToApp(USERNAME, PASSWORD);
		
	//IP.getUsernameEdt().sendKeys(USERNAME);
	//IP.getPasswordEdt().sendKeys(PASSWORD);
		//IP.getLognbtn().click();
		
		
		// Step 4: Click on a Product
		WebElement productEle = driver.findElement(By.xpath("//div[.='" + PRODUCTNAME + "']"));
		String pAddedToCart = productEle.getText();
		productEle.click();

		// Step 5: Add the Product To Cart
		driver.findElement(By.id("add-to-cart")).click();

		// Step 6: Navigate to Cart
		driver.findElement(By.id("shopping_cart_container")).click();
		
		//Capture Screenshots for reference 
		String screenshotname = "Tc_001"+jUtil.getSystemDateInFormat();
		String path = sUtil.captureScreenShot(driver, screenshotname);
		System.out.println(path);

		// Step 7: Validate the product in Cart
		String pInCart = driver.findElement(By.className("inventory_item_name")).getText();
		if (pInCart.equals(pAddedToCart)) {
			System.out.println("PASS");
			System.out.println(pInCart);
		} else {
			System.out.println("FAIL");
		}

		// Step 8: Logout of App
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();
		}



		



	}


