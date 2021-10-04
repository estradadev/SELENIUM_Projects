import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test1 {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
		"C:\\Users\\eduardo.estrada\\OneDrive - Softtek\\Documents\\UDEMY\\SELENIUM\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
	
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.youtube.com/");
	
		
		//Program
		driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys("alla turca");
		driver.findElement(By.id("search-icon-legacy")).click();
		driver.findElement(By.xpath("//*[@id=\"video-title\"]/yt-formatted-string")).click();
		
		
		
		try {
			Thread.sleep(500);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.quit();
	}

}
