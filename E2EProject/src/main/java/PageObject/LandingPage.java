package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    public WebDriver driver;

    public LandingPage(WebDriver driver){
        this.driver = driver;
    }

    private By signin = By.cssSelector("a[href*='sign_in']");
    private By title = By.cssSelector(".text-center>h2");
    private By navBar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
    private By header = By.cssSelector("div[class*='video-banner'] h3");

    public LoginPage getLogin(){

        try {
            driver.findElement(signin).click();

        }
        catch (Exception e) {
            System.out.println("CSS not found " + signin);
            System.out.println(e);
            driver.quit();
            //return driver.findElement(signin);
        }

        LoginPage lip = new LoginPage(driver);
        return lip;

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

    public WebElement getHeader()
    {
        return driver.findElement(header);
    }
}
