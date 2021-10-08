import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Alerts {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\eadri\\Documents\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
        //to maximize the screen
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(optionsChrome);
        //getting the page
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("name")).sendKeys("Eduardo");
        /*driver.findElement(By.id("alertbtn")).click();
        //Alert with one option
        //Grab the text of the alert
        System.out.printf(driver.switchTo().alert().getText());
        //Accept the alert
        driver.switchTo().alert().accept();*/

        //Alert with two options
        driver.findElement(By.id("confirmbtn")).click();
        //Grab the text of the alert
        System.out.printf(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();


        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: " + e);
        }
        driver.quit();
    }

}
