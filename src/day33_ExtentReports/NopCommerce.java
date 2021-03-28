package day33_ExtentReports;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NopCommerce {

	WebDriver driver;
	@BeforeClass
 public void setup() {

	System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
	 driver.manage().window().maximize();
	 
}
@Test(priority=1)
 void test_title() {
	 try {
	String act_title=driver.getTitle();
	Assert.assertEquals(act_title, "Your store. Login","titles are not matching");
	 }catch(NoSuchElementException e)
	 {
		 Assert.assertTrue(false); 
	 }
	 
 }
@Test(priority=2)
 void logintest() {
	try {
	 WebElement email=driver.findElement(By.id("Email"));
	 email.clear();
	 email.sendKeys("admin@yourstore.com");
	WebElement pwd=driver.findElement(By.id("Password"));
	pwd.clear();
	pwd.sendKeys("admin");
	driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
	boolean logo=driver.findElement(By.xpath("//img[@class='brand-image-xl logo-xl']")).isDisplayed();
	Assert.assertEquals(logo, true,"logo invisible");
	 
 }catch(Exception f) {
	Assert.assertTrue(false); 
 }
}
 @Test(priority=3)
 void logouttest() {
	 try {
	 driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
boolean admin_text=driver.findElement(By.xpath("//h1[normalize-space()='Admin area demo']")).isDisplayed();
	 Assert.assertEquals(admin_text, true,"text invisible");
 }catch(Exception f) {
	 
	 Assert.fail(); //Assert.assertTrue(false); both are same
 }
 }
 
 @AfterClass
 void tearDown() {
	 driver.close();
	 
 }

}
