package Resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public WebDriver driver;

    public WebDriver initializeDriver() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\eadri\\Documents\\SELENIUM_Projects\\E2EProject\\src\\main\\java\\Resources\\data.properties");

        prop.load(fis);
        String browserName = prop.getProperty("browser");

        switch (browserName){
            case "chrome":
                System.out.println("Execute in chrome driver");
                System.setProperty("webdriver.chrome.driver","C:\\Users\\eadri\\Documents\\SELENIUM_Projects\\chromedriver_win32\\chromedriver.exe");
                ChromeOptions optionsChrome = new ChromeOptions();
                optionsChrome.addArguments("--start-maximized");
                driver = new ChromeDriver(optionsChrome);
                break;
            case "firefox":
                System.out.println("Execute in firefox driver");
                System.setProperty("webdriver.gecko.driver","C:\\Users\\eadri\\Documents\\SELENIUM_Projects\\geckodriver-v0.30.0-win32\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.out.println("Execute in IE driver");
                System.setProperty("webdriver.msedge.driver","C:\\Users\\eadri\\Documents\\SELENIUM_Projects\\edgedriver_win32\\msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Your browser is not configured, we send chrome");
                System.setProperty("webdriver.chrome.driver","C:\\Users\\eadri\\Documents\\SELENIUM_Projects\\chromedriver_win32\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }

    public void waitForQuit(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: \n" + e);
        }
        driver.quit();
    }

}
