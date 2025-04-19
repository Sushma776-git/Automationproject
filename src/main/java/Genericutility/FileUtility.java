package Genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to File operations
 * @author sushma.goud
 *
 */
public class FileUtility {
	
	/**
	 * This method will read data from property file for the key provided by 
	 * Caller and return the value to caller
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\Sushma.goud\\eclipse-workspace\\Automationframework-swagelabs\\src\\test\\resources\\Commonfile");
	    Properties p = new Properties();
	    p.load(fis);
	    String value = p.getProperty(key);
	    return value;
	}
	
	
	/**
	 * This method will read data from excel file and return the
	 * value to Caller
	 * @param sheetname
	 * @param rowNo
	 * @param CelNo
	 * @

	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetname,int rowNo, int CelNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Resourcedata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetname).getRow(rowNo).getCell(CelNo).getStringCellValue();
	    return value;
	}
	

}
 