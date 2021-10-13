package Academy;

import PageObject.LandingPage;
import Resources.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

//Adding logs
//Generating html reports
//Screenshots on failure
//Jenkins integration

public class ValidateNavigationBar extends Base {

    public static Logger log = LogManager.getLogger(Base.class.getName());

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
        log.info("Navigation Bar is displayed");
        System.out.println(lp.getNavigationBar().isDisplayed());


        waitForQuit(500);
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }

}
