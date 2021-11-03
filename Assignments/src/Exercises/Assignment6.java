package Exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\eadri\\Documents\\SELENIUM_Projects\\chromedriver_win32\\chromedriver.exe");

        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(optionsChrome);

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //1- Select any checkbox
        clickElement(driver,"//input[@value='option1']");
        //2- Grab the label of the selected checkbox
        String checkboxSelected = driver.findElement(By.xpath("//input[@value='option1']")).getAttribute("value");
        System.out.println(checkboxSelected);
        //3- Select the Dropdown that is equals to the checkbox selected
        //   Here option to select should come from step 2
        selectOption(driver, "//select[@name='dropdown-class-example']", checkboxSelected);
        //4- Enter the step 2 grabbed label text in Edit box
        sendKeystoElement(driver,"//input[@name='enter-name']",checkboxSelected);
        //5- Click on "Alert" and verify if text grabbed from step 2 is present in the pop-up message
        clickElement(driver,"//input[@value='Alert']");

        String popupMessage = driver.switchTo().alert().getText();
        System.out.println(popupMessage);
        String[] text = popupMessage.split(",");
        //System.out.println(text[0]);
        String[] word = text[0].split("lo");
        //System.out.println(word[1]);
        String pMessage = word[1].trim();
        System.out.println(pMessage);

        driver.switchTo().alert().accept();

        Assert.assertEquals(pMessage,checkboxSelected);


        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: " + e);
        }
        driver.quit();
    }

    public static void clickElement(WebDriver driver, String xPath){

        try {
            WebElement element = driver.findElement(By.xpath(xPath));
            element.click();
        }
        catch (Exception e) {
            System.out.println("XPhat not found " + xPath);
            System.out.println(e);
            driver.quit();
        }

    }

    public static void selectOption(WebDriver driver, String xPath, String optionSelected){

        try {
            Select select = new Select(driver.findElement(By.xpath(xPath)));
            select.selectByValue(optionSelected);
        }
        catch (Exception e) {
            System.out.println("XPhat not found " + xPath);
            System.out.println(e);
            driver.quit();
        }

    }

    public static void sendKeystoElement(WebDriver driver, String xPath, String message){

        try {
            WebElement element = driver.findElement(By.xpath(xPath));
            element.sendKeys(message);
        }
        catch (Exception e) {
            System.out.println("XPhat not found " + xPath);
            System.out.println(e);
            driver.quit();
        }

    }

}
