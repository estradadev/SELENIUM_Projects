package Resources;

//import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.*;
//import org.apache.commons.io.FileUtils.copyFile;

public class Base {

    public WebDriver driver;
    public Properties prop;

    public WebDriver initializeDriver() throws IOException {

        prop = new Properties();
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

    public String getScreenShotPath(String testMethodName, WebDriver driver) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "\\Reports\\" + testMethodName + ".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;

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
