package TESTAUTOMATION.Webanabeta;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CloseandQuit {

	@Test
	public  void set() {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver chromedriver=new ChromeDriver();
		chromedriver.manage().deleteAllCookies();
		chromedriver.manage().window().maximize();
		chromedriver.get("https://www.google.com");
		chromedriver.navigate().to("https://www.bing.com");
		chromedriver.navigate().back();
			
		
		//chromedriver.close();
		chromedriver.quit();

	}

}
