package testsuite;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class Testcase1 {
	
	
	@Test
	public void test1() {
		
		System.out.println("Inside Test1");
	}
	
	@Test(description="This is test2")
	public void test2() {
		
		System.out.println("Inside Test2");
	}
	
	@Test(dependsOnMethods="test2")
	public void othertest() {
		
		System.out.println("Inside othertest");
	}

}
