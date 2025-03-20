package aparikh.blissworld.testcomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	//public LandingPage landingPage;
	

	public WebDriver initializeDriver() throws IOException {
		// properties class
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//java//resources//GlobalData.properties");
		prop.load(fis);

		String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);

		} else if (browserName.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.gecko.driver", "/Users/rahulshetty//documents//geckodriver");
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {
			//System.setProperty("webdriver.edge.driver", "edge.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		return driver;
	}

}
