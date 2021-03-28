package day29;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTest2 {

	@Test(priority=1)
	void sample() {
		
		Assert.assertTrue(true);
	}
	
	@Test(priority=2)
	void test() {
		
		Assert.assertTrue(true);
	}


}
