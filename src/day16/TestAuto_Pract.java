package day16;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*Dropdown/List box(combo box)
-----------------------
1) Count number of options  
2) Capture all the options
3) Select an option*/

public class TestAuto_Pract {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver dr=new ChromeDriver(); 
		dr.get("https://testautomationpractice.blogspot.com/");
		WebElement dropdown=dr.findElement(By.id("speed"));
		Select dropse=new Select(dropdown);
		
		//i selecting speed from 'drop down' list
		//1. count number of options
	/*List<WebElement> options=dropse.getOptions();
	System.out.println("Number of options: "+options.size());
	
	//2. capture all the options****************************
	for(WebElement e:options) {
		System.out.println(e.getText());}
	
	//3. selct the option from the text***************
	dropse.selectByIndex(2);*/

	//selecting a file from the drop down
	Select file= new Select(dr.findElement(By.name("files")));
List<WebElement>Sel_file=file.getOptions();
System.out.println("The number of options  in the file drop down are: "+Sel_file.size());
	for(WebElement chosen_file:Sel_file) {
		System.out.println("It show all the files in the dropdown: "+chosen_file.getText());
	}
	file.selectByValue("2");
	
	
	
	
	
	}

}
