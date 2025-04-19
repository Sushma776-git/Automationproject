package practise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven_Framework {

    public static void main(String[] args) {
        try {
            File excelFile = new File("C:\\Users\\Sushma.goud\\eclipse-workspace\\Automationframework-swagelabs\\src\\test\\resources\\Commonfile");
            System.out.println(excelFile.exists());

            FileInputStream fis = new FileInputStream(excelFile);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet("Sheet1");

            int noOfRows = sheet.getPhysicalNumberOfRows();
            int noOfColumns = sheet.getRow(0).getLastCellNum();

            DataFormatter df = new DataFormatter();

            
            // Assuming username is in column 0 and password is in column 1
            for (int i = 1; i < noOfRows; i++) { // Start from 1 to skip header row
                String username = df.formatCellValue(sheet.getRow(i).getCell(0));
                String password = df.formatCellValue(sheet.getRow(i).getCell(1));
                System.out.println("Username: " + username + ", Password: " + password);
                
            }

            workbook.close();
            fis.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}