package practiceAllMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsClosing {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	driver.get("http://www.qaclickacademy.com/");
	driver.manage().window().maximize();

	Thread.sleep(10000);
		driver.findElement(By.xpath("//button[contains(text(), 'NO THANKS')]")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Courses']")).click();
		
		

	}

}
