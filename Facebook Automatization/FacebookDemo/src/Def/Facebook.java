package Def;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {
	
	//static WebDriver driver = new ChromeDriver();
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\eduardo.estrada\\Documents\\UDEMY\\Selenium WebDriver with Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("example@yeha.com");
		driver.findElement(By.name("pass")).sendKeys("password");
		//driver.findElement(By.linkText("?Olvidaste tu contrase?a?")).click();
		driver.findElement(By.xpath("//button[@name='login']")).click();
		////*[@id="u_0_d_cz"] //*[@id="u_0_d_cz"]
		//button[@name='login']
		
		try{
			Thread.sleep(5000);
		}
		catch (InterruptedException e) {
			System.out. println("We have a Problem: "+e);
		}
		
		driver.quit();
		
		
	}

}
