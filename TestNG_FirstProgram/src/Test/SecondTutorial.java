package Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SecondTutorial {
	
	@Test(groups= {"Smoke"})
	public void ploan() {
		System.out.println("good");
	} 
	
	@BeforeTest
	public void prerequiste() {
		System.out.println("I will execute fisrt");
	}
	
	@Test(timeOut=4000)
	public void ThirdTutorial() {
		System.out.println("Third Part");
	} 

}
