package day32.listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners( day32.listeners.Mylisteners.class)
public class ListenersClass1 {
WebDriver driver;
@BeforeClass
void Setup() {
	
	System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
	 driver.manage().window().maximize();
	 
}
@Test(priority=1)
public void imageTest() throws InterruptedException {
	boolean image=driver.findElement(By.xpath("//div[@id='divLogo']//img")).isDisplayed();
System.out.println(image);

}
@Test(priority=2)
void title_Test() {
	String act_title=driver.getTitle();
	Assert.assertEquals(act_title, "OrangeHRM1","title is not matching");
}
@Test(priority=3)
void gettext_Test() throws InterruptedException {
	Thread.sleep(3000);
	 String text=driver.findElement(By.xpath("//a[normalize-space()='Forgot your password?']")).getText();
	System.out.println(text);
}
@AfterClass
void tearDown() {
	
	driver.close();
}





}
