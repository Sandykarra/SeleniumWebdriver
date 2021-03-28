package Day19;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
/*2) Switch to the form
https://testautomationpractice.blogspot.com/
	driver.switchTo().frame(0*/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SwitchToframes {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
 //swith the frame
		driver.switchTo().frame(0);
		driver.findElement(By.id("RESULT_TextField-1")).sendKeys("Hima");
		driver.findElement(By.name("RESULT_TextField-2")).sendKeys("Bindu");
		driver.findElement(By.xpath("//input[@id=\"RESULT_TextField-3\"]")).sendKeys("078356748");
		driver.findElement(By.id("RESULT_TextField-4")).sendKeys("India");
		driver.findElement(By.id("RESULT_TextField-5")).sendKeys("Hyderbad");
		driver.findElement(By.id("RESULT_TextField-6")).sendKeys("Himabindy@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"q26\"]/table/tbody/tr[1]/td/label")).click();
	WebElement femaleRd=driver.findElement(By.xpath("//*[@id=\"q26\"]/table/tbody/tr[2]/td/label"));
	System.out.println(femaleRd.isSelected());
	femaleRd.click();
	System.out.println(femaleRd.isSelected()); // isselected method is not working 
	
	//Tick the multiple checkboxes at the same time
	List<WebElement>checkboxes=driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'RESULT_CheckBox-8')]"));
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	for(WebElement ch:checkboxes) {
		//ch.click(); // click method is not working
		executor.executeScript("arguments[0].click();", ch); //selecting each check box
		
		//dropdown:
		WebElement dropdown=driver.findElement(By.xpath("//select[@id=\"RESULT_RadioButton-9\"]"));
		Select listbox =new Select(dropdown);
		List<WebElement>options=listbox.getOptions();
		System.out.println("All the options availble in the dp: "+options.size());
		
	for(WebElement opt:options) {
		System.out.println("Text of the all opt: "+opt.getText());
	}
	
	//to select individual one
	listbox.selectByVisibleText("Afternoon");
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
