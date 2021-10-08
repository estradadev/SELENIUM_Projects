import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\eadri\\Documents\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //getting the page
        driver.get("https://rahulshettyacademy.com/dropdownsPractise");

        /*//dropdown with select tag -static
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);

        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByValue("INR");
        System.out.println(dropdown.getFirstSelectedOption().getText());*/

        SelectDropdownByIndex(driver,"ctl00_mainContent_DropDownListCurrency",3);
        SelectDropdownByText(driver,"ctl00_mainContent_DropDownListCurrency", "AED");
        SelectDropdownByValue(driver,"ctl00_mainContent_DropDownListCurrency","INR");

        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: "+e);
        }

        driver.quit();

    }

    public static void SelectDropdownByIndex(WebDriver driver, String Dropdown, int index){
        /*WebElement staticDropdown = driver.findElement(By.id(Dropdown));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(index);
        System.out.println(dropdown.getFirstSelectedOption().getText());*/
        WebElement staticDropdown;
        try{
            staticDropdown = driver.findElement(By.id(Dropdown));
            Select dropdown = new Select(staticDropdown);
            dropdown.selectByIndex(index);
            System.out.println(dropdown.getFirstSelectedOption().getText());
        }
        catch (Exception e){
            System.out.printf("Index not found " + index);
            System.out.printf("Exception ->  \n" + e);
            driver.quit();
        }
    }

    public static void SelectDropdownByText(WebDriver driver, String Dropdown, String text){
        /*WebElement staticDropdown = driver.findElement(By.id(Dropdown));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByVisibleText(text);
        System.out.println(dropdown.getFirstSelectedOption().getText());*/
        WebElement staticDropdown;
        try{
            staticDropdown = driver.findElement(By.id(Dropdown));
            Select dropdown = new Select(staticDropdown);
            dropdown.selectByVisibleText(text);
            System.out.println(dropdown.getFirstSelectedOption().getText());
        }
        catch (Exception e){
            System.out.printf("Text not found " + text);
            System.out.printf("Exception ->  \n" + e);
            driver.quit();
        }
    }

    public static void SelectDropdownByValue(WebDriver driver, String Dropdown, String value){
        /*WebElement staticDropdown = driver.findElement(By.id(Dropdown));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByValue(value);
        System.out.println(dropdown.getFirstSelectedOption().getText());*/

        WebElement staticDropdown;
        try{
            staticDropdown = driver.findElement(By.id(Dropdown));
            Select dropdown = new Select(staticDropdown);
            dropdown.selectByValue(value);
            System.out.println(dropdown.getFirstSelectedOption().getText());
        }
        catch (Exception e){
            System.out.printf("Value not found " + value);
            System.out.printf("Exception ->  \n" + e);
            driver.quit();
        }

        /*WebElement element;
        try{
            element = driver.findElement(By.xpath(""));
            element.click();
        }
        catch (Exception e){
            System.out.printf("XPhat not found " + XPath);
            System.out.printf("Exception ->  \n" + e);
            driver.quit();
        }*/

    }

}
