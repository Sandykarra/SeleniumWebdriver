package day22;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropAssignment {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		WebElement source=driver.findElement(By.id("draggable"));
		WebElement destination=driver.findElement(By.id("droppable"));

	Actions drag=new Actions(driver);
	//drag and drop
//	drag.dragAndDrop(source, destination).perform();
	// drag and drop images.....
	
	/*WebElement John=driver.findElement(By.xpath(" //img[@alt='the peaks of high tatras']"));
WebElement Mary=driver.findElement(By.xpath("//img[@alt='The chalet at the Green mountain lake']"));
	
WebElement trash=driver.findElement(By.id("trash"));
	drag.dragAndDrop(John, trash).perform();
	drag.dragAndDrop(Mary, trash).perform();*/
	
	//slider
	WebElement slider=driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
	drag.dragAndDropBy(slider, 300, 0).perform();
	
	//scrolling********************
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	WebElement selectmenu=driver.findElement(By.xpath("//div/h2[contains(text(),'Select menu')]"));
	js.executeScript("arguments[0].scrollIntoView();", selectmenu);
	Thread.sleep(5000);
	long Value=(long)js.executeScript("return window.pageYOffset;");
	System.out.println("Numbr of pixels moved: "+Value);
	
	driver.close();
	}

}
