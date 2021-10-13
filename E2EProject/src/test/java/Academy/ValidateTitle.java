package Academy;

import PageObject.LandingPage;
import PageObject.LoginPage;
import Resources.Base;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class ValidateTitle extends Base {

    @Test
    public void basePageNavigation() throws IOException {

        driver = initializeDriver();
        driver.get(prop.getProperty("homeUrl"));

        //Home Page
        LandingPage lp = new LandingPage(driver);
        //comapare the text from the browser with actual text
        Assert.assertEquals(lp.getTitle().getText(),"FEATURED COURSES");
        System.out.println(lp.getTitle().getText());


        waitForQuit(500);
    }

}
