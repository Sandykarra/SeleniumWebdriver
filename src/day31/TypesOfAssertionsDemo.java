package day31;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TypesOfAssertionsDemo {
WebDriver driver;
@Test
void hard_assertion() {
	
	/*System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("https://demo.opencart.com/index.php?route=account/login");
Assert.assertEquals("Account Login123", driver.getTitle());//failed here ..it didnt go into the print statment
System.out.println("hard assertion is working.....");*/
}
@Test(priority=1)
void soft_assertion() {
	System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("https://demo.opencart.com/index.php?route=account/login");


	SoftAssert sa=new SoftAssert();
	sa.assertEquals("Account Login123","Account Login","test failed");//failed here ..it didnt go into the print statment
	System.out.println("soft assertion is working.....");
	System.out.println("The differeance bw hard and soft is hard asserion if above step fail it wont go to the next step");
System.out.println("soft assertion if fail the first step still it go to the next step");
sa.assertAll(); //required to fail soft assertion at the end
}




}
