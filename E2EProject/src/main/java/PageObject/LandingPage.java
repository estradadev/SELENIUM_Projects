package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    public WebDriver driver;

    public LandingPage(WebDriver driver){
        this.driver = driver;
    }

    By signin = By.cssSelector("a[href*='sign_in']");
    By title = By.cssSelector(".text-center>h2");
    By navBar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");

    public WebElement getLogin(){

        try {
            return driver.findElement(signin);
        }
        catch (Exception e) {
            System.out.println("CSS not found " + signin);
            System.out.println(e);
            driver.quit();
            return driver.findElement(signin);
        }

    }

    public WebElement getTitle(){
        try {
            return driver.findElement(title);
        }
        catch (Exception e) {
            System.out.println("CSS not found " + title);
            System.out.println(e);
            driver.quit();
            return driver.findElement(title);
        }

    }

    public WebElement getNavigationBar(){
        try {
            return driver.findElement(navBar);
        }
        catch (Exception e) {
            System.out.println("CSS not found " + navBar);
            System.out.println(e);
            driver.quit();
            return driver.findElement(navBar);
        }

    }

}
