package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains all the Testdata for Excel file
 * @author DELL
 *
 */
public class MobileExcelUtility extends InstanceClass {
	private Workbook workbook;
	private Sheet sheet;
	/**
	 * This method is used to initialize the excel file
	 * @param excelpath
	 */
	
	public void initializeExcelFile(String excelPath)
	{
		FileInputStream fis;
		try {
			fis = new FileInputStream(excelPath);
			try {
				 workbook = WorkbookFactory.create(fis);
			} catch (EncryptedDocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * This method is used to read data from Excel
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 */
	public String getDataFromExcel(String sheetname, int rowNumber, int cellNumber)
	{
		sheet = workbook.getSheet(sheetname);
		return new DataFormatter().formatCellValue(sheet.getRow(rowNumber).getCell(cellNumber));
	}
	/**
	 * This method is used to write the data to the Excel
	 * @param sheetName
	 * @param rowNumber
	 * @param value
	 * @param cellNumber
	 */
	public void setDataToExcel(String sheetname, int rowNumber, int cellNumber, String value,String excelPath )
	{
		sheet=workbook.getSheet(sheetname);
		sheet.getRow(rowNumber).createCell(cellNumber).setCellValue(value);
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(excelPath);
			try {
				workbook.write(fos);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to write data into excelsheet
	 * @param excelSavepath
	 */
	public void provideDataToExcel(String excelPath)
	{
		
	}
	
	/**
	 * This method is used to close workbook
	 */
	public void closeExcelSheet()
	{
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}