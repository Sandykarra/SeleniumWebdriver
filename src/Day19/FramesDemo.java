package Day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* 1. how to handle frames
 * 2. how to search for the elements
3. how to come out of the frame */
public class FramesDemo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver dri=new ChromeDriver();
dri.get("https://www.selenium.dev/selenium/docs/api/java/index.html?org/openqa/selenium/chromium/package-summary.html");
	dri.manage().window().maximize();
	// to switch to 1st frame***************
	dri.switchTo().frame("packageListFrame"); //we have to select from frame 
	dri.findElement(By.xpath("/html/body/main/ul/li[1]/a")).click();
	dri.switchTo().defaultContent();// then it will come out of the frame
	
	// switch to 2nd frame***************
	dri.switchTo().frame("packageFrame"); /// name used
	dri.findElement(By.xpath("//a//span[contains(text(), 'Rotatable')]")).click();
	dri.switchTo().defaultContent(); // then come out of the frame
	
	// switch to 3nd frame********************
	dri.switchTo().frame("classFrame");// name used
	dri.findElement(By.xpath("/html/body/header/nav/div[1]/div[1]/ul/li[6]/a")).click();
	
	
	
	
	}

}
