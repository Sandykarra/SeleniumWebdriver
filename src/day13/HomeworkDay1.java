package day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*Assignment
------------
1) Open Web Browser(Chrome/firefox/IE).
2) Open URL  https://admin-demo.nopcommerce.com/login
3) Provide Email  (admin@yourstore.com).
4) Provide password  (admin).   
5) Click on Login.
		driver.findElement(By.className("button-1 login-button")).click();  //or
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/input")).click()
6) Capture title of the dashboad page.(Actual title)
7) Verify title of the page: "Dashboard / nopCommerce administration" (Expected)
8) close browser*/
public class HomeworkDay1 {
	public static void main(String[] args) {
			
/*System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
ChromeDriver dri=new ChromeDriver();*/
		
//Firefox
/*System.setProperty("webdriver.gecko.driver","C:\\Drivers\\geckodriver-v0.29.0-win64\\geckodriver.exe");
WebDriver dri=new FirefoxDriver();*/
		//edge
		System.setProperty("webdriver.edge.driver","C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
		WebDriver dri=new EdgeDriver();

//1) Open Web Browser(Chrome).	
dri.get("https://admin-demo.nopcommerce.com/login");
dri.findElement(By.id("Email")).clear();
dri.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
dri.findElement(By.name("Password")).clear();
dri.findElement(By.name("Password")).sendKeys("admin");
dri.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/input")).click();
String act_title=dri.getTitle();
System.out.println(act_title);
String exp_title="Dashboard / nopCommerce administration";
if(act_title.equals(exp_title)) {
	System.out.println("Test Passed");
}else {
	System.out.println("Test Failed");
}
//8) close browser*/
dri.close();

	}

}
