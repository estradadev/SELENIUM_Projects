import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import java.sql.Driver;
import java.util.HashMap;
import java.util.Map;

public class CDPComandsTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\eadri\\Documents\\SELENIUM_Projects\\chromedriver_win32\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        Map<String, Object> deviceMetrics = new HashMap<String, Object>();
        deviceMetrics.put("width",600);
        deviceMetrics.put("height",1000);
        deviceMetrics.put("deviceScaleFactor",50);
        deviceMetrics.put("mobile",true);

        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");

        driver.findElement(By.linkText("Library")).click();


        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: " + e);
        }
        driver.quit();
    }

}
