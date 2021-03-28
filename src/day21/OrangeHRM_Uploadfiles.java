package day21;
/* we have to login to the site
 * upload the file
 * create the account*/
 
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM_Uploadfiles {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee");
		driver.manage().window().maximize();
		//login
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		WebElement forgot=driver.findElement(By.tagName("a"));
		//System.out.println("the message appeared: "+forgot.getText());
		WebElement ck=driver.findElement(By.id("btnLogin"));
		ck.click();

		
		
		driver.findElement(By.id("firstName")).sendKeys("Geeta");
		driver.findElement(By.id("lastName")).sendKeys("Rose");
driver.findElement(By.cssSelector("input[name=\"employeeId\"]")).sendKeys("1230");
driver.findElement(By.cssSelector("input[id=\"photofile\"]")).sendKeys("C:\\Softwares\\saibaba\\saibaba.jpg");
Thread.sleep(5000);
WebElement ck1=driver.findElement(By.xpath("//input[ @type=\"button\" and @id=\"btnSave\"]"));
	ck1.click();
	
	Set<String> t_titles=driver.getWindowHandles();
	System.out.println(t_titles);
	// to check the Tc is passed
	for(String winid:t_titles) {
		//if i print i dont know which id is which
		 String id=driver.switchTo().window(winid).getTitle();
		 System.out.println(id);
	}
	

	
	
	}
	

}
