package day30;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDemo1 {

	@Test
	void test()
	{
		int a=10;
		int b=20;
		
		String s1="abc";
		String s2="xyz";
		
		//Assert.assertTrue(a==b);
		//Assert.assertFalse(a==b);
		
		//Assert.fail();
		
		Assert.assertEquals(a, b,"Values are not equal...");
		//Assert.assertNotEquals(a, b,"Values are not equal...");
		
	}





}
