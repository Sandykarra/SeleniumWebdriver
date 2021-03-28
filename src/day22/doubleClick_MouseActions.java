package day22;
/* double click mouse actions
 * 1.we have to use actions class
 * 2. double click().perform
 * 3.getAttribute("value")*/
 

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class doubleClick_MouseActions {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver dr=new ChromeDriver(); 	
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
dr.get("https://testautomationpractice.blogspot.com/");//open the url
dr.manage().window().maximize();
//double click: 
WebElement Field1=dr.findElement(By.id("field1"));
Field1.clear();
Field1.sendKeys("Marlow!");
	WebElement button=dr.findElement(By.xpath("//button[contains(text(),'Copy Text')]"));
	
	Actions click=new Actions(dr);
	click.doubleClick(button).perform();
	WebElement field2=dr.findElement(By.id("field2"));
	//System.out.println("Message in the field: "+ field2.getText());
	// get text method didnt work here so we have to use
	
	System.out.println(" message in the box: "+field2.getAttribute("value"));
	// it worked
	
	
	
	
	
	}

}
