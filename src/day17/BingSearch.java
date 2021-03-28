package day17;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class BingSearch {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver","C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.bing.com/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id=\"bnp_btn_accept\"]")).click(); // to remove cookie
		driver.findElement(By.name("q")).sendKeys("Selenium Training");
		Thread.sleep(3000); // to capture dynamic values come from server
List<WebElement> searchitems=driver.findElements(By.xpath("//ul[@class=\"sa_drw\"]/li"));
//System.out.println("size of suggested items: "+searchitems.size());
for(WebElement selword:searchitems) {
	if (selword.getText().contains("Selenium Taining")) {
		selword.click();
		break;
	}
//finding number of links
List<WebElement> Links=driver.findElements(By.tagName("a"));
System.out.println("The numbe of links present in this link: "+Links.size());
// to print name of all the links
for(WebElement name_link:Links) {
	System.out.println(name_link.getText()+"........  "+name_link.getAttribute("href"));

Thread.sleep(3000);
 int images=driver.findElements(By.tagName("img")).size();
System.out.println(images);

Thread.sleep(3000);
driver.close();
}

}



	}

}
