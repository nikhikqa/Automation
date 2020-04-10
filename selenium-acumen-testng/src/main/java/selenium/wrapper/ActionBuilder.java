package selenium.wrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionBuilder {
	
	public static void mouseHoverOnElement(WebDriver driver, By by) {
		Actions action = new Actions(driver);
		WebElement element = Wrapper.findWebElement(driver, by);
		action.moveToElement(element).build().perform();

	}

}
