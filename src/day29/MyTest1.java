package day29;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTest1 {
	@Test(priority=1)
	void login() {
		
		Assert.assertTrue(true);
	}
	
	
	@Test(priority=2)
	void search() {
		
		Assert.assertTrue(false);
	}
	
	@Test(priority=3)
	void logout() {
		
		Assert.assertTrue(true);
	}
	
	

}
