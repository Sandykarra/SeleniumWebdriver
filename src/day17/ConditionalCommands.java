package day17;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ConditionalCommands {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://www.practiceselenium.com/practice-form.html");
// checkboxes how to select // //
	/*WebElement	Checkbox=driver.findElement(By.id("tea1"));
	
		System.out.println("The checkbox buton is dis: "+Checkbox.isDisplayed());
		System.out.println("The cbox button is enabled: "+Checkbox.isEnabled());
		System.out.println("The cbox button is selected before : "+Checkbox.isSelected());
		//Checkbox.click(); // it will select only one checkbox
		System.out.println("The checkbox button is selected after: "+Checkbox.isSelected());
	
	// tick the multiple checkboxes  at a time...
		// we have to take xpath it has to match multiple elements
	List<WebElement> checkboxes	=driver.findElements(By.xpath("//input[@type='checkbox'  and contains(@id ,'tea')]"));
	for(WebElement chbox:checkboxes) {
	chbox.click();	
	// it checked all the checkboxes*/
	
	//************dropdowns**************************
/*WebElement dropdown=driver.findElement(By.xpath("//select[@id=\"continents\"]"));
Select dpdowns= new  Select(dropdown); // we have to use select class to handle drop downs
	//1. count number of options
List<WebElement>options=dpdowns.getOptions();
System.out.println(options.size());
	
//2 captture all the options
// to capture all the options we have to use loop
 for(WebElement opt:options) {
	System.out.println(opt.getText());	
}
 //3 select an option
 // we have select a method from select class
 dpdowns.selectByIndex(2);
// dpdowns.selectByVisibleText("North America");
 //dpdowns.selectByValue(value);// we dont have option for this*/
 
// ListBoxes***************************
		
WebElement Listbx=driver.findElement(By.id("selenium_commands"));
	Select Listbox=new Select(Listbx); // select class
List<WebElement> ListOptions=Listbox.getOptions(); 
System.out.println(ListOptions.size());
// we can write like this error came like below 
	//System.out.println(Listbox.getOptions().size());
	
	//2.capture all the option
	for(WebElement L:ListOptions) {
		
	System.out.println("print all the names of list boxes: "+ L.getText());
	}
	//3.click one option
	// we can use other optins as well
	Listbox.selectByIndex(1);
	Listbox.selectByIndex(2);
	Listbox.selectByIndex(0);
	
	}

}
