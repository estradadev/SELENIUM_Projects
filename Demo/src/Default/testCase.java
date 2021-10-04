package Default;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testCase {
		
	public static void main(String[] args) {
			
		//geko driver
		System.setProperty("webdriver.gecko.driver", 
				"C:\\Users\\eduardo.estrada\\Documents\\Academy\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		
		//Using the Class FirefoxDriver
		WebDriver driver = new FirefoxDriver();;
		
		//Getting the url address
		driver.get("http://google.com");
		
		System.out.println(driver.getTitle());	
		
		
	}

}
