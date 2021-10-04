package automationDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Hello World");
		//indicamos la direccin del chromedriver, el driver para abrir un navegador Crhome
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\eduardo.estrada\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");//levantamos el servidor
		
		//Obciones de ejecución de chrome, caracteristicas a traves de banderas
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");//Se maximiza la pestaña de chrome
		
		//instanciamos nuestro navegador con seleniu
		WebDriver driver = new ChromeDriver(options); //por el echo de insanciarlo iniciamos una sesion
		//debe ser de la clase WebDriver porque la codumentacin asi lo dicta, la calse principal es WebDriver
		//se puede hacer de casi todos los navegadores; geckodriver (FireFox), OperaDriver (Opera)
		driver.get("http://demo.automationtesting.in/Register.html");//navegamos hacia la paguina
		//driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("ADRIAN");//primera automatizacion
		
		
		//funciones para la interaccion con la pagina Web
		writeInput(driver, "//input[@placeholder='First Name']", "ADRIAN");
		writeInput(driver, "//input[@placeholder='Last Name']", "CABALLERO");
		writeInput(driver, "//textarea[@ng-model='Adress']", "This is may adress");
		writeInput(driver, "//input[@ng-model='EmailAdress']", "adrian.caballero@mail.com");
		writeInput(driver, "//input[@ng-model='Phone']", "6732489210");
		clickInput(driver, "//input[@name='radiooptions' and @value='Male']");
		clickInput(driver, "//input[@type='checkbox' and @value='Movies']");
		clickInput(driver, "//multi-select");
		clickInput(driver, "//div[@id='msdd']//following::div//ul//li//a[contains(text(),'English')]");
		//clickInput(driver,"//a[@class='ui-corner-all' and contains(text(),'English')]");
		selecOption(driver, "//select[@ng-model='Skill']", "Java");
		selecOption(driver, "//select[@ng-model='country']", "Mexico");
		//selecOption(driver, "//select[@id='country']", "Japan");//primera opcion
		clickInput(driver, "//select[@id='country']//option[@value='Japan']");//segunda forma
		selecOption(driver, "//select[@placeholder='Year']", "2001");
		selecOption(driver, "//select[@placeholder='Month']", "February");
		selecOption(driver, "//select[@placeholder='Day']", "1");
		writeInput(driver, "//input[@id=\"firstpassword\"]", "DO98ed@fsa078");
		writeInput(driver, "//input[@id=\"secondpassword\"]", "DO98ed@fsa078");
		uploadFile(driver, "//input[@type='file']","C:\\Users\\eduardo.estrada\\Documents\\Selenium\\foto.jpg");
		
		
		//como regla de java los sleeps se usan con try-cath para manejar posibles errores
		try {
			Thread.sleep(1000);//es el tiempo que nuestra sesions estara abierta
		} 
		catch (InterruptedException e) {
			e.printStackTrace();//imprime un error si es que encuantra alguno
		}
		
		driver.quit();//cerramos nuestra sesion

	}
	
	
	public static void writeInput(WebDriver driver, String xPath, String textInput){
		//driver.findElement(By.xpath(xPath)).sendKeys(textInput);
		WebElement element; // = driver.findElement(By.xpath(xPath));
		
		try {
			element = driver.findElement(By.xpath(xPath));
			element.sendKeys(textInput);
		}
		catch (Exception e) {
			System.out.println("XPhat not found " + xPath);
			System.out.println(e);
			driver.quit();
		}
		
	}
	
	public static void clickInput(WebDriver driver, String xPath){
		WebElement element;
		
		try {
			element = driver.findElement(By.xpath(xPath));
			element.click();
		}
		catch (Exception e) {
			System.out.println("XPhat not found " + xPath);
			System.out.println(e);
			driver.quit();
		}
		
	}
	
	public static void selecOption(WebDriver driver, String xPath, String optionSelected){	
		Select select;
		
		try {
			select = new Select(driver.findElement(By.xpath(xPath)));
			select.selectByValue(optionSelected);
		}
		catch (Exception e) {
			System.out.println("XPhat not found " + xPath);
			System.out.println(e);
			driver.quit();
		}
		
	}
	
	public static void uploadFile(WebDriver driver, String xPath, String fileAddress){
		WebElement element; // = driver.findElement(By.xpath(xPath));
		
		try {
			element = driver.findElement(By.xpath(xPath));
			element.sendKeys(fileAddress);
		}
		catch (Exception e) {
			System.out.println("XPhat not found " + xPath);
			System.out.println(e);
			driver.quit();
		}
		
	}

}
