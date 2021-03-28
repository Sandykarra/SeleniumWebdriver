package day21;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FirefoxBrowserdemo {

	public static void main(String[] args) {
		
		//Browser profile - browser settings
		FirefoxProfile profile=new FirefoxProfile();
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/plain,application/pdf");    // Mime type
		profile.setPreference("pdfjs.disabled", true);//only for pdf's
		//end of the script
		profile.setPreference("pdfjs.disabled", true);//only for pdf's
		//end of
		//Script for downloading files in desired location
		profile.setPreference("browser.download.folderList", 1); //0-desktop 1-downloads 2- desired loc
		profile.setPreference("browser.download.dir", "C:\\Downloads");// required if the above option is 2
		
		FirefoxOptions options=new FirefoxOptions();
		options.setProfile(profile);
		
	
	
	
	
	
	
	
	}

}
