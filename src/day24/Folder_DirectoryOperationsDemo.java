package day24;

/*text files  ---> .txt

//Operation		Method				Package
//----------------------------------------------------------------
//To create file	createNewFile()			java.io.File
//To read file		read()				java.io.FileReader
//To write file		write()				java.io.FileWriter
//To delete file	delete()			java.io.File*/

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Folder_DirectoryOperationsDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//1. how to create a new directory 
		File dire=new File("C:\\Demofiles\\mydir");
		//to check file is created (mkdir()..create directory)
		if(dire.mkdir())
		{
			System.out.println("new directory is created..");
		}else {
			System.out.println("directory is alredy existed ..");
		}
//2.rename directory...
		File old_dire=new File("C:\\Demofiles\\mydir");
		File new_dire=new File("C:\\Demofiles\\dir123");
		if(old_dire.renameTo(new_dire)) {
			System.out.println("directory name has changed");
		}else {
			System.out.println("can't rename the directory...");
		}
	//3.delete a directory......
		File del_dir=new File("C:\\Demofiles\\dir123");
		if(del_dir.delete()) {
			System.out.println("directory is deleted");
		}else {
			System.out.println("directory cannot be deleted");
		}
	
	//4. current working directory......
		String location=System.getProperty("user.dir");
		System.out.println("current working directory: "+location);
	
	
	
	
	
	
	}

}
