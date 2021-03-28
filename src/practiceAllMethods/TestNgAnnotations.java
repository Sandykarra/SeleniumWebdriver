package practiceAllMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgAnnotations {
WebDriver driver;
@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("https://www.youtube.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	System.out.println("open the browser...");
	}
@Test(priority=1)
void LogoTest() {
	
	boolean l=driver.findElement(By.xpath("//ytd-topbar-logo-renderer[@id='logo']//a[@id='logo']")).isDisplayed();
System.out.println("Logo present:  "+l);
}
@Test(priority=2)
void titleTest() {
	String act_title=driver.getTitle();
	System.out.println(act_title);
}
	@AfterMethod
public void tearDown() {
	driver.close();
	System.out.println("close the browser");
	
}
	



}
