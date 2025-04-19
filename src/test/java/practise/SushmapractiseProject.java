package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SushmapractiseProject
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sushma.goud\\automation testing\\chromedriver-win64\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		//open google
		driver.get("https://www.google.com/");
		//open swag labs
		
		driver.get("https://www.saucedemo.com/");
		//maximize window
		driver.manage().window().maximize();
		//applying wait statement
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//provide username
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("USERNAME");
		
		//provide pasword
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("PASSWORD");
		
		//clcik on login
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		//click on webelement
		driver.findElement(By.xpath("//img  [@alt=\'Sauce Labs Backpack\']")).click();
		driver.findElement(By.xpath("//button [@class='btn btn_primary btn_small btn_inventory']")).click();
		driver.findElement(By.xpath("//a [@class='shopping_cart_link']")).click();
		
		
		
		
		
	}

}
