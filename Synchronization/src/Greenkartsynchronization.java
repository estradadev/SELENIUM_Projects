import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Greenkartsynchronization {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\eadri\\Documents\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
        //to maximize the screen
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(optionsChrome);

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        //Implicit Wait for 5 seconds (global wait for ich line)
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //Explicit Wait
        WebDriverWait exWait = new WebDriverWait(driver, 5);

        String[] itemsNeeded = {"Cucumber","Brocolli","Beetroot"};

        addItems(driver, itemsNeeded);
        //clickElementByXPath(driver,"//img[@alt='Cart']");
        clickElementByCSS(driver, "img[alt='Cart']");
        clickElementByXPath(driver,"//button[text()='PROCEED TO CHECKOUT']");
        sendKeysByXPath(driver, "//input[@class='promoCode']", "rahulshettyacademy");
        //clickElementByXPath(driver, "//button[@class='promoBtn']");
        clickElementByCSS(driver, "button.promoBtn");

        //Explicit Wait just for the Element needed
        exWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());


        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: " + e);
        }
        driver.quit();

    }

    public static void addItems(WebDriver driver, String[] itemsNeeded){

        //Creating a list to choose the correct item
        List<WebElement> options = driver.findElements(By.cssSelector("h4.product-name"));
        String[] nameItem;
        String formattedNameItem;
        List itemsNeededList;
        int j=0;

        try{

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
                    if(j==itemsNeeded.length)break;
                }
            }

        }
        catch (Exception e){
            System.out.printf("Exception ->  \n" + e + "\n");
            driver.quit();
        }

    }

    public static void clickElementByXPath(WebDriver driver, String XPath){
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

    public static void clickElementByCSS(WebDriver driver, String CSS){
        WebElement element;
        try{
            element = driver.findElement(By.cssSelector(CSS));
            element.click();
        }
        catch (Exception e){
            System.out.printf("CSS not found " + CSS + "\n");
            System.out.printf("Exception ->  \n" + e + "\n");
            driver.quit();
        }
    }

    public static void sendKeysByXPath(WebDriver driver, String XPath, String keys){
        WebElement element;
        try{
            element = driver.findElement(By.xpath(XPath));
            element.sendKeys(keys);
        }
        catch (Exception e){
            System.out.printf("XPhat not found " + XPath + "\n");
            System.out.printf("Exception ->  \n" + e + "\n");
            driver.quit();
        }
    }

}
