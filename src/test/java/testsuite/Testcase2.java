package testsuite;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testcase2 {
	
	
	@BeforeTest
	public void beforetest() {
		
		System.out.println("Before Test");
	}
	
	@BeforeMethod
	public void beforemethod() {
		
		System.out.println("Inside before Method");
	}
	
	@Test(groups= {"sanity"})
	public void test3() {
		
		System.out.println("Inside Test3");
	}
	
	@Test
	public void test4() {
		
		System.out.println("Inside Test4");
	}
	
	@AfterMethod
	public void aftermethod() {
		
		System.out.println("Inside after Method");
	}
	
	@AfterTest
	public void aftertest() {
		
		System.out.println("After Test");
	}

}
