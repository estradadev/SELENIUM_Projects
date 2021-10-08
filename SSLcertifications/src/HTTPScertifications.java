import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HTTPScertifications {

    public static void main(String[] args) {
        //accept SSL certifications
        //this is for be able to work in Insecure web pages

        //SSl certificates

        //Desired capabilities
        //general chrome profile
        DesiredCapabilities ch = DesiredCapabilities.chrome();
        //ch.acceptInsecureCerts();//one way
        ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);//second way
        ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);//third way
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.merge(ch);

        System.setProperty("webdriver.chrome.driver","C:\\Users\\eadri\\Documents\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
        //to maximize the screen
        //ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(optionsChrome);

        driver.get("https://www.google.com/");



        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: " + e);
        }
        driver.quit();
    }

}
