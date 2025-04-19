package Genericutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ObjectRepository.InventoryPage;
import ObjectRepository.LoginPage;

public class BaseClass {

public FileUtility fUtil1= new FileUtility();
public JavaUtility fUtil11=new JavaUtility();
public SeleniumUtility fUtil=new SeleniumUtility();


public static WebDriver driver;



@BeforeSuite(alwaysRun = true)
public void bsConfig()
{
	System.out.println("----- Database Connection successfull -----");
}

//@Parameters("Browser")
//@BeforeTest
@BeforeClass(alwaysRun = true)
public void bcConfig(/*String pValue*/) throws IOException
{
	String URL = fUtil.readDataFromPropertyFile("url");
	
	driver = new EdgeDriver();
	
	//For Cross Browser Execution - Run time polymorphism
//	if(pValue.equals("chrome"))
//	{
//		driver = new ChromeDriver();
//	}
//	else if(pValue.equals("edge"))
//	{
//		driver = new EdgeDriver();
//	}
//	else
//	{
//		driver = new EdgeDriver();
//	}
		
	
	
	fUtil.maxmizeWindow(driver);
	fUtil.addImplictelyWait(driver);
	
	driver.get(URL);
	
	System.out.println("----- Browser Launch successfull -----");
}

@BeforeMethod(alwaysRun = true)
public void bmConfig() throws IOException
{
	String USERNAME = fUtil.readDataFromPropertyFile("username");
	String PASSWORD = fUtil.readDataFromPropertyFile("password");
	
	LoginPage lp = new LoginPage(driver);
	lp.loginToApp(USERNAME, PASSWORD);
	
	System.out.println("----- Login to App successfull -----");
}


@AfterMethod(alwaysRun = true)
public void amConfig()
{
	InventoryPage ip = new InventoryPage(driver);
	ip.logoutOfApp();
	
	System.out.println("----- Logout of App successfull -----");
}

//@AfterTest
@AfterClass(alwaysRun = true)
public void acConfig()
{
	driver.quit();
	
	System.out.println("----- Browser closure successfull -----");
}


@AfterSuite(alwaysRun = true)
public void asConfig()
{
	System.out.println("----- Database Closure successfull -----");
}
		
	}
	

