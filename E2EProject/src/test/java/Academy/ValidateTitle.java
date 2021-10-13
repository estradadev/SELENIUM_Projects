package Academy;

import PageObject.LandingPage;
import PageObject.LoginPage;
import Resources.Base;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class ValidateTitle extends Base {

    public static Logger log = LogManager.getLogger(Base.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");
        driver.get(prop.getProperty("homeUrl"));
        log.info("Navigated to Home page");
    }

    @Test
    public void basePageNavigation() throws IOException {
        /*
        driver = initializeDriver();
        driver.get(prop.getProperty("homeUrl"));*/

        //Home Page
        LandingPage lp = new LandingPage(driver);
        //comapare the text from the browser with actual text
        Assert.assertEquals(lp.getTitle().getText(),"FEATURED COURSES");
        log.info("Successfully validated Text message");
        System.out.println(lp.getTitle().getText());


        waitForQuit(500);
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }

}
