package day21;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FireFoxBrowserFileDownloading {

	public static void main(String[] args) throws InterruptedException {
		//Browser profile - browser settings
				FirefoxProfile profile=new FirefoxProfile();
				profile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/plain,application/pdf");    // Mime type
				profile.setPreference("pdfjs.disabled", true);//only for pdf's
				//end of the script
				profile.setPreference("pdfjs.disabled", true);//only for pdf's
				//end of the script


				//Script for downloading files in desired location
				profile.setPreference("browser.download.folderList", 1); //0-desktop 1-downloads 2- desired loc
				profile.setPreference("browser.download.dir", "C:\\Downloads");// required if the above option is 2
				
				FirefoxOptions options=new FirefoxOptions();
				options.setProfile(profile);
				
				
		System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		FirefoxDriver driver=new FirefoxDriver(options);
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
//"C:\\Selenium_uploadFiles
if(isFileExist("C:\\Users\\User\\Downloads\\info.txt")) {
	System.out.println("pdf file is present in the location......");
}else {
	System.out.println("pdf file is not present in the location......");
}
	}

	//**********************************************
	
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
