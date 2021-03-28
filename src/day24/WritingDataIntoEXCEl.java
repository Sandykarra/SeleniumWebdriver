package day24;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoEXCEl {

	public static void main(String[] args) throws IOException {
		FileOutputStream file=new FileOutputStream("C:\\Demofiles\\sample.xlsx");

	XSSFWorkbook workbook=new XSSFWorkbook();//workbook
	XSSFSheet sheet=workbook.createSheet("data"); //sheet
	for(int r=0;r<6;r++) {
	XSSFRow row=sheet.createRow(r); //rows
		for(int c=0;c<4;c++) {
			XSSFCell cell=row.createCell(c); //cells
			cell.setCellValue("Selenium");
		}
	}
	workbook.write(file); //mandatory 
	workbook.close();
	file.close();
	}

}
