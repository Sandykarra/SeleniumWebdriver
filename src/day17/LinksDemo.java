package day17;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksDemo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.co.uk/"); //open the URL
		driver.manage().window().maximize();
		
		//1.Find number of links************
		
	List<WebElement> links=driver.findElements(By.tagName("a")); //355
	System.out.println("The total number of links present: "+links.size());
	
//2. capture all the links************** we have to use loop statement
	
	// enhance for loop
	/*for(WebElement l:links) {
		//System.out.println(l.getText()+">>>>>>  "+l.getAttribute("href"));}*/

	//classic loop*******************
	
	/*for(int i=0;i<=links.size();i++) {
		// if we want only first 5 values we have to write as a i<=5 or use if condition followed with break
		WebElement line=links.get(i);
		System.out.println(line.getText()+"-------"+line.getAttribute("href"));
	}*/
	
	
	//2.. toal images on the webpage***************
	
 /*List<WebElement> images=driver.findElements(By.tagName("img"));
 System.out.println(images.size());*/
	
	
	// click on the link click////////\
	
	System.out.println("Title of the webpage before clicking Today's deals link: "+driver.getTitle());
	driver.findElement(By.linkText("Best Sellers")).click();
	System.out.println("Title of the webpage after clicking: "+driver.getTitle());
	
	
	
	
	
	}

}
