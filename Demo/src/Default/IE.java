package Default;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//geko driver
		System.setProperty("webdriver.ie.driver", 
	 			"C:\\Users\\eduardo.estrada\\Documents\\Academy\\IEDriverServer_x64_2.39.0\\IEDriverServer.exe");
		
		//Using the Class FirefoxDriver
		WebDriver driver = new InternetExplorerDriver();
		
		//Getting the url address
		driver.get("http://google.com");
				
		System.out.println(driver.getTitle());	

	}

}
