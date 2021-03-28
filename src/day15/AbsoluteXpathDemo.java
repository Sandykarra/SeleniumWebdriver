package day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AbsoluteXpathDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
	
   driver.get("https://www.amazon.co.uk/");
   driver.manage().window().maximize();
   driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input")).sendKeys("Books for Testing");
  driver.findElement(By.xpath("//input[@name=\"accept\"]")).click();
  driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
  int slider=driver.findElements(By.xpath("//i[@class='a-icon a-icon-next-rounded']")).size();
  System.out.println(slider);
  driver.findElement(By.xpath("//a[@data-csa-c-content-id=\'nav_cs_gb_b68407273ab549c5a4903f6d04d960cc\']")).click();
	
	
	
	
	
	}

}
