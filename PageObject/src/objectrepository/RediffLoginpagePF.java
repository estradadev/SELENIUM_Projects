package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffLoginpagePF {

    WebDriver driver;

    public RediffLoginpagePF(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath=".//*[@id='login1']")
    WebElement username;

    @FindBy(name="passwd")
    WebElement password;

    @FindBy(name="proceed")
    WebElement go;

    @FindBy(linkText="rediff.com")
    WebElement home;


    public WebElement EmaiId(){
        return username;
    }

    public WebElement Password(){
        return password;
    }

    public WebElement Submit(){
        return go;
    }

    public WebElement Home(){
        return home;
    }

}
