import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalValuesDrive {
	
	public static void main(String[] args) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\eduardo.estrada\\OneDrive - Softtek\\Documents\\UDEMY\\SELENIUM_Projects\\GlobalEnvironmental\\src\\data.properties");
		
		prop.load(fis);
		
		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("url"));
		
		//Change the browser in run time
		prop.setProperty("browser", "firefox");
		
		System.out.println(prop.getProperty("browser"));
		
		//Writing back the browser in data.properties
		FileOutputStream fos = new FileOutputStream("C:\\Users\\eduardo.estrada\\OneDrive - Softtek\\Documents\\UDEMY\\SELENIUM_Projects\\GlobalEnvironmental\\src\\data.properties");
		
		prop.store(fos, null);
		
	}

}
