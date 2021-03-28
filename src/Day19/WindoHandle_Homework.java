package Day19;

	/*https://testautomationpractice.blogspot.com/
		1) search for a string then find out how many links displayed
		2) Click on each link
		3) switch to each browser window then capture titles
		4) close specific browser windows*/

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindoHandle_Homework {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //wait
driver.get("https://testautomationpractice.blogspot.com/"); // open the url
driver.manage().window().maximize();
//enter the text into the searchbox
driver.findElement(By.xpath("//*[@id=\"Wikipedia1_wikipedia-search-input\"]")).sendKeys("book"); //search
driver.findElement(By.xpath("//*[@id=\"Wikipedia1_wikipedia-search-form\"]/div/span[2]/span[2]/input")).click();
//we have to write xpath to match all the elements to capture all the links
List<WebElement> selection=driver.findElements(By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']//div/a")); 
//1) search for a string then find out how many links displayed			 
System.out.println(selection.size());//5links 
//2) Click on each link

	for(WebElement click_eachlist:selection) {
		click_eachlist.click();
		Thread.sleep(3000);}
	//3) switch to each browser window then capture titles
	Set<String>	All_winhandles=driver.getWindowHandles();
	for(String winid:All_winhandles) {
	String	titles=driver.switchTo().window(winid).getTitle();
		System.out.println(titles);
		//4) close specific browser windows*/
		if(titles.equals("Book of Revelation - Wikipedia")|| titles.equals("Book of Enoch - Wikipedia") || titles.equals("Book - Wikipedia")){
		driver.close();	
		}
	driver.quit();	
	}
	
	}

}
