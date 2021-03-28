package Day19;
/*1) Capture the msg from alert then close Alert
 * 2.Alerts/popups
--------------
driver.switchTo().alert().accept()
driver.switchTo().alert().dismiss()
driver.switchTo().alert().getText()*/

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureAlert_PopUp {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	driver.manage().window().maximize();

	
driver.findElement(By.xpath("//input[@name=\"proceed\"]")).click();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//To click the PopUp
Alert Message= driver.switchTo().alert();
System.out.println("The message on the PopUp: "+ Message.getText());
Message.accept();
driver.close();
		


		
		
		
		
	}

}
