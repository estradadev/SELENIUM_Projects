package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class UploadFile {

    public static void main(String[] args) throws IOException {


        System.setProperty("webdriver.chrome.driver","C:\\Users\\eadri\\Documents\\SELENIUM_Projects\\chromedriver_win32\\chromedriver.exe");
        //to maximize the screen
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("--start-maximized");
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

        File f = new File("C:\\Users\\eadri\\Downloads\\CitaTramite.docx");
        if (f.exists()){
            System.out.println("File Downloaded");
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
