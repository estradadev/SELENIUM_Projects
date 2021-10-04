package Default;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
		
		//chromeDriver Address
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\eduardo.estrada\\Documents\\Academy\\chromedriver_win32\\chromedriver.exe");
		
		//Using the Class ChromeDriver
		WebDriver driver = new ChromeDriver();
		
		//Getting the url address
		driver.get("http://google.com");//Hit the url on the browser
		System.out.println(driver.getTitle());//validate if page title is correct
		
		System.out.println(driver.getCurrentUrl());//validate if we landed on correct url
		//System.out.println(driver.getPageSource());//print the page sourse
		
		driver.navigate().to("http://yahoo.com");
		//driver.navigate().back();//navigate back the current page <--
		//driver.navigate().forward();//navigate back the current page -->
		
		//driver.close();//It closes current browser
		driver.quit();//It closes all the browsers opened by SELENIUM script
		
		
		
	}

}
