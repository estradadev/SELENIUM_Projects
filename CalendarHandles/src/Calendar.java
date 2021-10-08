import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class Calendar {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\eadri\\Documents\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
        //to maximize the screen
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(optionsChrome);

        driver.get("https://www.path2usa.com/travel-companions");

        //We want to select November 23
        driver.findElement(By.xpath("//input[@id='travel_date']")).click();

        //Select Month
        while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("November")){
            driver.findElement(By.cssSelector("[class='datepicker-days'] [class='next']")).click();
        }

        //Select Day we need to safe all days in a list
        List<WebElement> dates = driver.findElements(By.className("day"));
        //Grap common attribute //Put into list and iterate
        int countDay = driver.findElements(By.className("day")).size();

        for(int i=0; i < countDay; i++){

            String textDay = driver.findElements(By.className("day")).get(i).getText();

            if(textDay.equalsIgnoreCase("23")){

                driver.findElements(By.className("day")).get(i).click();
                break;
            }

        }


        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: " + e);
        }
        driver.quit();
    }
}
