package step_definitions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import basics.First;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import selenium.execution.ExecutionHelper;

public class HomeSteps {

	private WebDriver driver;
//	public static String loggedInEmail;
//	public static String email;
//	public static String userName;
//	public static String password;
//	public static String passwordNew;
	final static Logger logger = Logger.getLogger(HomeSteps.class);

	public HomeSteps() {
		driver = Hooks.driver;
	}

	@Given("^User is on Home Page$")
	public void user_is_on_home_page() throws Throwable {
		driver.get("https://www.esferasoft.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.get(ExecutionHelper.url);

	}
	@And("^User enter email$")
	public void user_enter_email() throws Throwable {
		//First.

	}
}