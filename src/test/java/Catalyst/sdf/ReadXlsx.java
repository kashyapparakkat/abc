package Catalyst.sdf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadXlsx {
	public static Map<String, String> readXLSXFile(String fileName, String sheetName) {
		InputStream XlsxFileToRead = null;
		XSSFWorkbook workbook = null;
		HashMap<String, String> mapFolderDetails = new HashMap<String, String>();
		try {
			XlsxFileToRead = new FileInputStream(fileName);
			
			//Getting the workbook instance for xlsx file
			workbook = new XSSFWorkbook(XlsxFileToRead);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//getting the first sheet from the workbook using sheet name. 
		// We can also pass the index of the sheet which starts from '0'.
		XSSFSheet sheet = workbook.getSheet(sheetName);
		XSSFRow row;
		XSSFCell cell;
		
		//Iterating all the rows in the sheet
		Iterator<Row> rows = sheet.rowIterator();
		while (rows.hasNext()) {
			row = (XSSFRow) rows.next();
			
			//Iterating all the cells of the current row
			Iterator<Cell> cells = row.cellIterator();
			int counter = 0;
			String key = "";
			String value = "";

			while (cells.hasNext()) {
				cell = (XSSFCell) cells.next();
				cell.setCellType(Cell.CELL_TYPE_STRING);
				counter++;
				if(counter%2!=0){
					key = cell.getStringCellValue();
				}
				else {
					value = cell.getStringCellValue();
				}
			}
			mapFolderDetails.put(key, value);
			System.out.println();
			try {
				XlsxFileToRead.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return mapFolderDetails;
	}
}