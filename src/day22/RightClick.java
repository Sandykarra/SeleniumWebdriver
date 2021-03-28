package day22;
/* mouse actions
 * 1.actons class we use to operate the right click
 * 2. alert method we use to close the pop up*/
 

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClick {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		//right click............................
WebElement right=driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));	
Actions click=new Actions(driver); //mouse over actions we have to use
	click.contextClick(right).perform();
driver.findElement(By.xpath("/html/body/ul/li[5]")).click(); //selct delete button
Alert delete=driver.switchTo().alert(); // alert method we use to close the popup
	System.out.println("The message on the alert: "+delete.getText()); //popup message 
	delete.accept(); //close the alert 
	
	
	
	
	
	
	
	
	
	
	
	}

}
