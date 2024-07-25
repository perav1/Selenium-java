package com.dwp.qa.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataDriven {
	
	@DataProvider(name="driverTest")
	public Object[][] getData() throws IOException 
	{
		
    	 InputStream fis = getClass().getClassLoader().getResourceAsStream("excel/ActualDWPs.xlsx");
    	 if (fis == null) {
             throw new IOException("Excel file not found in resources.");
    	 }
    	 XSSFWorkbook wb = new XSSFWorkbook(fis);
         XSSFSheet sheet = wb.getSheetAt(1);
         DataFormatter formatter = new DataFormatter();

         XSSFRow row = sheet.getRow(1); // Row 1 is the first row after the header
         XSSFCell cell = row.getCell(0); // First column (index 0)
         String itemNumber = formatter.formatCellValue(cell).trim(); // Convert cell value to string and trim extra spaces

         wb.close();
         return new Object[][]{{itemNumber}};
     }
     @DataProvider(name = "productData")
     public Object[][] getProductData() throws IOException {
         InputStream fis = getClass().getClassLoader().getResourceAsStream("excel/ActualDWPs.xlsx");
         if (fis == null) {
             throw new IOException("Excel file not found in resources.");
         }
         XSSFWorkbook wb = new XSSFWorkbook(fis);
         XSSFSheet sheet = wb.getSheetAt(1); // Assuming the data is on the second sheet (index 1)
         DataFormatter formatter = new DataFormatter();

         XSSFRow row = sheet.getRow(4);
         if (row == null) {
             throw new IOException("Row 5 not found in the sheet.");
         }

         // Column indices: Item Number (0), PA Number (3)
         XSSFCell itemCell = row.getCell(0); // First column (index 0)
         XSSFCell paCell = row.getCell(4);   // Fourth column (index 3)

         String itemNumber = formatter.formatCellValue(itemCell).trim(); // Convert cell value to string and trim extra spaces
         String paNumber = formatter.formatCellValue(paCell).trim();

         // Return the data as a 2D array
         return new Object[][]{{itemNumber, paNumber}};
     }

     @DataProvider(name = "copyData")
     public Object[][] getCopyData() throws IOException {
         InputStream fis = getClass().getClassLoader().getResourceAsStream("excel/ActualDWPs.xlsx");
         if (fis == null) {
             throw new IOException("Excel file not found in resources.");
         }
         XSSFWorkbook wb = new XSSFWorkbook(fis);
         XSSFSheet sheet = wb.getSheetAt(1); // Assuming the data is on the second sheet (index 1)
         DataFormatter formatter = new DataFormatter();

         XSSFRow row = sheet.getRow(3);
         if (row == null) {
             throw new IOException("Row 5 not found in the sheet.");
         }

         // Column indices: Item Number (0), PA Number (3)
         XSSFCell itemCell = row.getCell(0); // First column (index 0)
         XSSFCell fulfillmentCell = row.getCell(15);   // Fourth column (index 3)

         String itemNumber = formatter.formatCellValue(itemCell).trim(); // Convert cell value to string and trim extra spaces
         String fulfillment = formatter.formatCellValue(fulfillmentCell).trim();

         // Return the data as a 2D array
         return new Object[][]{{itemNumber, fulfillment}};
     }
     @DataProvider(name = "newData")
     public Object[][] getNewData() throws IOException {
         InputStream fis = getClass().getClassLoader().getResourceAsStream("excel/ActualDWPs.xlsx");
         if (fis == null) {
             throw new IOException("Excel file not found in resources.");
         }
         XSSFWorkbook wb = new XSSFWorkbook(fis);
         XSSFSheet sheet = wb.getSheetAt(1); // Assuming the data is on the second sheet (index 1)
         DataFormatter formatter = new DataFormatter();

         XSSFRow row = sheet.getRow(6);
         if (row == null) {
             throw new IOException("Row 5 not found in the sheet.");
         }

         // Column indices: Item Number (0), PA Number (3)
         XSSFCell itemCell = row.getCell(0); // First column (index 0)
         XSSFCell fulfillmentCell = row.getCell(15);   // Fourth column (index 3)

         String itemNumber = formatter.formatCellValue(itemCell).trim(); // Convert cell value to string and trim extra spaces
         String fulfillment = formatter.formatCellValue(fulfillmentCell).trim();

         // Return the data as a 2D array
         return new Object[][]{{itemNumber, fulfillment}};
     }
	

}
