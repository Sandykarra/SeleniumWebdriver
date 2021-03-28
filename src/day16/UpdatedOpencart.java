package day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedOpencart {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
				driver.get("https://demo.opencart.com/");
				driver.findElement(By.name("search")).sendKeys("Cameras");// name
				driver.findElement(By.xpath("//button[@class=\"btn btn-default btn-lg\"]")).click();// x-path
				driver.findElement(By.xpath("//i[@class=\"fa fa-user\"]")).click(); // sel Myaccount
				driver.findElement(By.xpath("//a[@href=\"https://demo.opencart.com/index.php?route=account/register\"]"))
						.click();// select registration option

				// Radio buttons//

				WebElement Radiobutton = driver.findElement(By.cssSelector("input[name='newsletter']"));
				System.out.println(" The yes button is Display: " + Radiobutton.isDisplayed()); // true
				System.out.println("The yes Button is Enabled:" + Radiobutton.isEnabled()); // true
				System.out.println("The yes button is before selected: " + Radiobutton.isSelected()); // false
				
				Radiobutton.click(); // clicking on YES radio button
				
				System.out.println("The yes button is after selected: " + Radiobutton.isSelected());
				
	}
}