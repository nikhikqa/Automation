package basics;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import or.Homeelements;
import selenium.wrapper.Wrapper;

public class First {
	static String expected_title = "Best Website Design &  Company in Mohali India";
	static String Captch_alert1 = "Captcha code not correct, try agai";
	
	public static void main(String[] args) throws InterruptedException {
		File file = new File(".\\driver\\geckodriver.exe");
		System.setProperty("webdriver.firefox.marionette", file.getAbsolutePath());
	
		WebDriver driver= new FirefoxDriver();
driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

// write code here 
		driver.get("https://www.softobiz.com/career/");
		String pagetitle = driver.getTitle();

		System.out.println(pagetitle);

		driver.findElement(By.cssSelector("#top-menu-2 ul li:nth-of-type(3)")).click();

	}
}
//	}
