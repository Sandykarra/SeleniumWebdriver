package day30;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class OpenCartProductSelection {
	
WebDriver driver;
@Test(priority=3,alwaysRun=true)
void getUrl() {
	System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
	 driver=new ChromeDriver();
	driver.get("https://demo.opencart.com/index.php?route=product/category&path=33");
	driver.manage().window().maximize();
}
@Test(priority=4)
	void productSelection() {
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[2]/div[2]/button[1]")).click();//Nokon camera selected
	}

@Test(priority=5, dependsOnMethods={"productSelection"})
void selected_productname() throws InterruptedException {
	Thread.sleep(3000);
	String selected_productname=driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[2]/div[1]/h4/a")).getText();
	System.out.println("selected product name: "+selected_productname);
}

@Test(priority=6,dependsOnMethods={"productSelection"})
void cart() throws InterruptedException {
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[normalize-space()='Checkout']")).click();
	
}

@Test(priority=7,dependsOnMethods={"productSelection","cart"})
void validation() {
	String cart_chosenProduct=driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[2]/a")).getText();
System.out.println("The Product in the cart: "+cart_chosenProduct);
//Assert.assertEquals(selected_productname, cart_chosenProduct,);
}
@AfterClass
void lagout() {
	driver.findElement(By.xpath("//span[contains(text(), 'My Account')]")).click();
	driver.findElement(By.xpath("//a[contains(text(), 'Logout')]")).click();
}


}
