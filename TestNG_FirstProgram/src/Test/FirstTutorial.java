package Test;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class FirstTutorial {

	@AfterTest
	public void LastExecution() {
		
		System.out.println("Will execute last");
		
	}
	
	@Test
	public void Demo() {
		
		System.out.println("hello world");
		Assert.assertTrue(false);
		
	}
	
	@AfterSuite
	public void AfSuit() {
		System.out.println("I'am the numbres 1 to last");
	}
	
	@Test(groups= {"Smoke"})
	public void SecondTest() {
		
		System.out.println("bye");
		
	}

}
