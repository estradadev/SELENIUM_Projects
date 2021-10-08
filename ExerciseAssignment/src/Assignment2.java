import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\eadri\\Documents\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
        //to maximize the screen
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(optionsChrome);

        driver.get("https://www.cleartrip.com");

        //select Adults
        WebElement AdultsDropdown = driver.findElement(By.xpath("//h4[text()='Adults']/following-sibling::select"));
        Select adulDropdown = new Select(AdultsDropdown);
        adulDropdown.selectByValue("3");

        //select Children
        WebElement childrenDropdown = driver.findElement(By.xpath("//h4[text()='Children']/following-sibling::select"));
        Select chilDropdown = new Select(childrenDropdown);
        chilDropdown.selectByValue("2");

        //select Infants
        WebElement infantsDropdown = driver.findElement(By.xpath("//h4[text()='Infants']/following-sibling::select"));
        Select infaDropdown = new Select(infantsDropdown);
        infaDropdown.selectByValue("2");

        //select "more options"
        driver.findElement(By.cssSelector("strong[class='pr-1']")).click();

        //select Class of travel
        WebElement classTravelDropdown = driver.findElement(By.xpath("//h4[text()='Class of travel']/following-sibling::select"));
        Select classTravDropdown = new Select(classTravelDropdown);
        classTravDropdown.selectByValue("First");

        //write Preferred Airline
        driver.findElement(By.xpath("//input[@placeholder='Airline name']")).sendKeys("Ready");

        //click on Search flights
        driver.findElement(By.xpath("//button[text()='Search flights']")).click();

        //get the error message
        System.out.println(driver.findElement(By.xpath("//div[@class='col-24']//div//span")).getText());


        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: " + e);
        }
        driver.quit();
    }


}
