import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import java.net.URI;
import java.util.function.Predicate;

public class BasicAuthentication {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\eadri\\Documents\\SELENIUM_Projects\\chromedriver_win32\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();

        Predicate<URI> uriPredicate = uri ->  uri.getHost().contains("httpbin.org");

        ((HasAuthentication)driver).register(uriPredicate, UsernameAndPassword.of("foo", "bar"));
        driver.get("http://httpbin.org/basic-auth/foo/bar");

        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: " + e);
        }
        driver.quit();
    }

}
