package Academy;

import PageObject.LandingPage;
import PageObject.LoginPage;
import Resources.Base;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePage extends Base {
    /*
    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("homeUrl"));
    }*/

    @Test(dataProvider = "getData")
    public void basePageNavigation(String email, String password, String text) throws IOException {

        driver = initializeDriver();
        driver.get(prop.getProperty("homeUrl"));

        //Home Page
        LandingPage lp = new LandingPage(driver);
        lp.getLogin().click();

        //Login Page
        LoginPage lip = new LoginPage(driver);
        lip.getEmail().sendKeys(email);
        lip.getPassword().sendKeys(password);
        System.out.println(text);
        lip.getLogin().click();


        waitForQuit(500);
    }

    @DataProvider
    public Object[][] getData(){

        //Row stands for how many different data types test should run
        //Coloumn stands for how many values per each test
        Object[][] data = new Object[2][3];

        //0th row
        data[0][0]="nonrestricteduser@qw.com";
        data[0][1]="123456";
        data[0][2]="Non restricted User";

        //1st row
        data[1][0]="restricteduser@qw.com";
        data[1][1]="456789";
        data[1][2]="Restricted User";

        return data;
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }

}
