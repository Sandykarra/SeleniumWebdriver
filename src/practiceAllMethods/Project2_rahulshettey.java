package practiceAllMethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Project2_rahulshettey {

	public static void main(String[] args) throws InterruptedException {
		
			System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
		driver.get("https://www.easyjet.com/en/");
		driver.manage().window().maximize();	
//select holidays
		driver.findElement(By.id("ensCloseBanner")).click();
		//driver.findElement(By.xpath("//a[normalize-space()='Holidays']")).click();
	//selection of the flights
		
		driver.findElement(By.xpath("//a[@title='Click to choose the departure airport']//img")).click();
		Thread.sleep(5000);
		//methos:1
		//driver.findElement(By.xpath("//a[contains(text(), 'Glasgow')]")).click();
	//method:2
		List<WebElement> options=driver.findElements(By.xpath("//div[@class='route-search-drawer-content']/ul/li/a"));
	for(WebElement opt:options) {
		opt.getText();
		
		if(opt.getText().contains("Glasgow")){
			opt.click();
			break;
		}
	}
	
	
	
	}

}
