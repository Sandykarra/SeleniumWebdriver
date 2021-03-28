package day23;
/* to find element location and size
 * 1.x,y axis size and height have to find out
 * 2.getReact(),getDimension(),getHeight(),width()
 * 3.getx(),gety();*/
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementSizeAndLocations {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
// finding element size and locations
	WebElement Logo=driver.findElement(By.xpath("//div[@id=\"divLogo\"]//img"));
	//Height & width  - Size
	System.out.println("Height of the Logo: "+Logo.getRect().getDimension().getHeight());
	System.out.println("width of th eLogo: "+Logo.getRect().getDimension().getWidth());
	
	//x , y coordinates  - Location
	System.out.println("x-axis: "+ Logo.getRect().getX());
	System.out.println("y-axis: "+Logo.getRect().getY());
	
	
	
	
	
	
	
	
	
	}

}
