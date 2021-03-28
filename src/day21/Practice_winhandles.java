package day21;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* New Windows
	https://testautomationpractice.blogspot.com/
		1) search for a string then find out how many links displayed
		2) Click on each link
		3) switch to each browser window then capture titles
		4) close specific browser windows*/
public class Practice_winhandles {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver dr=new ChromeDriver(); 	
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
dr.get("https://testautomationpractice.blogspot.com/");//open the url
dr.manage().window().maximize();
dr.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("mobiles"); //search
dr.findElement(By.cssSelector("input[class=\"wikipedia-search-button\"]")).click();//click the button
Thread.sleep(3000);
List<WebElement>links=dr.findElements(By.xpath("//a[starts-with(text(),'Mobi')]")); // wrote a xpath to match all the links to click
	System.out.println("it gives number of links: "+links.size()); //size
	
	Thread.sleep(5000);
	//it didnt allow to click all the links at the same time so write a loop
	for(WebElement link:links) {
		link.click();}
	//extracting each winid and printing their title to recognize them separately 
	Set<String> all_winids=dr.getWindowHandles(); // keep this line after click all the links
for(String winid:all_winids) {
	
String titles=dr.switchTo().window(winid).getTitle();
System.out.println("All pages with their winids and titles: "+titles);

if(titles.equals("Safari (web browser) - Wikipedia") || titles.equals("Mobiles (band) - Wikipedia") || titles.equals("Mobile - Wikipedia")) {
	
dr.close();
Thread.sleep(5000);
}if(titles.equals("Mobiles for development - Wikipedia")) {
	dr.findElement(By.xpath("//a[contains(text(),'View history')]")).click();
}

dr.close();

}
	
	
	}
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


