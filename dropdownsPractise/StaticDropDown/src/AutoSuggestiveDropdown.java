import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class AutoSuggestiveDropdown {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\eadri\\Documents\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
        //to maximize the screen
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(optionsChrome);
        //getting the page
        driver.get("https://rahulshettyacademy.com/dropdownsPractise");

        SendKeysByID(driver, "autosuggest","ind");
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: " + e);
        }
        /*List<WebElement> optionsAutoSuggestive = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        for (WebElement option: optionsAutoSuggestive) {
            if(option.getText().equalsIgnoreCase("India")){
                option.click();
            }
        }*/
        ChooseAutoSuggestiveDropdownElementByCSS(driver, "li[class='ui-menu-item'] a", "India");



        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: " + e);
        }
        driver.quit();
    }

    public static void SendKeysByID(WebDriver driver, String ID, String keys){
        WebElement element;

        try {
            element = driver.findElement(By.id(ID));
            element.sendKeys(keys);
        }
        catch (Exception e){
            System.out.printf("ID not found " + ID + "\n");
            System.out.printf("Exception ->  \n" + e + "\n");
            driver.quit();
        }

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


    public static void ChooseAutoSuggestiveDropdownElementByCSS(WebDriver driver, String CSS, String element){
        List<WebElement> optionsAutoSuggestiveDropdown;
        try{
            optionsAutoSuggestiveDropdown = driver.findElements(By.cssSelector(CSS));
            for (WebElement option: optionsAutoSuggestiveDropdown) {
                if(option.getText().equalsIgnoreCase(element)){
                    option.click();
                    break;
                }
            }
        }
        catch (Exception e){
            System.out.printf("CSS not found " + CSS + "\n");
            System.out.printf("Exception ->  \n" + e + "\n");
            driver.quit();
        }
    }

}
