

package day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetCommands {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://www.practiceselenium.com/practice-form.html");
driver.findElement(By.name("firstname")).sendKeys("Sandya");
driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("Reddy");

//Radiobutton selection.....
driver.findElement(By.xpath("//input[@id=\"sex-0\" or @value=\"Female\" ]")).click();
	// conditional commands usage....
WebElement rdButton=driver.findElement(By.cssSelector("input[value=\"Female\"]"));
	System.out.println("The female buton is dis: "+rdButton.isDisplayed());
	System.out.println("The Female button is enabled: "+rdButton.isEnabled());
	System.out.println("The Female button is selected: "+rdButton.isSelected());
	rdButton.click();
	System.out.println("The Female button is selected afted clicked: "+rdButton.isSelected());
	
	
	}

}
