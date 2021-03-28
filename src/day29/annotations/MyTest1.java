package day29.annotations;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTest1 {
	@Test(priority=1)
	void login() {
		System.out.println("this is test1 from my test1");
		Assert.assertTrue(true);
	}
	
	
	@Test(priority=2)
	void search() {
		System.out.println("this is test1 test 2");
	}
	
	@Test(priority=3)
	void logout() {
		

System.out.println("this is test1 and method 3");
	}
	@BeforeTest
	void before() {
		
		System.out.println(" before test cond....");
	}

}
