import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Iterator;
import java.util.Set;

public class Assignment4 {

    public static void main(String[] args) {
        //Handle Windows
        System.setProperty("webdriver.chrome.driver","C:\\Users\\eadri\\Documents\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
        //to maximize the screen
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(optionsChrome);

        driver.get("https://the-internet.herokuapp.com/");

        //click on multiple windows
        driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();

        //click in open new window "click here"
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        //print the message of the new tab
        //Method to window handles
        Set<String> window = driver.getWindowHandles();
        Iterator<String> it = window.iterator();
        String parentId = it.next();
        String childId = it.next();
        //switch to child window
        driver.switchTo().window(childId);
        //printing the message
        System.out.println(driver.findElement(By.className("example")).getText());

        //return the new window and print "open a new window message"
        //return to the parent window
        driver.switchTo().window(parentId);
        //printing the message
        System.out.println(driver.findElement(By.cssSelector(".example h3")).getText());


        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: " + e);
        }
        driver.quit();
    }

}
