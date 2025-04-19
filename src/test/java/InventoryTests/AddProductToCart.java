package InventoryTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Genericutility.BaseClass;
import Genericutility.FileUtility;
import Genericutility.GenericUtility;
import Genericutility.JavaUtility;
import Genericutility.SeleniumUtility;
import ObjectRepository.CartPage;
import ObjectRepository.InventoryItemPage;
import ObjectRepository.InventoryPage;
import ObjectRepository.LoginPage;


@Listeners(Genericutility.ListenersImplementation.class)

public class AddProductToCart extends BaseClass
{

	@Test(groups="SmokeSuit")
	
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		// Create Object Of All Required Utility Classes
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
		ChromeDriver driver = new ChromeDriver();
		sUtil.maxmizeWindow(driver);
		sUtil.addImplictelyWait(driver);

		// Step 2: Load the Application
		driver.get(URL);

		// Step 3: login To Application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		// Step 4: Click on a Product
		InventoryPage ip = new InventoryPage(driver);
		String pAddedToCart = ip.clickOnAProduct(driver, PRODUCTNAME);

		// Step 5: Add the Product To Cart
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddToCartBtn();

		// Step 6: Navigate to Cart
		ip.clickOnCartContainer();

		// Step 7: Validate the product in Cart
	    CartPage cp = new CartPage(driver);
	    String pInCart = cp.getProductName();
		
		if (pInCart.equals(pAddedToCart)) {
			System.out.println("PASS");
			System.out.println(pInCart);
		} else {
			System.out.println("FAIL");
		}

		// Step 8: Logout of App
		ip.logoutOfApp();
	}
	}


