package day22;
/*Mouse Actions
 * 1.mouse over--moveToElement method()
 * 2.action class to operate mouse operations*/

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOverActionsDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	
		//login
				driver.findElement(By.id("txtUsername")).sendKeys("Admin");
				driver.findElement(By.id("txtPassword")).sendKeys("admin123");
				driver.findElement(By.id("btnLogin")).click();
				
	//mouse over
			WebElement admin=driver.findElement(By.id("menu_admin_viewAdminModule"));
	        WebElement usermg=driver.findElement(By.id("menu_admin_UserManagement"));
	          WebElement users=driver.findElement(By.id("menu_admin_viewSystemUsers"));
	
	Actions act= new Actions(driver);
	Thread.sleep(3000);
	act.moveToElement(admin).moveToElement(usermg).moveToElement(users).click().perform();
	
	
	
	
	
	
	
	
	
	}

}
