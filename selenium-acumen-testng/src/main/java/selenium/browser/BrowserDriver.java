package selenium.browser;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;


public class BrowserDriver {

	public static WebDriver driver;

	final static Logger logger = Logger.getLogger(BrowserDriver.class);

	public static WebDriver launchBrowser(String browserType) {
		
		try {
			if (browserType.equals(Browsers.FIREFOX.getValue())) {
				driver = launchFirefox();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			} else if (browserType.equals(Browsers.IEXPLORER.getValue())) {
				driver = launchIE();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			} else if (browserType.equals(Browsers.CHROME.getValue())) {
				driver = launchChrome();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			} else {
				throw new SkipException("driver not started");
			}
			logger.info(browserType + " driver ready for testing");
		} catch (Exception ex) {
			logger.info(browserType + " driver not started", ex);
			throw new SkipException("driver not started");

		}
		return driver;
	}

	private static WebDriver launchFirefox() {
		File file = new File(".\\driver\\geckodriver.exe");
		// use marionette for older versions
		System.setProperty("webdriver.firefox.marionette", file.getAbsolutePath());
		//new version
		 System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;
	}

	private static WebDriver launchChrome() {
		WebDriver driver = null;
		File file = new File(".\\driver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
		
	}

	private static WebDriver launchIE() {
		WebDriver driver = null;
		File file = new File(".\\driver\\IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		return driver;
	}

}
