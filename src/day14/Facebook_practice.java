package day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Facebook_practice {

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver","C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
		WebDriver dri=new EdgeDriver();
		dri.get("https://www.facebook.com/");
		dri.findElement(By.cssSelector("button[data-cookiebanner='accept_button']")).click();
		dri.findElement(By.id("email")).sendKeys("javaselenium523@gmail.com");
		dri.findElement(By.name("pass")).sendKeys("Selenium@34");
		dri.findElement(By.cssSelector("button[data-testid='royal_login_button']")).click();

	}

}
