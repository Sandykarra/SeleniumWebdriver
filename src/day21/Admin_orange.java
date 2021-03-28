package day21;
//create a admin

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Admin_orange {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee");
		driver.manage().window().maximize();
		//login
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		WebElement ck=driver.findElement(By.id("btnLogin"));
		ck.click();
		driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).click();
//Add user
		/*driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).click();
		driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
		//Add User**************************************
		//user role dropdown.
		Select u_role=new Select(driver.findElement(By.id("systemUser_userType")));
List<WebElement> roleOpt=u_role.getOptions();
System.out.println("All the options: "+roleOpt.size()); //2
	for(WebElement r:roleOpt) {
		System.out.println(r.getText());}
		u_role.selectByIndex(1);//Ess
	//Employ name...................
	driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("sandya karra");
driver.findElement(By.id("systemUser_userName")).sendKeys("Hasini12");
//Employ stauts****************
	Select status =new Select(driver.findElement(By.id("systemUser_status")));
	List<WebElement> St=status.getOptions();
	System.out.println(St.size());
	for(WebElement empsta:St) {
		System.out.println("status of the employ: "+empsta.getText());
	}
	status.selectByIndex(1);
	//password
	driver.findElement(By.id("systemUser_password")).sendKeys("Selenium@12");
driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("Selenium@12");
Thread.sleep(3000);
	// save button
driver.findElement(By.xpath("//input[@name='btnSave']")).click();
	//to check user is exist from the list.....*/
		
////1) How many rows in  table

int rows=driver.findElements(By.xpath("//tbody/tr")).size();
System.out.println("the num of rows in the table: "+rows);
	//colums
int col=driver.findElements(By.xpath("//*[@id=\"resultTable\"]/thead/tr/th")).size();
System.out.println("the num of colums in the table: "+col);
	//3) Retrieve the username Sandya123 and find the status of the employment data from the table
for(int r=2;r<rows;r++) {
	String name=driver.findElement(By.xpath("//tbody//tr["+r+"]/td[2]")).getText();
System.out.println("all the names in the rows: "+name);
Thread.sleep(5000);
if(name.equals("Joe.Root")) {
	 String status=driver.findElement(By.xpath("//tbody//tr[\"+r+\"]/td[5]")).getText();
	 System.out.println("Nina user name employ status: "+status);

//driver.close();
}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
