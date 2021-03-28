package day13;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Practice2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver","C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
		WebDriver dri=new EdgeDriver();
		
		/*System.setProperty("webdriver.gecko.driver","C:\\Drivers\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		WebDriver dri=new FirefoxDriver();*/
dri.get("https://www.google.com");
	}

}
