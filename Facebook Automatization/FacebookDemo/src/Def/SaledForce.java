package Def;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SaledForce {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\eduardo.estrada\\Documents\\UDEMY\\Selenium WebDriver with Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://login.salesforce.com/?locale=mx");
		driver.findElement(By.id("username")).sendKeys("example@yeha.com");
		driver.findElement(By.name("pw")).sendKeys("password");
		//driver.findElement(By.linkText("?Olvidaste tu contrase?a?")).click();
		driver.findElement(By.xpath("//*[@id='Login']")).click();
		System.out.println(driver.findElement(By.cssSelector("#error")).getText());
		
		try{
			Thread.sleep(1000);
		}
		catch (InterruptedException e) {
			System.out. println("We have a Problem: "+e);
		}
		
		driver.quit();

	}

}
