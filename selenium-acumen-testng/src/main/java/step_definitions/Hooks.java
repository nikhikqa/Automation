package step_definitions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.cucumber.listener.Reporter;

//import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import selenium.execution.ExecutionHelper;
import utilities.common.Common;
import utilities.common.ReadWritePropertiesFile;

public class Hooks {
	public static WebDriver driver;
	public static int count = 0;

	@Before
	public void openBrowser(Scenario scenario) {
		if (count < 1) {
			Reporter.setSystemInfo("user", System.getProperty("user.name"));
			Reporter.setSystemInfo("os", "Windows 8");
			Reporter.setSystemInfo("URL", ExecutionHelper.url);
			Reporter.setSystemInfo("Environment", ExecutionHelper.envn);
			Reporter.setSystemInfo("Build Version", "1.0.1");
			Reporter.setSystemInfo("App Build Version", "1.0.1");
			Reporter.loadXMLConfig(new File("src/main/resources/extent-config.xml"));
			count++;
		}
		Reporter.assignAuthor("Nitin");

		// To launch code in firefox browser
//		File file = new File(".\\driver\\geckodriver.exe");
//		System.setProperty("webdriver.firefox.marionette", file.getAbsolutePath());
//		driver = new FirefoxDriver();
		// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// To launch code in chrome browser
		File file = new File(".\\driver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		

//		 
//		 File file = new File(".\\driver\\IEDriverServer.exe");
//			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
//			 driver = new InternetExplorerDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}

	@After
	public void embedScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			String path = takeScreenShot();
			try {
				Reporter.addScreenCaptureFromPath(path);
			} catch (IOException e) {
			}
		}

		driver.quit();
	}

	private String takeScreenShot() {
		String methodName = "CloudSmartz";
		String filePath = "";
		String current = "";
		try {
			if (driver != null) {
				String d = Common.getCurrentDateTime();
				filePath = ".\\screenshots\\" + methodName + d + ".png";
				if (driver != null) {
					File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(scrFile, new File(filePath));
					
					current = ReadWritePropertiesFile.getIISProperty();
					filePath = Common.getFolderName(filePath);
					filePath = current + filePath;
				}
			}

		} catch (IOException e) {

		}
		return filePath;

	}

}