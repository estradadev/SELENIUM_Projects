package Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FourthTutorial {

	@Parameters({"URL"})
	@Test
	public void WebLoginHome(String urlName) {
		//SELENIUM
		System.out.println("WebLoginHome");
		System.out.println(urlName);
	}
	
	@Test(groups= {"Smoke"})
	public void MobileLoginHome() {
		//APPIUM
		System.out.println("MobileLoginHome");
	}
	
	@BeforeTest
	public void LoginAPIHome() {
		//Rest API automation
		System.out.println("LoginAPIHome");
	}
	
}
