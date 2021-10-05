package Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ThirdTutorial {

	@BeforeClass
	public void beforeClass() {
		System.out.println("Befor Class");
	}
	
	//@Test(enabled=false)
	@Test(enabled=true)
	public void WebLoginCarLoan() {
		//SELENIUM
		System.out.println("WebLoginCarLoan");
	}
	
	@Parameters({"URL","APIKey/username"})
	@Test
	public void WebLoginCarLoanParameter(String urlName, String key) {
		//SELENIUM
		System.out.println("WebLoginCarLoan");
		System.out.println(urlName);
		System.out.println(key);
	}
	
	@BeforeMethod
	public void BfMethod() {
		//SELENIUM
		System.out.println("Before Every");
	}
	
	@Test(groups= {"Smoke"})
	public void MobileLoginCarLoan() {
		//APPIUM
		System.out.println("MobileLoginCarLoan");
	}
	
	@BeforeSuite
	public void BSuite() {
		System.out.println("I´am number 1");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After class");
	}
	
	//(dependsOnMethods={"WebLoginCarLoan"}) //selenium execute this first then WebLogin...
	@Test(dependsOnMethods={"WebLoginCarLoan"})
	public void LoginAPICarLoan() {
		//Rest API automation
		System.out.println("LoginAPICarLoan");
	}
	
	@Test(dataProvider="getData")
	public void getDataFromMethod(String username, String password) {
		System.out.println("Test executed 3 times");
		System.out.println(username);
		System.out.println(password);
	}
	
	@DataProvider
	public Object[][] getData() {
		
		//1st - combination: username password - good credit history = row
		//2nd - username password  - no credit history 
		//3rd - fraudelent credit history
		
		Object[][] data = new Object[3][2]; 
		
		//1st set
		data[0][0] = "firstusername";
		data[0][1] = "firstpassword";
		
		//2nd set
		data[1][0] = "secondusername";
		data[1][1] = "secondpassword";
		
		//3rd set
		data[2][0] = "thirdusername";
		data[2][1] = "thirdpassword";
		
		return data;
	}	
	
}
