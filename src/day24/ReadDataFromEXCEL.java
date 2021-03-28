package day24;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromEXCEL {

	public static void main(String[] args) throws IOException {
		
//1. read data from excel file....for that we have to open the file in reading mode
// we have to use fileInputStream class
		FileInputStream file=new FileInputStream("C:\\Demofiles\\JiraTestCases.xlsx");
	XSSFWorkbook workbook=new XSSFWorkbook(file);
XSSFSheet  sheet=workbook.getSheet("Testcases");
int	rows=sheet.getLastRowNum(); //number of rows in a sheet
	int cols=sheet.getRow(1).getLastCellNum();
	System.out.println("num of rows "+rows); //11 (it count from 0)
	System.out.println("num of colums "+cols);//7
	
	//to read the data from cells
	for(int r=0; r<=rows; r++) {
	XSSFRow	row=sheet.getRow(r); // to get first row 
		for(int c=0; c<cols; c++) {  // if yo want to use c=<cols we need to mention c=1
			XSSFCell cell=row.getCell(c);
			// from this cell object we can extract data
			System.out.print(cell.toString()+"  "); //we have dataspecific models also availble
		}
		System.out.println();
	}
	
	workbook.close();
	file.close();
	
	}

}
