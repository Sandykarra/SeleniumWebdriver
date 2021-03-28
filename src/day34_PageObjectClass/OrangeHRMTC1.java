package day34_PageObjectClass;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrangeHRMTC1 {
	WebDriver driver;
	Logger logger;
	//PageObjectClassDemo util; 1st approach
	PageFactoryMethodDemo util; //2nd approach
	@BeforeClass
	void setup() {
		logger=LogManager.getLogger("OrangeHRMTC1"); //just used logger method here
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	logger.info("setup method is working fine");
	}
	
	
	
	@Test(priority=1)
	void test_LogoPres() throws InterruptedException {
			util=new PageFactoryMethodDemo(driver);
		Thread.sleep(2000);
		boolean status=util.checkLogoPresence();
		Assert.assertEquals(status, true);
		logger.info("Logo presnt in this page");
	}
	
	@Test(priority=2)
	void test_Holepagelinks() {  
		int no_oflinks=util.findNoOfLinks();
		Assert.assertEquals(no_oflinks, 6,"Number is not matching");
	}
	@Test(priority=3)
		void testLogin() throws InterruptedException {
			Thread.sleep(1000);//to invoke utili file
		util.setUserName("Admin");
		util.setPassword("admin123");
		util.clickLogin();
	}
	@Test(priority=4)
	void testAdmin() {
		util.clickAdmin();
	}
	@Test(priority=5)
	void testU_mangement() {
		util.clickUserManagment();
	}
	@Test(priority=6)
	void test_User() {
	util.SelectUser();	
	}
	@AfterClass
	void tearDown() {
		driver.close();
	}
}
