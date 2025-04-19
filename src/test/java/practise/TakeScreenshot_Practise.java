package practise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import Genericutility.FileUtility;
import Genericutility.JavaUtility;
import Genericutility.SeleniumUtility;

public class TakeScreenshot_Practise {

	public static <XSSFWorkBook> void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sushma.goud\\automation testing\\chromedriver-win64\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		//open google
	//	driver.get("https://www.google.com/");
		//open swag labs
		
		//driver.get("https://www.saucedemo.com/");
		//maximize window
		driver.manage().window().maximize();
		//applying wait statement
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		File excelFile = new File(".\\src\\test\\resources\\SushmaPractise.xlsx");
		
		System.out.println(excelFile.exists());
		
		//Create object for all uit;ity class
		FileUtility fUtil= new FileUtility();
		SeleniumUtility sUtil=new SeleniumUtility();
		JavaUtility jUtil=new JavaUtility();
		
		
		
		// Read Common Data from Property file
		
		
		
	
		
		driver.get("https://www.google.com/");
		driver.get("https://www.amazon.in/");
 File SourceFile=driver.getScreenshotAs(OutputType.FILE);
 File DestinationFile=new File("C:\\Users\\Sushma.goud\\eclipse-workspace\\Automationframework-swagelabs\\Screenshot_image-2.jpg");
 FileUtils.copyFile(SourceFile, DestinationFile);
 System.out.println("screenshot saved successfully");
 driver.quit();
 
	FileInputStream fis =new FileInputStream(excelFile);
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
    XSSFSheet Sheet = workbook.getSheet("Sheet1");
	XSSFRow Rows=Sheet.getRow(1);
	XSSFCell Cell=Rows.getCell(1);
	String S=Cell.getStringCellValue();
	System.out.println(S);
	
	
	 
		
	} 

}
