package Day19;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WondowHandlesDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("http://demo.automationtesting.in/Windows.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id='Tabbed']/a/button")).click(); //click button
		
		Set <String> windowids=driver.getWindowHandles();

		for(String winid:windowids)
		{
			//System.out.println(winid);
			String title=driver.switchTo().window(winid).getTitle();
			//System.out.println(title);
			
			/*if(title.equals("SeleniumHQ Browser Automation"))
			{
				driver.findElement(By.xpath("//*[@id=\"navbar\"]/a[3]")).click();
			}*/
			if(title.equals("Frames & windows")|| title.equals("xyx") || title.equals("abc"))
			{
				driver.close();
			}
			
		}
	
	
	
	
	
	}

}
