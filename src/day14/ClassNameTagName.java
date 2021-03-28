package day14;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassNameTagName {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 
		driver.get("http://automationpractice.com/index.php");
List<WebElement> sliderImages=driver.findElements(By.className("homeslider-container"));
System.out.println("Number of image sliders: "+sliderImages.size());

// we use classname locator to use mostly find multiple methods
		
	// here findelements method return multiple values to capture those we have to create a variable and store them inside
	
	//findelement() =it's return single webelement
//findelements()= it's return multiple webelements
	//finelement(matching single webele)=it's return single webelement
//findelement(matching multiple webelements)=its retrun single first webelemnt 
//findelements(single)=return type list<multiplewebelemnets> but the varible containe single webelement 
	//findelements(locators matching multiple elements)= return tupe list<webelements>   (all matching elements will be return)
	
	//Tagname locator
//it helps to find how many links are present in my webpage.

//List<WebElement> lists=driver.findElements(By.tagName("a"));
///System.out.println("the number of links present on the homepage: "+lists.size());

// find all the images in the homepage

/*List<WebElement> lists=driver.findElements(By.tagName("img"));
System.out.println("the number of images pesent on the homepage: "+lists.size());*/
	//or
int nOfimages=driver.findElements(By.tagName("img")).size();
System.out.println("the number of images pesent on the homepage: "+nOfimages);
	//driver.close();
	
	}

	
	}


