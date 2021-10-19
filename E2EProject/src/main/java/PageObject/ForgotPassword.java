package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

    public WebDriver driver;

    public ForgotPassword(WebDriver driver){
        this.driver = driver;
    }

    private By email = By.cssSelector("input[id='user_email']");
    private By sendMeInstructions = By.cssSelector("input[name='commit']");

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

    public WebElement sendMeInstructions(){

        try {
            return driver.findElement(sendMeInstructions);
        }
        catch (Exception e) {
            System.out.println("CSS not found " + sendMeInstructions);
            System.out.println(e);
            driver.quit();
            return driver.findElement(sendMeInstructions);
        }

    }

}
