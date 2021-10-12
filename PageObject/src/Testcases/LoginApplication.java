package Testcases;

import objectrepository.RediffHomepage;
import objectrepository.RediffLoginpage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginApplication {

    @Test
    public void Login(){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\eadri\\Documents\\SELENIUM_Projects\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

        //Login Page
        RediffLoginpage rd = new RediffLoginpage(driver);
        rd.EmaiId().sendKeys("Hello");
        rd.Password().sendKeys("Hello");
        rd.Submit().click();
        rd.Home().click();

        //Home Page
        RediffHomepage rh = new RediffHomepage(driver);
        rh.Search().sendKeys("rediff");
        rh.Submit().click();

        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: " + e);
        }
        driver.quit();
    }

}
