package day18;
/*works based on the condition
 * we use WebdriverWait class here*/
 

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitCommand {

	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32//chromedriver.exe");
WebDriver driver=new ChromeDriver();

WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(5));
driver.get("https://www.google.co.uk/");

driver.switchTo().frame(0);//to close the google cookie
driver.findElement(By.id("introAgreeButton")).click(); 
//driver.manage().wait(1000);
// i dont know how it work....
WebElement	kids_toys =driver.findElement(By.name("q"));
kids_toys.sendKeys("Kids toys");
kids_toys.sendKeys(Keys.RETURN);

try {
WebElement toys=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Kids Toys at Amazon.co.uk - Low Prices on Kids Toys']")));
toys.click();
System.out.println("Toys search found.....");
}catch(Exception e) {
	System.out.println("Element is not found in the page...");
}
	
	driver.close();


	
	}

}
