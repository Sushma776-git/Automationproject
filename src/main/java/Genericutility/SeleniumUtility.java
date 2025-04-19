package Genericutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consits of generic method related to selenium tool
 * @author sushma.goud
 * @param <Expected>
 * @param <TakeScreenshot>
 */



public   class SeleniumUtility 
{


/**
 * This method will maximize teh window 	
 * @param args
 */

	public  void maxmizeWindow(WebDriver driver)
	{
		// TODO Auto-generated method stub
driver.manage().window().maximize();
}
	/**
     * This method will minimise the window 	
	 */
	public  void minimizedWindow(WebDriver driver)
	{
		driver.manage().window().minimize();	
	}
	
	/**
     * This method will add implicity wait to code	
	 */
	public void addImplictelyWait(WebDriver driver)
	{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	}
	/**
	 * Explicirty wait
	 * @param driver
	 * @param element
	 */
	
	public void WaitForElementVisible(WebDriver driver, WebElement element)
	{
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * this method will wait for particular element to be clickable
	 * 
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	/**
	 * This method will handle dropdown by index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * This method will handle dropdown by visible text
	 * @param element
	 * @param visibleText
	 */
	public void handleDropDown(WebElement element,String visibleText)
	{
		Select s = new Select(element);
		s.selectByVisibleText(visibleText);
	}
	
	/**
	 * This method will handle dropdown by value
	 * @param Value
	 * @param element
	 */
	public void handleDropDown(String Value, WebElement element)
	{
		Select s = new Select(element);
		s.selectByValue(Value);
	}
	/**
	 * This method will handle action class
	 */
	public void mouseHoverAction(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.clickAndHold(element).perform();
		}
	/**
	 * This method will handle Click and hold action class
	 */
	public void clickAndHoldAction(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	
		}
	
	/**
	 * This method will perform rightclick action
	 */
	public void rightclickAction(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	
	
	/**
	 * This method will perform doubleclick action
	 */
	public void doubleclickActionn(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.doubleClick(element).perform();
	
	}
	

	/**
	 * This method will perform drag and drop action
	 */
	public void dragAndDrop(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.dragAndDrop(src,targ).build().perform();
	
	}
	

	/**
	 * This method will Handle frame by element
	 */
	public void handleFrame(WebDriver driver,WebElement element)
	{
	driver.switchTo().frame(element);	
		
	}
	
	/**
	 * This method will Handle frame by ID orname
	 */
	public void handleFrame1(WebDriver driver,String IDorName)
	{
	driver.switchTo().frame(IDorName);	
	}
	
	/**
	 * This method will Handle control back to immediate parent frame
	 */
	public void SwitchToParent(WebDriver driver)
	{
	driver.switchTo().parentFrame();	
	}
	
	
	
	/**
	 * This method will switch the control back to mainpage
	 */
	public void SwitchTodefaault(WebDriver driver)
	{
	driver.switchTo().defaultContent();	
	}
	
	/**
	 * This method will handle frame by index
	 */
	public void handleframe(WebDriver driver,int index)
	{
	driver.switchTo().frame(index);	
	}
	
	/**
	 * This method will handle windows
	 */
	public void SwitchToWindow(WebDriver driver,String windowHandle)
	{
	driver.switchTo().window(windowHandle);	
	}
	
	/**
	 * This method will handle accept alerts
	 */
	public void acceptAlert(WebDriver driver)
	{
	driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will handle cancel alerts
	 */
	public void dismissAlert(WebDriver driver)
	{
	driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will handle  alert text and return to caller
	 * @return 
	 */
	public String getAlertText(WebDriver driver)
	{
	return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will enter data into alert popup
	 */
	public void enterAlertData(WebDriver driver, String alertData)
	{
	 driver.switchTo().alert().sendKeys(alertData);
	}
	
	/**
	 * This method will scrolldown by 500 units
	 */
	public void ScrolDown(WebDriver driver)
	{
	 JavascriptExecutor js=(JavascriptExecutor) driver;
	 js.executeScript("window.ScrollBy(0,500);", "");
	}
	
	/**
	 * This method will scrollup by 500 units
	 */
	public void ScrolUp(WebDriver driver)
	{
	 JavascriptExecutor js=(JavascriptExecutor) driver;
	 js.executeScript("window.ScrollBy(500,0);", "");
	}
	
	/**
	 * This method will scrollright by 500 units
	 */
	public void ScrollRight(WebDriver driver)
	{
	 JavascriptExecutor js=(JavascriptExecutor) driver;
	 js.executeScript("window.ScrollBy(500,0);", "");
	}
	
	/**
	 * This method will scrollLeft by 500 units
	 */
	public void ScrollLeft(WebDriver driver)
	{
	 JavascriptExecutor js=(JavascriptExecutor) driver;
	 js.executeScript("window.ScrollBy(-500,0);", "");
	}
	
	/**
	 * This method is used for capturing screenshot and return path to caller
	 * @return 
	 */
	
	public String captureScreenShot(WebDriver driver,String screenShotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("C:\\Users\\Sushma.goud\\eclipse-workspace\\Automationframework-swagelabs\\Screenshot"+screenShotName+".png"); //tsname_date_Time
		FileHandler.copy(src, dst);
		
		return dst.getAbsolutePath(); //For Extent reports
			}
	public String readDataFromPropertyFile(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
	
	
	
	
	


