package day13;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*Test case
---------
1) Open Web Browser(Chrome/firefox/Edge).
2) Open URL  https://opensource-demo.orangehrmlive.com/
3) Enter username  (Admin).
4) Enter password  (admin123).   
5) Click on Login.
6) Capture title of the home page.(Actual title) 
7) Verify title of the page: OrangeHRM    (Expected)
8) close browser*/
public class FirstTestCase {
	public static void main(String[] args) {
		

			
		//Firefox
		
System.setProperty("webdriver.gecko.driver","C:\\Drivers\\geckodriver-v0.29.0-win64\\geckodriver.exe");
WebDriver driver=new FirefoxDriver();
		
//2) Open URL  https://opensource-demo.orangehrmlive.com/
		driver.get("https://opensource-demo.orangehrmlive.com");
//3) Enter username  (Admin).
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
//	4) Enter password  (admin123). 
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
//	5) Click on Login.
		driver.findElement(By.name("Submit")).click();
//6 Capture title of the home page.(Actual title) 
		String act_title=driver.getTitle();
		System.out.println(act_title);
//7) Verify title of the page: OrangeHRM(Expected)
		String exp_title="OrangeHRM";
		if(act_title.equals(exp_title)) {
			System.out.println("Test Passed");
		}else {
			System.out.println("Test Failed");
		}
//8) close browser*/
		driver.close();
		
		
		
	}
	

}
