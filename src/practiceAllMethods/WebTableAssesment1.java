package practiceAllMethods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class WebTableAssesment1 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/leave/viewLeaveList");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//login 
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		//to select the leave
		driver.findElement(By.id("menu_leave_viewLeaveModule")).click();
		WebElement ent=driver.findElement(By.id("menu_leave_Entitlements"));
		WebElement report=driver.findElement(By.id("menu_leave_Reports"));
		WebElement conf=driver.findElement(By.id("menu_leave_Configure"));
		WebElement leavelist=driver.findElement(By.id("menu_leave_viewLeaveList"));
		Actions act=new Actions(driver);
		act.moveToElement(ent).moveToElement(report).moveToElement(conf).moveToElement(leavelist).click().perform();
		
		//1) How many rows in  table
		List<WebElement> rows=driver.findElements(By.xpath("//table[@class=\"table hover\"]/tbody/tr"));
System.out.println("total num of rows in the table: "+rows.size());
	
	
	
	
	}

}
