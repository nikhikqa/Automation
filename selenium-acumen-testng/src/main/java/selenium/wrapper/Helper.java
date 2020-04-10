package selenium.wrapper;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import junit.framework.Assert;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@SuppressWarnings("deprecation")
public class Helper {
	public Proxy proxy;


	public static void holdon(int sce) {
		try {
			Thread.sleep(sce * 1000);
		} catch (InterruptedException e) {
		}
	}

	public static void holdon(double time) {
		try {
			Thread.sleep((long) (time * 1000));
		} catch (InterruptedException e) {
		}
	}


	public static String getCurrentWindow(WebDriver driver) {
		return driver.getWindowHandle();

	}

	public static void handleWindows(WebDriver driver, String curWin) {

		ArrayList<String> windows = ArrayListWindowHandles(driver);
		for (String win : windows) {
			if (!win.equals(curWin)) {
				driver.switchTo().window(win);
				break;
			}
		}
	}

	public static void handleWindows(WebDriver driver, ArrayList<String> existWins) {

		ArrayList<String> windows = ArrayListWindowHandles(driver);
		for (String win : windows) {
			if (!existWins.contains(win)) {
				driver.switchTo().window(win);
				break;
			}
		}
	}

	public static ArrayList<String> ArrayListWindowHandles(WebDriver driver) {
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		return windows;

	}

	public static void switchToNewWindowJS(WebDriver driver, String URL) {
		driver.getWindowHandle();
		((JavascriptExecutor) driver).executeScript("window.open('" + URL + "')");
		Set<String> Windows = driver.getWindowHandles();
		String newTab = Windows.iterator().next();
		driver.switchTo().window(newTab);
	}

	public static void switchToNewWindow(WebDriver driver, String window) {
		driver.switchTo().window(window);
	}

	public static String pageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public static String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public static void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public static String getUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public static WebDriver getCurrentWebDriver(WebDriver driver) {
		return driver;
	}


	public static void waitForPageLoad(WebDriver driver) {
		String state = null;
		try {

			state = ((JavascriptExecutor) driver).executeScript("return document.readyState;").toString();

			if (state.equals("complete"))
				return;
			else {
				for (int second = 0;; second++) {
					if (second >= 180)
						Assert.fail("timeout");
					state = ((JavascriptExecutor) driver).executeScript("return document.readyState;").toString();
					if (state.equals("complete"))
						return;
					Thread.sleep(2000);

				}

			}

		} catch (InterruptedException e) {
		}
	}

	// public static void takeAScreenShotOfTheApp() throws AWTException,
	// IOException {
	// Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
	// Rectangle screenBounds = new Rectangle(0, 0, screenDim.width,
	// screenDim.height);
	//
	// Robot robot = new Robot();
	// BufferedImage image = robot.createScreenCapture(screenBounds);
	//
	// File screenshotFile = new File("image" + System.currentTimeMillis()
	// + ".png");
	// ImageIO.write(image, "png", screenshotFile);
	// }

	public static boolean verifyTextPresent(String value, WebDriver driver) {
		boolean textFound = driver.getPageSource().contains(value);
		if (textFound) {
			return true;
		} else {
			return false;
		}
	}

	

	public static void waitInSeconds(WebDriver driver,long waitValue) throws InterruptedException {
		driver.wait(waitValue);
	}

	public static void cancelAlert() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_F4);
			robot.keyRelease(KeyEvent.VK_F4);
			robot.keyRelease(KeyEvent.VK_ALT);
		} catch (AWTException e) {

		}
	}

	public static void reSizeFireFoxBrowser(int width, int height, WebDriver driver) throws InterruptedException {
		JavascriptExecutor scriptExecutor = (JavascriptExecutor) driver;
		scriptExecutor.executeScript("window.resizeTo(1024,768);");
		Thread.sleep(5000L);
	}

	public static void scrollEndOfPage(long scrollRange, WebDriver driver) throws InterruptedException {
		JavascriptExecutor scriptExecutor = (JavascriptExecutor) driver;
		scriptExecutor.executeScript("scrollTo(0,3000)");
		// ((JavascriptExecutor)driver).executeScript("scrollTo(0,scrollRange)");
		Thread.sleep(5000L);

	}

	public static void scrollMiddleOfPage(long scrollRange, WebDriver driver) throws InterruptedException {
		JavascriptExecutor scriptExecutor = (JavascriptExecutor) driver;
		scriptExecutor.executeScript("scrollTo(0,250)");
		// scriptExecutor.executeScript("scroll(0,250);");
		// scriptExecutor.executeScript("scrollTo(0,250)");
		// executeScript("scroll(0,250);");executeScript("scroll(0,250);");
		// ((JavascriptExecutor)driver).executeScript("scrollTo(0,scrollRange)");
		Thread.sleep(5000L);
	}

	public static void scrollBeginningOfPage(long scrollRange, WebDriver driver) throws InterruptedException {
		JavascriptExecutor scriptExecutor = (JavascriptExecutor) driver;
		scriptExecutor.executeScript("scrollTo(0,0)");
		// ((JavascriptExecutor)driver).executeScript("scrollTo(0,scrollRange)");
		Thread.sleep(5000L);
	}

	public static void scrollEndOfPage(WebDriver driver) throws InterruptedException {
		JavascriptExecutor scriptExecutor = (JavascriptExecutor) driver;
		scriptExecutor.executeScript("scrollTo(0,3000)");
		// ((JavascriptExecutor)driver).executeScript("scrollTo(0,scrollRange)");
		Thread.sleep(5000L);

	}

	public static void scrollToTopOfPage(WebDriver driver) throws InterruptedException {
		// driver.findElement(By.id("shell")).sendKeys(Keys.HOME);
		JavascriptExecutor scriptExecutor = (JavascriptExecutor) driver;
		scriptExecutor.executeScript("scrollTo(0,0)");
		// ((JavascriptExecutor)driver).executeScript("scrollTo(0,scrollRange)");
		Thread.sleep(5000L);
	}

	public static void scrollPageDown(WebDriver driver) throws InterruptedException {
		// driver.findElement(By.id("shell")).sendKeys(Keys.PAGE_DOWN);
		JavascriptExecutor scriptExecutor = (JavascriptExecutor) driver;
		scriptExecutor.executeScript("scrollTo(0,750)");
		// ((JavascriptExecutor)driver).executeScript("scrollTo(0,scrollRange)");
		Thread.sleep(5000L);

	}

	public static void scrollPageUp(WebDriver driver) throws InterruptedException {
		// driver.findElement(By.id("shell")).sendKeys(Keys.PAGE_DOWN);
		JavascriptExecutor scriptExecutor = (JavascriptExecutor) driver;
		scriptExecutor.executeScript("scrollTo(0,250)");
		// ((JavascriptExecutor)driver).executeScript("scrollTo(0,scrollRange)");
		Thread.sleep(5000L);

	}
	public static void Selectmultiple_checkbox(WebDriver driver) {
	List<WebElement> chk = driver.findElements(By.xpath(""));
	System.out.println(chk);
	Iterator<WebElement> itr = chk.iterator();
	while (itr.hasNext()) {
		if (!itr.next().isSelected())
			itr.next().click();
	}

}
}

