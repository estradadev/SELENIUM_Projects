import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

public class RelativeLocator {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\eadri\\Documents\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
        //to maximize the screen
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(optionsChrome);

        driver.get("https://rahulshettyacademy.com/angularpractice/");

        WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));

        //System.out.println(driver.findElement(withTagName("label")).above(nameEditBox).getText());
        //driver.findElement(withTagName("label")).above(nameEditBox).getText();

        /*
        WebElement dateofBirth= driver.findElement(By.cssSelector("[for='dateofBirth']"));
        driver.findElement(withTagName("input").below(dateofBirth)).sendKeys("02/02/1992");
        WebElement iceCreamLabel=driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
        driver.findElement(withTagName("input").toLeftOf(iceCreamLabel)).click();
        //Get me the label of first Radio button
        WebElement rb=driver.findElement(By.id("inlineRadio1"));
        System.out.println(driver.findElement(withTagName("label").toRightOf(rb)).getText());
        */

        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: " + e);
        }
        driver.quit();
    }
}
