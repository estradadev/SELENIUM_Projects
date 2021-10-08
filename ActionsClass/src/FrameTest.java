import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class FrameTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\eadri\\Documents\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
        //to maximize the screen
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(optionsChrome);

        driver.get("http://jqueryui.com/droppable/");

        /*
        //switch to frame by frame index
        driver.switchTo().frame(0);*/

        //to know how many frames are in the page
        driver.findElement(By.tagName("iframe")).getSize();

        //switch to frame by driver
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));

        //clicking the element
        //driver.findElement(By.id("draggable")).click();

        //Drag and Drop method
        Actions a = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        a.dragAndDrop(source, target).build().perform();

        //for go back from the frame
        driver.switchTo().defaultContent();


        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: " + e);
        }
        driver.quit();
    }

}
