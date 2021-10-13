package Academy;

import PageObject.LandingPage;
import Resources.Base;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class ValidateNavigationBar extends Base {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("homeUrl"));
    }

    @Test
    public void basePageNavigation() throws IOException {
        /*
        driver = initializeDriver();
        driver.get(prop.getProperty("homeUrl"));*/

        //Home Page
        LandingPage lp = new LandingPage(driver);

        Assert.assertTrue(lp.getNavigationBar().isDisplayed());
        System.out.println(lp.getNavigationBar().isDisplayed());


        waitForQuit(500);
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }

}
