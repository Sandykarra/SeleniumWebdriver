package day22;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingMouseActions {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		driver.manage().window().maximize();
		
		// we have to type cast into the javascript executor
		//driver.switchTo().frame("google_esf");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		/*js.executeScript("window.scrollBy(0,2000)", "");
		long Value=(Long)js.executeScript("return window.pageYOffset;");
		System.out.println("Numbr of pixels moved: "+Value);*/
		
	//2.scrolldown the page till the element visible
		//WebElement cyprus=driver.findElement(By.xpath("//img[@alt='Flag of Cyprus']"));
	//js.executeScript("arguments[0].scrollIntoView();", cyprus);
		/*js.executeScript("arguments[0].scrollIntoView();", cyprus);
		Thread.sleep(5000);
		double Value=(Double)js.executeScript("return window.pageYOffset;");
		System.out.println("Numbr of pixels moved: "+Value);*/
		
		//flag of libia..............................
		WebElement flagofLibia=driver.findElement(By.xpath("//img[@alt='Flag of Libya']"));
	
	/*js.executeScript("arguments[0].scrollIntoView();",flagofLibia);
	long Value=(long)js.executeScript("return window.pageYOffset;");
	System.out.println("Numbr of pixels moved: "+Value);*/
	
	//3.End of the page
	js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	long value=(Long)js.executeScript("return window.pageYOffset;");
	System.out.println("Number of pixels moved:"+value);
	
	}

}
