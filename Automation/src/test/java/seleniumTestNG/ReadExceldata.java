package seleniumTestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ReadExceldata {
	public void readExcel(String filePath, String fileName, String sheetName) throws IOException {
		File file = new File("C:\\Users\\srilekha.shivadevuni\\check.xls");
		FileInputStream inputStream = new FileInputStream(file);
		// Workbook wb = null;
		Workbook wb = new HSSFWorkbook(inputStream);
		// WebDriver driver = new ChromeDriver();
		// Read sheet inside the workbook by its name
		Sheet s = wb.getSheet("read");
		// s.getlast
		// Find number of rows in excel file
		int rowCount = s.getLastRowNum() - s.getFirstRowNum();
		// Create a loop over all the rows of excel file to read it
		for (int i = 0; i < rowCount + 1; i++) {
			Row row = s.getRow(i);
			// Create a loop to print cell values in a row
			for (int j = 0; j < row.getLastCellNum(); j++) {
			// Print Excel data in console
				System.out.print(row.getCell(j).getStringCellValue() + "||");
			}
			System.out.println();
		}
	}
	// Main function is calling readExcel function to read data from excel file

	public static void main(String... strings) throws IOException {

		ReadExceldata DT = new ReadExceldata();

		// DT.readExcel(filePath, fileName, sheetName);

		DT.readExcel("C:\\Users\\srilekha.shivadevuni\\check.xls", "selenium.xls", "read");

	}

}
