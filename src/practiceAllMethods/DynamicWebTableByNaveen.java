package practiceAllMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableByNaveen {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 
		driver.get("https://freecrm.com/compare.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		//method:1
		//table[@class="table-color-header table-custom"]/tbody/tr[2]/td[4]
		////table[@class="table-color-header table-custom"]/tbody/tr[28]
		
		String before_xpath="//table[@class=\"table-color-header table-custom\"]/tbody/tr[";
		String After_xpath="]/td[4]";
		
		for(int i=2;i<28;i++) {
			
			String name=driver.findElement(By.xpath(before_xpath+ i +After_xpath)).getText();
			System.out.println(name);
			
			if(name.contains("$125")) {
				//tbody/tr[3]/td[1]
			
				WebElement sel_text=driver.findElement(By.xpath("//tbody/tr["+i+"]/td[1]"));
				System.out.println("chosen text from the table: "+sel_text.getText());
			}
			
		}
		
		
	}

}
