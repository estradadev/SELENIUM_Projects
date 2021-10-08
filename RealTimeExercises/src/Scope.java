import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Iterator;
import java.util.Set;

public class Scope {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\eadri\\Documents\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
        //to maximize the screen
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(optionsChrome);

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //1. Give me the count of links on the page
        System.out.println(driver.findElements(By.tagName("a")).size());

        //2. Give me the count of the links on the footer section on the page
        WebElement footerdriver = driver.findElement(By.id("gf-BIG"));//limiting webdriver scope
        System.out.println(footerdriver.findElements(By.tagName("a")).size());

        //3. Give me the count of the links on the first column on the footer section
        WebElement columnDriver= footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(columnDriver.findElements(By.tagName("a")).size());

        //4. Click on ich link in the column and check if the pages are opening
        String clickOnLinkTab;
        for (int i=1; i<columnDriver.findElements(By.tagName("a")).size(); i++){
            //Open the links in other tab
            clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);

            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
        }

        Set<String> tabs = driver.getWindowHandles();
        Iterator<String> itera = tabs.iterator();

        while (itera.hasNext()){

            driver.switchTo().window(itera.next());
            System.out.println(driver.getTitle());

        }




        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: " + e);
        }
        driver.quit();
    }

}
