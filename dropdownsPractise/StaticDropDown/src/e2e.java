import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class e2e {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\eadri\\Documents\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
        //to maximize the screen
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(optionsChrome);
        //getting the page
        driver.get("https://rahulshettyacademy.com/dropdownsPractise");

        ClickElementByID(driver,"ctl00_mainContent_ddl_originStation1_CTXT");
        ClickElementByXPath(driver,"//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//a[@value='BLR']");
        try {
            Thread.sleep(1000L);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: " + e);
        }
        ClickElementByXPath(driver,"//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']");


        //Handling Calendar 'One Way'
        ClickElementByCSS(driver, ".ui-state-default.ui-state-highlight");
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")){
            System.out.printf("Is disabled \n" );
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }

        //Add passengers
        ClickElementByID(driver, "divpaxinfo");
        try {
            Thread.sleep(2000L);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: "+e);
        }
        int i = 1;
        while(i<5) {
            ClickElementByID(driver, "hrefIncAdt");
            i++;
        }
        ClickElementByID(driver, "btnclosepaxoption");

        //Select Family and Friends checkbox
        ClickElementByID(driver, "ctl00_mainContent_chk_friendsandfamily");

        //Search
        ClickElementByID(driver,"ctl00_mainContent_btn_FindFlights");





        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: " + e);
        }
        driver.quit();

    }

    public static void ClickElementByCSS(WebDriver driver, String CSS){
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

    public static void ClickElementByXPath(WebDriver driver, String XPath){
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

}
