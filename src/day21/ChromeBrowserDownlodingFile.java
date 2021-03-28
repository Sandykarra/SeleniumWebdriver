package day21;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowserDownlodingFile {

	public static void main(String[] args) throws InterruptedException {
		//Script for downloading file in desired location
				HashMap chromPref=new HashMap();
				chromPref.put("download.default_directory", "C:\\Selenium_uploadFiles");
				ChromeOptions options=new ChromeOptions();
				options.setExperimentalOption("prefs", chromPref);
				//end of the script
	
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(options); // desired location
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://demo.automationtesting.in/FileDownload.html");
		driver.manage().window().maximize();
		
		//txt.file
		WebElement status=driver.findElement(By.id("textbox"));
		status.sendKeys("Welcome to the automation!!1!");
WebElement G_file=driver.findElement(By.id("createTxt"));
System.out.println(G_file.isEnabled()); //true
System.out.println(G_file.isDisplayed());//true
System.out.println(G_file.isSelected());//false
G_file.click();
System.out.println(G_file.isSelected()); //false
driver.findElement(By.id("link-to-download")).click();
Thread.sleep(5000); // implicit waits wont work here becz its not a web element

// to check the location file is stored
//C:\\Selenium_uploadFiles ---desired location
//C:\\Users\\User\\Downloads\\info.txt

if(isFileExist("C:\\Users\\User\\Downloads\\info.txt")) {
	System.out.println("Text file is present in the location......");
}else {
	System.out.println("Text file is not present in the location......");
}



//pdf file
WebElement search=driver.findElement(By.id("pdfbox"));
search.sendKeys("Testing");
WebElement generateFile=driver.findElement(By.id("createPdf")); 
                        System.out.println(generateFile.isDisplayed());
                        System.out.println(generateFile.isEnabled());//before false //after true
                        System.out.println(generateFile.isSelected());
                        generateFile.click();  // Generate file button
driver.findElement(By.id("pdf-link-to-download")).click(); //Download link


Thread.sleep(5000);
//to check the location file is stored
if(isFileExist("C:\\Users\\User\\Downloads\\test.pdf")) {
	System.out.println("pdf file is present in the location......");
}else {
	System.out.println("pdf file is not present in the location......");
}







	}

	
	
	
	// to check the file location we have to create a method
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
