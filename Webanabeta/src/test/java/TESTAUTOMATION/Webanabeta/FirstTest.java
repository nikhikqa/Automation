package TESTAUTOMATION.Webanabeta;



import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
//		WebDriverManager.iedriver().setup();
//		WebDriver iedriv=new InternetExplorerDriver();
//		iedriv.get("https://www.google.com");
//		//iedriv.navigate().to("https://www.google.com");
//		WebDriverManager.firefoxdriver().setup();
//		WebDriver ffdriver=new FirefoxDriver();
		WebDriver driver=new ChromeDriver();
	

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		String url=driver.getCurrentUrl();
//		String pagesource=driver.getPageSource();
//		System.out.println(url);
//System.out.println(pagesource);
		driver.get("https://segra.customer360.cloudsmartz.net");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		ffdriver.get("https://vmanage.io/stream/");
//		ffdriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
//		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[6]/a")).click();
//		driver.findElement(By.linkText("Sign up")).click();
//		driver.findElement(By.id("reg_email")).sendKeys("nikhil_kumar111@esferasoft.com");	
//		driver.findElement(By.id("reg_name")).sendKeys("Nikhil Kumar");
//		driver.findElement(By.id("reg_pswd")).sendKeys("12345678");
//		driver.findElement(By.id("cnfrm_pswd")).sendKeys("12345678");
//
//		driver.findElement(By.name("terms_check")).click();
//		driver.findElement(By.id("btn-signup")).click();
//		WebElement signupsuccess= driver.findElement(By.className("confirm_success"));
//		System.out.println(signupsuccess);
//
//
//		System.out.println("This is done!");
//		driver.close();
		
		WebElement lgnbox= driver.findElement(By.name("USER_LOGIN"));
		lgnbox.clear();
		lgnbox.sendKeys("nikhil_kumar@esferasoft.com");
		
		WebElement pswdbox= driver.findElement(By.name("USER_PASSWORD"));
		pswdbox.clear();
		pswdbox.sendKeys("1oK7Ar");
		
		//driver.wait(1000);
		WebElement lgnbtn=driver.findElement(By.cssSelector("table.log-main-table:nth-child(1) td.log-main-cell div.log-popup-wrap div.log-popup form:nth-child(3) div.log-popup-footer:nth-child(5) > input.login-btn"));
		
		lgnbtn.click();
		driver.wait(5000);
		
		
		driver.findElement(By.id("pagetitle")).sendKeys(Keys.F5);
		//driver.wait(9000);
		
		
		
	
	}

}
