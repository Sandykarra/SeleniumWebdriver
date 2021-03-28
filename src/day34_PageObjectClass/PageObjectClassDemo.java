package day34_PageObjectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObjectClassDemo {
	WebDriver driver;
	
	 PageObjectClassDemo(WebDriver driver){
		 this.driver=driver; 
	 }
//Locators
	 By txt_username_loc=By.id("txtUsername");
	 By txt_password_loc= By.name("txtPassword");
	By btn_login_loc=By.xpath("//input[@id='btnLogin']");
	By links_loc=By.tagName("a");
	By img_logo_loc= By.xpath("//*[@id='divLogo']/img");

//Action Methods..
public void setUserName(String user) {
	driver.findElement(txt_username_loc).sendKeys(user);
}

public void setPassword(String pwd) {
	driver.findElement(txt_password_loc).sendKeys(pwd);
}

public void clickLogin() {
	driver.findElement(btn_login_loc).click();
}
public  int findNoOfLinks() {
	return driver.findElements( links_loc).size();
}
public boolean checkLogoPresence() {
	boolean st=driver.findElement(img_logo_loc).isDisplayed();
	return st;
}

}