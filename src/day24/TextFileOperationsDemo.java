package day24;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*text files  ---> .txt

//Operation		Method				Package
//----------------------------------------------------------------
//To create file	createNewFile()			java.io.File
//To read file		read()				java.io.FileReader
//To write file		write()				java.io.FileWriter
//To delete file	delete()			java.io.File*/

public class TextFileOperationsDemo {

	public static void main(String[] args) throws IOException {
		
	//1. To create file*************(return boolean value)*************
		File myfile=new File("C:\\Demofiles\\file.txt");
		//to check the file is created or not
		if(myfile.createNewFile())
		{
			System.out.println("file is created....");
			}
		else {
			System.out.println("fiel is already existed ");
		}
		//2.//To write data into the file***************
		FileWriter mywritter=new FileWriter("C:\\Demofiles\\file.txt");
		mywritter.write("Welcome to automation testing with SDET");
		mywritter.write("It teaches java with selenium");
		mywritter.write("need alot of practise....");
		mywritter.close();
		System.out.println("data has written into the file...");
		
		//3.To read the data from file************************
		FileReader myreader =new FileReader("C:\\Demofiles\\file.txt");
		Scanner myscanner=new Scanner(myreader); // to take input from file
		while(myscanner.hasNextLine())
		{
			String data=myscanner.nextLine();
			System.out.println(data); 
			 
		}
myscanner.close();
myreader.close();
	
//4. rename the file
File my_oldfile=new File("C:\\Demofiles\\file.txt");
	File my_newfile=new File("C:\\Demofiles\\file123.txt");
	
			 boolean value=my_oldfile.renameTo(my_newfile);
			 if(value)
			 {
				 System.out.println("the file is renamed...");
			 }else {
				 System.out.println("file is not renamed....");
			
			 }
			 //5. delete the file.........
			File myfiledel=new File("C:\\Demofiles\\file123.txt");
			if(myfiledel.delete()) {
				//System.out.println("the file has been removed....");
				System.out.println("file deleted "+myfiledel.getName());
			}else {
				System.out.println("The file still exist");
			}
			 
			 
			 
	}

}
