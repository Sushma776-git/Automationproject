package practise;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DDT_Framework_23_mar_2025 {

    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sushma.goud\\automation testing\\chromedriver-win64\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");

        // Check if Excel file exists
        File excelFile = new File("C:\\Users\\Sushma.goud\\eclipse-workspace\\Automationframework-swagelabs\\src\\test\\resources\\Resourcedata.xlsx");
        if (!excelFile.exists()) {
            System.err.println("Excel file not found!");
            
            return;
        }

        try (FileInputStream FIS = new FileInputStream(excelFile);
             XSSFWorkbook wb = new XSSFWorkbook(FIS)) {

            XSSFSheet s1 = wb.getSheet("Sheet2");
            if (s1 == null) {
                System.err.println("Sheet2 not found!");
                return;
            }

            DataFormatter formatter = new DataFormatter();
            int rowcount = s1.getLastRowNum();

            for (int i = 1; i <= rowcount; i++) {
                XSSFRow row = s1.getRow(i);
              //  if (row == null) continue;

                String name = formatter.formatCellValue(row.getCell(1));
                String Password = formatter.formatCellValue(row.getCell(2));

                driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(name);
                driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Password);
                driver.findElement(By.xpath("//input[@type='submit']")).click();

                // Clear fields for next iteration (if needed)
              //  driver.findElement(By.xpath("//input[@id='user-name']")).clear();
              //  driver.findElement(By.xpath("//input[@id='password']")).clear();
            }
        } 
    }
}