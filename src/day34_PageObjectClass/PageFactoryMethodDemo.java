package day34_PageObjectClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryMethodDemo {
	WebDriver driver;
	
	PageFactoryMethodDemo(WebDriver driver){
		 this.driver=driver;
		 PageFactory.initElements(driver, this); //extra step...it initilize the webelements
	 }
	
//Elements
	@FindBy(id="txtUsername")
	WebElement txt_username;
	
	@FindBy(id="txtPassword")
	WebElement txt_password;
	
	@FindBy(xpath="//input[@id='btnLogin']")
	WebElement btn_login;
	
	@FindBy(tagName="a")
	List<WebElement> links;
	
	@FindBy(xpath="//*[@id='divLogo']/img")
	WebElement img_logo;
	//***************************************************
	@FindBy(xpath="//b[normalize-space()='Admin']")
	WebElement Admin;
	@FindBy(xpath="//a[normalize-space()='User Management']")
	WebElement user_mange;
	@FindBy(xpath="//a[normalize-space()='Users']")
	WebElement users;
	
//Action Methods
	public void setUserName(String user) {
		txt_username.sendKeys(user);
	}

	public void setPassword(String pwd) {
		txt_password.sendKeys(pwd);
	}

	public void clickLogin() {
		btn_login.click();
	}
	public  int findNoOfLinks() {
		return links.size();
	}
	public boolean checkLogoPresence() {
		boolean st=img_logo.isDisplayed();
		return st;
	}
	public void clickAdmin() {
		Admin.click();
	}
	
	public void clickUserManagment() {
	
		Actions act= new Actions(driver);
		act.moveToElement(user_mange).perform();
		
	}
	 public void SelectUser() {
		 users.click();
	 }
	 
	
	

}
