import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.*;

public class jdbcconection {

    public static void main(String[] args) throws SQLException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\eadri\\Documents\\SELENIUM_Projects\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/?locale=mx");

        String host = "localhost";
        String port = "3306";

        Connection con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/qadbt", "root", "Gu3rr3r0_J@gu@r");

        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("select * from credentials where scenario = 'asdererefa'");

        while (rs.next()) {
            driver.findElement(By.id("username")).sendKeys(rs.getString("username"));
            driver.findElement(By.id("password")).sendKeys(rs.getString("password"));
            //System.out.println(rs.getString("username"));
            //System.out.println(rs.getString("password"));
        }

        driver.findElement(By.id("Login")).click();

        /*
        rs.getString("username");
        rs.getString("password");*/

        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: " + e);
        }
        driver.quit();

    }

}