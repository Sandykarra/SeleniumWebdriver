package day29.annotations;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class MyTest2 {

	@Test(priority=1)
	void sample() {
		
		System.out.println("test2 and method1..");
	}
	
	@Test(priority=2)
	void test() {
		

System.out.println("test2 and method2");
	}
@AfterTest
	void after() {
		System.out.println("test 2 tesmethod....");
	}

}
