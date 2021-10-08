import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\eadri\\Documents\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
        //to maximize the screen
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(optionsChrome);

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //Dropdown
        WebElement staticDopdown = driver.findElement(By.id("dropdown-class-example"));
        Select dropdown =new Select(staticDopdown);

        //select checkbox
        driver.findElement(By.id("checkBoxOption2")).click();
        String checkBoxOption = driver.findElement(By.id("checkBoxOption2")).getAttribute("value");
        System.out.println(checkBoxOption);

        //select option Dropdown
        dropdown.selectByValue(checkBoxOption);
        String dropdownOption = dropdown.getFirstSelectedOption().getText();
        System.out.println(dropdownOption);

        //alert write
        driver.findElement(By.id("name")).sendKeys(checkBoxOption);
        driver.findElement(By.id("alertbtn")).click();
        //Grab the text of the alert
        String alertText = driver.switchTo().alert().getText();
        System.out.printf(alertText);
        //Accept the alert
        driver.switchTo().alert().accept();


        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: " + e);
        }
        driver.quit();
    }

}
