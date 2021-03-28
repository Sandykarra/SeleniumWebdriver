package day22;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scrolling {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/slider/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		//1. Scroll down page by pixel
		js.executeScript("window.scrollBy(0,1000)", "");
		long Value=(Long)js.executeScript("return window.pageYOffset;");
		System.out.println("Numbr of pixels moved: "+Value);
		
		//2.end of the page 
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		long value=(Long)js.executeScript("return window.pageYOffset;");
		System.out.println("Number of pixels moved:"+value);
		
				
		

	}

}
