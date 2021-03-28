package day23;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithTabsAndWindows {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//if i want to open 2 tabs in the same window
		driver.get("https://demo.nopcommerce.com/");
		//driver.switchTo().newWindow(WindowType.TAB);// same window open 2 tabs
		driver.switchTo().newWindow(WindowType.WINDOW); //open in 2 different windows(new feature)
		driver.get("https://jqueryui.com/tooltip/");
	
	
	
	}

}
