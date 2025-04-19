package practise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DDT_Framework {

	private static int i;
	private static int j;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
File excelFile = new File("./src/test/resources/Resourcedata.xlsx");
	
	System.out.println(excelFile.exists());
	
	FileInputStream fis =new FileInputStream(excelFile);
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = workbook.getSheet("Sheet2");
	int noOfRows=(sheet.getPhysicalNumberOfRows());
	int noOfColumns =sheet.getRow(1).getLastCellNum();
	

	//System.out.println(sheet.getLastRowNum())
	for (int i=1; i < noOfRows; i++);
	{
	for(int j=0; j< noOfColumns;j++);
	
	{
		DataFormatter df = new DataFormatter();
		System.out.println(df.formatCellValue(sheet.getRow(1).getCell(j)));
		
	//System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
	}
	System.out.println();
	}
	workbook.close();
	 fis.close();
	
	}

}
