package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class UploadFile {

    public static void main(String[] args) throws IOException {

        String downloadPth = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\eadri\\Documents\\SELENIUM_Projects\\chromedriver_win32\\chromedriver.exe");

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

        chromePrefs.put("profile.default_content_settings.popups", 0);

        chromePrefs.put("download.default_directory", downloadPth);

        //to maximize the screen
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("--start-maximized");
        optionsChrome.setExperimentalOption("prefs", chromePrefs);
        WebDriver driver = new ChromeDriver(optionsChrome);

        driver.get("https://www.ilovepdf.com/es/pdf_a_word");

        driver.findElement(By.id("pickfiles")).click();

        // C:\Users\eadri\Downloads\CitaTramite.pdf
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: " + e);
        }

        //uploading file with AutoIt
        // C:\\Users\eadri\Documents\SELENIUM_Projects\WindowPopUp\fileUpload.exe
        Runtime.getRuntime().exec("C:\\Users\\eadri\\Documents\\SELENIUM_Projects\\WindowPopUp\\fileUpload.exe");

        driver.findElement(By.id("processTask")).click();

        //check if file is downloaded
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pickfiles")));

        driver.findElement(By.id("pickfiles")).click();

        File f = new File(downloadPth + "/CitaTramite.zip");
        if (f.exists()){
            System.out.println("File Downloaded");
            Assert.assertTrue(f.exists());
            if(f.delete())

                System.out.println("file deleted");

        }
        }



        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            System.out.printf("We have a Problem: " + e);
        }
        driver.quit();
    }

}
