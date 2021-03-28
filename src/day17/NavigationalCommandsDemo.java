package day17;

import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationalCommandsDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		
		driver.navigate().to("https://www.amazon.co.uk/");
		//driver.get("https://www.amazon.co.uk/");
		System.out.println(driver.getTitle());
		driver.get("https://www.snapdeal.com/");
       System.out.println(driver.getTitle());
	
	driver.navigate().back();//amazon
	System.out.println(driver.getTitle());
	System.out.println(driver.getCurrentUrl());
	driver.navigate().forward();//snapdeals
	  System.out.println(driver.getTitle());
	driver.navigate().refresh();//reload/refresh the page
	System.out.println(driver.getCurrentUrl());
	driver.navigate().back();
	System.out.println(driver.getCurrentUrl());
	driver.navigate().forward();
	System.out.println(driver.getCurrentUrl());
	driver.close();
	
	}

}
