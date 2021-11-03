import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.network.Network;
import org.openqa.selenium.devtools.v95.network.model.ConnectionType;

import java.util.Optional;

public class NetworkSpeed {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\eadri\\Documents\\SELENIUM_Projects\\chromedriver_win32\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        //Network.emulateNetworkConditions
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        devTools.send(Network.emulateNetworkConditions(false, 3000, 20000, 100000, Optional.of(ConnectionType.ETHERNET)));

        devTools.addListener(Network.loadingFailed(), loadingFailed->
        {
            System.out.println(loadingFailed.getErrorText());
            System.out.println(loadingFailed.getTimestamp());


        });
        long startTime = System.currentTimeMillis();
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
        driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
        String title =driver.findElement(By.cssSelector(".our-story-card-title")).getText();
        System.out.println(title);
//		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
//		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        driver.close();
        //14960  2054

        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: " + e);
        }
        driver.quit();
    }

}
