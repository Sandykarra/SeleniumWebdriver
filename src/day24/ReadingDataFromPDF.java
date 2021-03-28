package day24;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.util.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadingDataFromPDF {

	public static void main(String[] args) throws IOException  {
		//reading data from pdf file
		
		FileInputStream fileinputstream=new FileInputStream("C:\\Demofiles\\sample.pdf");
		
		PDFParser parser=new PDFParser(fileinputstream);
		parser.parse();
		PDFTextStripper stp=new PDFTextStripper();
		
		String data=stp.getText(parser.getPDDocument());
		
		System.out.println(data);
	
	}

}
