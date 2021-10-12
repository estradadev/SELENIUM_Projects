package Academy;

import PageObject.LandingPage;
import PageObject.LoginPage;
import Resources.Base;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePage extends Base {

    @Test
    public void basePageNavigation() throws IOException {

        driver = initializeDriver();
        driver.get("http://qaclickacademy.com");

        //Home Page
        LandingPage lp = new LandingPage(driver);
        lp.getLogin().click();

        //Login Page
        LoginPage lip = new LoginPage(driver);
        lip.getEmail().sendKeys("hello");
        lip.getPassword().sendKeys("hello");
        lip.getLogin().click();






        waitForQuit(500);
    }

}
