import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.List;

public class Addingitemscar {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\eadri\\Documents\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
        //to maximize the screen
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(optionsChrome);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: " + e);
        }

        //Creating a list to choose the correct item
        List<WebElement> options = driver.findElements(By.cssSelector("h4.product-name"));
        String[] nameItem;
        String formattedNameItem;
        String[] itemsNeeded = {"Cucumber","Brocolli","Beetroot"};
        List itemsNeededList;
        int j=0;

        for(int i = 0; i < options.size(); i++){

            //Brocolli - 1 kg
            nameItem = options.get(i).getText().split("-");
            //Brocolli , 1 kg
            //Array divided by "-"
            formattedNameItem = nameItem[0].trim();
            //Array without space
            //format it to get actual vegetable name

            //convert array into array list for easy search
            //check whether name you extracted is present in arrayList or not
            //List itemsNeededList = Arrays.asList(itemsNeeded);
            itemsNeededList = Arrays.asList(itemsNeeded);

            if(itemsNeededList.contains(formattedNameItem)){
                //click on add to car
                j++;
                driver.findElements(By.xpath("//div[@class = 'product-action']")).get(i).click();
                //break;
                if(j==3)break;
            }
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
