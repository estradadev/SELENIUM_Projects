import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class UpdatedDropdown {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\eadri\\Documents\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
        //to maximize the screen
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);

        //WebDriver driver = new ChromeDriver();
        //getting the page
        driver.get("https://rahulshettyacademy.com/dropdownsPractise");

        //Using Assertions
        //Assert if False
        //Assert.assertFalse(false);
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        //Make sure that a checkbox is selected
        //System.out.printf(String.valueOf(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()) + "\n");
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        //Assert if true
        //Assert.assertTrue(false);
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
       //System.out.printf(String.valueOf(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()) + "\n");
        //Count the number of checkbox
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

        /*//working with PASSENGERS Dropdown
        driver.findElement(By.id("divpaxinfo")).click();
        try {
            Thread.sleep(2000L);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: "+e);
        }
        //adding  a PASSENGER -> we want to select 5 PASSENGERS
        driver.findElement(By.id("hrefIncAdt")).click();
        //selection done
        driver.findElement(By.id("btnclosepaxoption")).click();*/

        clickElementById(driver, "divpaxinfo");
        try {
            Thread.sleep(2000L);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: "+e);
        }
        //we want to select 5 PASSENGERS
        int i = 1;
        while(i<5) {
            clickElementById(driver, "hrefIncAdt");
            i++;
        }
        clickElementById(driver, "btnclosepaxoption");
        //Assert to verify information
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
        System.out.printf(driver.findElement(By.id("divpaxinfo")).getText());


        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: "+e);
        }

        driver.quit();

    }

    public static void clickElementById(WebDriver driver, String ID){
        //driver.findElement(By.id(ID)).click();
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

}
