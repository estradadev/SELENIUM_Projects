import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DynamicDropdown {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\eadri\\Documents\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
        //to maximize the screen
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        //getting the page
        driver.get("https://rahulshettyacademy.com/dropdownsPractise");


        ClickElementByID(driver,"ctl00_mainContent_ddl_originStation1_CTXT");
        //ClickElementByXPath(driver,"//a[@value='BLR']");
        //div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//a[@value='BLR']
        ClickElementByXPath(driver,"//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//a[@value='BLR']");
        try {
            Thread.sleep(2000L);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: " + e);
        }
        //ClickElementByXPath(driver,"(//a[@value='MAA'])[2]");
        //div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']
        ClickElementByXPath(driver,"//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']");


        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: " + e);
        }

        driver.quit();

    }

    public static void ClickElementByID(WebDriver driver, String ID){
        WebElement element;
        try{
            element = driver.findElement(By.id(ID));
            element.click();
        }
        catch (Exception e){
            System.out.printf("ID not found " + ID + "\n");
            System.out.printf("Exception ->  \n" + e + "\n");
            driver.quit();
        }
    }

    public static void ClickElementByXPath(WebDriver driver, String XPath){
        WebElement element;
        try{
            element = driver.findElement(By.xpath(XPath));
            element.click();
        }
        catch (Exception e){
            System.out.printf("XPhat not found " + XPath + "\n");
            System.out.printf("Exception ->  \n" + e + "\n");
            driver.quit();
        }
    }

}
