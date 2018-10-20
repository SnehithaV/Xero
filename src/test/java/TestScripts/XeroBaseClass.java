package TestScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class XeroBaseClass {

	public static WebDriver driver = null;
	public static WebDriver initializeDriver(String name) {
		if(name.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./src/test/resources/Utility/geckodriver");
			driver = new FirefoxDriver();
		}
		else if(name.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/Utility/chromedriver2");
			driver = new ChromeDriver();
		}
		else if(name.equalsIgnoreCase("InternetExplorer")) {
			System.setProperty("webdriver.InternetExplorer.driver", "./src/test/resources/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		return driver;
		
	}
	public static void closeDriver() {
		driver.close();
	}
}
