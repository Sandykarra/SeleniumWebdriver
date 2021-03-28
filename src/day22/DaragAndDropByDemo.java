package day22;
/* mouse action for sliders
 * 1.use drop and dropBy method*/
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DaragAndDropByDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/slider/");
		driver.manage().window().maximize();
driver.switchTo().frame(0);
 WebElement slid=driver.findElement(By.xpath("//*[@id='slider']/span"));
Actions slider= new Actions(driver);
Thread.sleep(3000);
slider.dragAndDropBy(slid, 300, 0).perform(); // slider moved 
slider.dragAndDropBy(slid, -200, 0).perform(); // to go back the slider 



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
