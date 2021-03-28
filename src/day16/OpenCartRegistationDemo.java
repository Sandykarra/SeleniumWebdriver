package day16;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenCartRegistationDemo {

			public static void main(String[] args) throws InterruptedException {
				System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
				ChromeDriver driver= new ChromeDriver();
				driver.get("https://demo.opencart.com/");
				driver.findElement(By.name("search")).sendKeys("Cameras");//name
				driver.findElement(By.xpath("//button[@class=\"btn btn-default btn-lg\"]")).click();//x-path
				driver.findElement(By.xpath("//i[@class=\"fa fa-user\"]")).click(); //sel Myaccount
				driver.findElement(By.xpath("//a[@href=\"https://demo.opencart.com/index.php?route=account/register\"]")).click();//select registration

					//checking the Input boxes //////

				WebElement Input_box=driver.findElement(By.id("input-firstname"));
				System.out.println("Display status: "+Input_box.isDisplayed());
				System.out.println("Display Enable status: "+Input_box.isEnabled());
				System.out.println("Display selected status : "+Input_box.isSelected());
				Input_box.sendKeys("abcd");
				driver.findElement(By.name("lastname")).sendKeys("123");
				driver.findElement(By.name("email")).sendKeys("javaselenium1@gmail.com");
				driver.findElement(By.id("input-telephone")).sendKeys("098765432");
				driver.findElement(By.cssSelector("[id=input-password]")).sendKeys("Welcome");
				driver.findElement(By.id("input-confirm")).sendKeys("Welcome");
				// // // Radio buttons// // // //

				WebElement Radiobutton=driver.findElement(By.cssSelector("input[name='newsletter']"));    

				System.out.println(" The yes button is Display: "+Radiobutton.isDisplayed()); //true
				System.out.println("The yes Button is Enabled:"+Radiobutton.isEnabled()); //true
				System.out.println("The yes button is selected: "+Radiobutton.isSelected()); //false
				Radiobutton.click(); //yes 
				Thread.sleep(3000); 
				//driver.findElement(By.cssSelector("input[value=\"0\"]")).click(); //no button
				System.out.println("The yes button is selected: "+Radiobutton.isSelected());//false
				// error before and after selecting the Yes Radio button is giving same report 

				driver.findElement(By.name("agree")).click(); 
			WebElement Registation=driver.findElement(By.cssSelector("input[type=\"submit\"]"));
					
		String	expectedTitle=driver.getTitle();
		String ActualTitle=driver.getTitle();
		if(ActualTitle.equals(expectedTitle)) {
			System.out.println("Registation Succesfull");
		} else {
			System.out.println("Already Registred..");
		}
				 Thread.sleep(3000);
				 driver.close();
					
					
					
					
					}
				}


