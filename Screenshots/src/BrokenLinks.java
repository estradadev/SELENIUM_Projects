import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrokenLinks {

    public static void main(String[] args) throws IOException {
        //how to handle broken links
        System.setProperty("webdriver.chrome.driver","C:\\Users\\eadri\\Documents\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
        //to maximize the screen
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(optionsChrome);

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //broken URL
        //Steep 1 - Is to get all urls tied up to the links using Selenium
        //Java methods will call URL'S and gets you the status code
        //if status code > 400 the un is not working -> which tied to URL is broken

        //trying many links
        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        //Soft Assert Class
        SoftAssert softAss = new SoftAssert();
        String url;
        HttpURLConnection conn;
        int respCode;
        for (WebElement link:links) {
            url = link.getAttribute("href");
            System.out.println(url);

            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            respCode = conn.getResponseCode();
            System.out.println(respCode);

            //if a link is broken the test will fail
            //Soft Assert
            softAss.assertTrue(respCode<400,"The link with Text: " + link.getText() + " is broken, with code " + respCode);
            //Hard Assertion
            //Assert.assertTrue(respCode>400,"The link with Text: " + link.getText() + " is broken, with code " + respCode);
            /*if(respCode>400){
                System.out.println("The link with Text: " + link.getText() + " is broken, with code " + respCode);
                driver.quit();
                Assert.assertTrue(false);
            }*/

        }

        //with soft assert if there are fails the program will fail at the end
        //softAss.assertAll();

        /* //Core method
        String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
        System.out.println(url);

        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestMethod("HEAD");
        conn.connect();
        int respCode = conn.getResponseCode();
        System.out.println(respCode);*/




        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: " + e);
        }
        driver.quit();

        softAss.assertAll();
    }

}
