package day29.annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeClassAnotation {
	
	
	
	
	
	
	@BeforeClass
	void login() {
		System.out.println("login..");
	}
	@AfterClass
	void logout() {
		System.out.println("logout..");
	}
	@Test(priority=1)
	void search() {
		System.out.println("search..");
	}@Test(priority=2)
	//i didnt give annotation its didn't excute
	void advancedsearch() {
		System.out.println("advanced search..");
	}

	void Selected() {
		System.out.println("Selected item..");
	}

	
	
	
	
	
	
	
	
	
	

}
