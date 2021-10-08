import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class AutomatingPaginationScenarios {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\eadri\\Documents\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
        //to maximize the screen
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(optionsChrome);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //1- click on the columns
        driver.findElement(By.xpath("//tr/th[1]")).click();

        //2- capture all web elements into list
        List<WebElement> elementsList = driver.findElements(By.xpath("//tr//td[1]"));

        //3- capture text of all web element into new(original list)
        List<String> originalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());

        //4- sort on the original list of step 3 -> sorted list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        //5- compare original list vs sorted
        Assert.assertTrue(originalList.equals(sortedList));

        //Build Custom Selenium methods using Streams Mapper
        //scan the name column with getText -> Rice -> print the price of the Rice
        List<String> price;
        do {

            List<WebElement> rows = driver.findElements(By.xpath("//tr//td[1]"));

            price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s)).collect(Collectors.toList());

            price.forEach(a -> System.out.println(a));

            if(price.size() < 1){
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        }while(price.size() < 1);//Automating Pagination Scenarios to search the data using do while loop


        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: " + e);
        }
        driver.quit();
    }

    private static String getPriceVeggie(WebElement s){

        String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();

        return priceValue;

    }

}
