package practiceAllMethods;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RahulShettyProject1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//login
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		//radiobutton 
	/*WebElement Radiobutton=driver.findElement(By.xpath("//input[@value='radio2']"));

	System.out.println("Before selectiong the button: "+Radiobutton.isSelected());
	System.out.println(Radiobutton.isEnabled());
	System.out.println(Radiobutton.isDisplayed());
	Radiobutton.click();
	System.out.println("After clicking the button: "+Radiobutton.isSelected());
	//suggestionclasss example
WebElement selection=driver.findElement(By.id("autocomplete"));
selection.sendKeys("India");
selection.click();
//dropdown example
	
	WebElement dropdown=driver.findElement(By.id("dropdown-class-example")); //dropdownbox
	Select dropselect=new Select(dropdown);
	//1. count num of options
	List<WebElement> options=dropselect.getOptions();
	System.out.println("count num of options: "+options.size());
	
	//2.capture all the options
	for(WebElement opt:options)
	{
		System.out.println("all the available options: "+opt.getText());
		
	}
	//3.select an options from the above list
	dropselect.selectByVisibleText("Option3");
	
	//4.checkbox 
	//taken the xpath to match all 3 boxes
	//here select tag is not availbele so i cant use select class
	/*List<WebElement> listbox=driver.findElements(By.xpath("//*[@id=\"checkbox-example\"]/fieldset/label//input"));//to match 3 elements
	for(WebElement box:listbox)
	{
		System.out.println("all the boxes name: "+box.getText());
		box.click(); //clicked all 3 boxes
	}*/
	//driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/fieldset/label[1]//input[1]")).click(); // it click only one box
	
	//4.switch windows examples
	driver.findElement(By.xpath("//button[@id=\"openwindow\"]")).click();
	Set<String> winhandle=driver.getWindowHandles();
	Thread.sleep(4000);
for(String handle:winhandle) {
	String titles=driver.switchTo().window(handle).getTitle();
	System.out.println(titles);
	if(titles.equals("QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy"))
	{Thread.sleep(8000);
	driver.findElement(By.xpath("//*[@id=\"homepage\"]/div[4]/div[2]/div/div/div/span/div/div[7]/div/div/div[2]")).click();
	//driver.quit();
	
	}
}
	}
	

}



