import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class Assignment7 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\eadri\\Documents\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
        //to maximize the screen
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(optionsChrome);

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //Number of Rows
        //List<WebElement> rows = driver.findElements(By.cssSelector("table[name='courses'] tr "));
        int numRows = driver.findElements(By.cssSelector("table[name='courses'] tr ")).size();
        System.out.println("The number of Rows is: " + numRows);

        //Number of Columns
        int numColumns = driver.findElements(By.cssSelector("table[name='courses'] tr th")).size();
        System.out.println("The number of Columns is: " + numColumns);

        //Print second row
        List<WebElement> secondrow = driver.findElements(By.cssSelector("table[name='courses'] tr ")).get(2).findElements(By.tagName("td"));
        System.out.println(secondrow.get(0).getText());
        System.out.println(secondrow.get(1).getText());
        System.out.println(secondrow.get(2).getText());



        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: " + e);
        }
        driver.quit();
    }

}
