package day21;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeBrowserDownloadFiles {

	public static void main(String[] args) throws InterruptedException {
		//Script for downloading file in desired location
		HashMap edgepref=new HashMap();
		edgepref.put("download.default_directory", "C:\\Selenium_uploadFiles");
		
		EdgeOptions options=new EdgeOptions();
		options.setExperimentalOption("prefs", edgepref);
		//end of the script

		System.setProperty("webdriver.edge.driver","C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver(options);
driver.get("http://demo.automationtesting.in/FileDownload.html");
driver.manage().window().maximize();
//txt.file
WebElement text=driver.findElement(By.id("textbox"));
text.sendKeys("Welcome to the automation!!1!");
WebElement tbox=driver.findElement(By.id("createTxt"));
//System.out.println("before enter the text: "+tbox.isEnabled());
System.out.println("after enter the text: "+tbox.isEnabled()); //true
tbox.click();
driver.findElement(By.id("link-to-download")).click();
Thread.sleep(5000); // implicit waits wont work here becz its not a web element

//to check the location file is stored
//C:\\Users\\User\\Downloads\\info.txt
if(isFileExist("C:\\Selenium_uploadFiles\\info.txt")) {
System.out.println("Text file is present in the location......");
}else {
System.out.println("Text file is not present in the location......");
}

//pdf file
driver.findElement(By.id("pdfbox")).sendKeys("Testing");
driver.findElement(By.id("createPdf")).click();   // Generate file button
driver.findElement(By.id("pdf-link-to-download")).click(); //Download link
//id name is not matching**********************

Thread.sleep(5000);
//to check the location file is stored
if(isFileExist("C:\\Selenium_uploadFiles\\info.pdf")) {
System.out.println("pdf file is present in the location......");
}else {
System.out.println("pdf file is not present in the location......");}
	}



//to check the file location we have to create a method
	//filelocation....is file exist()......true/false
	public static boolean isFileExist(String location) {
		File f=new File(location);// defined by java class
		if(f.exists()) {
			return true;
		}else {
			return false;		
		}

	}

}
