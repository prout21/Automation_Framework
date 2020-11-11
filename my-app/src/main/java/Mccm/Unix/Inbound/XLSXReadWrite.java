package Mccm.Unix.Inbound;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXReadWrite {
	private File file;
	private FileInputStream fis;
	private FileOutputStream fos;
	private XSSFWorkbook wb;
	
	
	public XLSXReadWrite(String FilePath)
	{
		file = new File(FilePath);
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String findFirstSheetName()
	{
		String sheetName = wb.getSheetName(0);
		return sheetName;
		
	}
	
	public void changeSheetName(String newSheetName)
	{
		wb.setSheetName(0, newSheetName);
		try {
			//Save the sheet after changing the file name
			write();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public int getRowCount(String sheetName)
	{
		XSSFSheet sheet = wb.getSheet(sheetName);
		if (sheet == null)
		{
			return 0;
		}
			return sheet.getLastRowNum();
		
	}
	
	@SuppressWarnings("deprecation")
	public int findColumnIndex(String sheetName, String cellContent)
	{
		int colIndex=-1;
		XSSFSheet sheet = wb.getSheet(sheetName);
		if (sheet == null)
		{
			return 0;
		}
		for (Row row : sheet) {
	        for (Cell cell : row) {
	            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
	                if (cell.getRichStringCellValue().getString().trim().equals(cellContent.trim())) {
	                	colIndex=cell.getColumnIndex();
	                }
	            }
	        }
	    }
		return colIndex;  
		
	}
	
	@SuppressWarnings("deprecation")
	public int findRowIndex(String sheetName, String cellContent)
	{
		int rowIndex=-1;
		XSSFSheet sheet = wb.getSheet(sheetName);
		if (sheet == null)
		{
			return 0;
		}
		for (Row row : sheet) {
	        for (Cell cell : row) {
	            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
	                if (cell.getRichStringCellValue().getString().trim().equals(cellContent.trim())) {
	                	rowIndex=cell.getRowIndex();
	                }
	            }
	        }
	    }
		return rowIndex;  
		
	}
	
	public int getCellCount(String sheetName, int rowIndex)
	{
		XSSFSheet sheet=wb.getSheet(sheetName);
		if (sheet == null)
		{
			return 0;
		}
		XSSFRow row = sheet.getRow(rowIndex);
		if (row == null)
		{
			return 0;
		}
		return row.getLastCellNum(); 
		
	}
	
	public String getCellValue(String sheetName, int rowIndex, int cellIndex) {
		XSSFSheet sheet = wb.getSheet(sheetName);
		if (sheet == null) {
			return "sheet doesn't exist for sheet name : " + sheetName;
		}
		XSSFRow row = sheet.getRow(rowIndex);
		if (row == null) {
			return "row doesn't exist for index : " + rowIndex;
		}
		XSSFCell cell = row.getCell(cellIndex);
		if (cell == null) {
			return "";
		}
		return cell.toString().trim();
	}
	
	public void writeNumericCellValue(String sheetName, int rowIndex,
			int cellIndex, double value) throws IOException {
		XSSFCell cell = getCell(sheetName, rowIndex, cellIndex);
		cell.setCellValue(value);
		write();
	}
	

	
	public void writeStringCellValue(String sheetName, int rowIndex,
			int cellIndex, String value) throws IOException {
		XSSFCell cell = getCell(sheetName, rowIndex, cellIndex);
		cell.setCellValue(value);
		write();
	}
	
	public void writeBooleanCellValue(String sheetName, int rowIndex,int cellIndex, Boolean value) throws IOException {
		XSSFCell cell = getCell(sheetName, rowIndex, cellIndex);
		cell.setCellValue(value);
		write();
	}
	
	public void writeDateCellValue(String sheetName, int rowIndex,int cellIndex, Date value) throws IOException {
		XSSFCell cell = getCell(sheetName, rowIndex, cellIndex);
		cell.setCellValue(value);
		write();
	}
	
	private void write() throws FileNotFoundException, IOException {
		fos = new FileOutputStream(file);
		wb.write(fos);
		fos.close();
	}
	
	private XSSFCell getCell(String sheetName, int rowIndex, int cellIndex) {
		XSSFSheet sheet = wb.getSheet(sheetName);
		if (sheet == null) {
			sheet = wb.createSheet(sheetName);
		}
		XSSFRow row = sheet.getRow(rowIndex);
		if (row == null) {
			row = sheet.createRow(rowIndex);
		}
		XSSFCell cell = row.getCell(cellIndex);
		if (cell == null) {
			cell = row.createCell(cellIndex);
		}
		return cell;
	}
}
