package TESTAUTOMATION.Webanabeta;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CloseandQuit {

	public static void main(String[] args) {
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
