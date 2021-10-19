package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private By email = By.cssSelector("input[id='user_email']");
    private By password = By.cssSelector("input[id='user_password']");
    private By login = By.cssSelector("input[type='submit']");
    private By forgotPassword = By.cssSelector(".link-below-button");

    public WebElement getEmail(){

        try {
            return driver.findElement(email);
        }
        catch (Exception e) {
            System.out.println("CSS not found " + email);
            System.out.println(e);
            driver.quit();
            return driver.findElement(email);
        }

    }

    public ForgotPassword forgotPassword(){
        driver.findElement(forgotPassword).click();
        ForgotPassword fp = new ForgotPassword(driver);
        return fp;
    }

    public WebElement getPassword(){

        try {
            return driver.findElement(password);
        }
        catch (Exception e) {
            System.out.println("CSS not found " + password);
            System.out.println(e);
            driver.quit();
            return driver.findElement(password);
        }

    }

    public WebElement getLogin(){

        try {
            return driver.findElement(login);
        }
        catch (Exception e) {
            System.out.println("CSS not found " + login);
            System.out.println(e);
            driver.quit();
            return driver.findElement(login);
        }

    }

}
