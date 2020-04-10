package selenium.wrapper;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.SkipException;



/**
 * @author amit.kapilas
 */
public class Wrapper {

	public static String getElementText(WebElement element) {
		return element.getText();
	}

	public static String getElementText(WebDriver driver, By by) {
		return driver.findElement(by).getText();
	}

	public static String getElementText(WebDriver driver, String by) {
		return driver.findElement(By.cssSelector(by)).getText();
	}

	public static String getElementText(WebDriver driver, String by, Locators loc) {
		return findWebElement(driver, by, loc).getText();
	}

	public static boolean isElementEnabled(WebDriver driver, By by) {
		boolean flag = driver.findElement(by).isEnabled();
		return flag;
	}

	public static boolean isElementEnabled(WebDriver driver, String by) {
		return driver.findElement(By.cssSelector(by)).isEnabled();
	}

	public static boolean isElementEnabled(WebDriver driver, String by, Locators loc) {
		return findWebElement(driver, by, loc).isEnabled();
	}

	public static boolean isElementDisplayed(WebDriver driver, By by) {
		boolean flag = driver.findElement(by).isDisplayed();
		return flag;
	}

	public static boolean isElementDisplayed(WebDriver driver, String by) {
		return driver.findElement(By.cssSelector(by)).isDisplayed();
	}

	public static boolean isElementDisplayed(WebDriver driver, String by, Locators loc) {
		return findWebElement(driver, by, loc).isDisplayed();
	}

	public static boolean isElementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static boolean isElementPresent(WebDriver driver, String by) {
		try {
			driver.findElement(By.cssSelector(by));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static boolean isElementPresent(WebDriver driver, String by, Locators loc) {
		try {
			findWebElement(driver, by, loc);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static boolean isElementSelected(WebDriver driver, By by) {
		return driver.findElement(by).isSelected();
	}

	public static boolean isElementSelected(WebDriver driver, String by) {
		return driver.findElement(By.cssSelector(by)).isSelected();
	}

	public static boolean isElementSelected(WebDriver driver, String by, Locators loc) {
		return driver.findElement(By.cssSelector(by)).isSelected();
	}

	public static String getElementAttribute(WebDriver driver, By by, String attr) {
		return driver.findElement(by).getAttribute(attr);
	}

	public static String getElementAttribute(WebDriver driver, String by, String attr) {

		return driver.findElement(By.cssSelector(by)).getAttribute(attr);
	}

	public static String getElementAttribute(WebDriver driver, String by, Locators loc, String attr) {
		String text = "";
		boolean flag = isElementDisplayed(driver, by, loc);
		if (flag)
			text = findWebElement(driver, by, loc).getAttribute(attr);
		else
			throw new NoSuchElementException(by);
		return text;
	}

	public static String getElementTagName(WebDriver driver, By by) {
		return driver.findElement(by).getTagName();
	}

	public static String getElementTagName(WebDriver driver, String by) {
		return driver.findElement(By.cssSelector(by)).getTagName();
	}

	public static String getElementTagName(WebDriver driver, By by, Locators loc) {
		return driver.findElement(by).getTagName();
	}


	public static void clickElement(WebDriver driver, By by) {
		driver.findElement(by).click();

	}

	public static void clickElement(WebDriver driver, String by) {
		driver.findElement(By.cssSelector(by)).click();

	}
	
	public static void clickElement(WebDriver driver, By by, int sec) {
		explicitWaitForElementToBeClickable(driver, by, sec);
		driver.findElement(by).click();

	}

	public static void clickElement(WebDriver driver, String by, int sec) {
		explicitWaitForElementToBeClickable(driver, by, sec);
		driver.findElement(By.cssSelector(by)).click();

	}

	public static void clickElement(WebDriver driver, String by, Locators loc) {
		findWebElement(driver, by, loc).click();

	}


	public static void clickElementAndWait(WebDriver driver, By by) {
		boolean success = false;
		boolean web = false;
		for (int i = 0; i < 6; i++) {
			if (success)
				break;
			try {
				if (i == 0) {
					driver.findElement(by).click();
					Helper.holdon(2);
					success = true;
				}
				if (web) {
					if (i == 1) {
						Actions action = new Actions(driver);
						action.moveToElement(driver.findElement(by)).click().perform();
						Helper.holdon(2);
						success = true;
					}
					if (i == 2) {
						WebElement element = driver.findElement(by);
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("window.scrollTo(0," + element.getLocation().y + ")");
						element.click();
						Helper.holdon(2);
						success = true;
					}
					if (i == 3) {
						WebElement element = driver.findElement(by);
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("window.scrollTo(0," + element.getLocation().x + ")");
						element.click();
						Helper.holdon(2);
						success = true;
					}
					if (i == 4) {
						WebElement element = driver.findElement(by);
						JavascriptExecutor jse = (JavascriptExecutor) driver;
						jse.executeScript("arguments[0].scrollIntoView()", element);
						element.click();
						Helper.holdon(2);
						success = true;
					}
					if (i == 5) {
						WebElement element = driver.findElement(by);
						Actions actions = new Actions(driver);
						actions.moveToElement(element).click().perform();
						Helper.holdon(2);
						success = true;
					}

				}
			} catch (StaleElementReferenceException ex) {
				if (i == 6 - 1)
					throw ex;
				Helper.holdon(10);
			} catch (WebDriverException ex) {
				web = true;
				Helper.holdon(10);
			} catch (Exception ex) {
				Helper.holdon(10);
			}
		}
	}

	// public static void clickElementAndWait(WebDriver driver, By by) {
	// findWebElement(driver, by).click();
	// Helper.holdon(2);
	// }

	

	public static void clickElementAndWait(WebElement e) {
		e.click();
		Helper.holdon(2);
	}

	public static void clickElementAndWait(WebDriver driver, String by) {
		clickElement(driver, by);
		Helper.holdon(2);
	}

	public static void clickElementAndWait(WebDriver driver, String by, Locators loc) {
		clickElement(driver, by);
		Helper.holdon(2);
	}

	public static void clickElementAndWait(WebDriver driver, String by, int sec) {
		explicitWaitForElementToBeClickable(driver, by, sec);
		clickElement(driver, by);
		Helper.holdon(2);
	}

	public static void clickElementAndWait(WebDriver driver, By by, int sec) {
		explicitWaitForElementToBeClickable(driver, by, sec);
		clickElement(driver, by);
		Helper.holdon(2);
	}

	public static void clickElementAndWait(WebDriver driver, String by, Locators loc, int sec) {
		clickElement(driver, by);
		Helper.holdon(sec);
	}

	public static void enterValueInTextBox(WebDriver driver, By by, String descTextToBeEntered) {
		
		clickElement(driver, by);
		clearField(driver, by);
		enterValue(driver, by, descTextToBeEntered);
	}

	public static void enterValueInTextBox(WebDriver driver, String by, String descTextToBeEntered) {
	
		clickElement(driver, by);
		clearField(driver, by);
		enterValue(driver, by, descTextToBeEntered);
	}
	public static void enterValueInTextBox(WebDriver driver, By by, String descTextToBeEntered,  int sec) {
		explicitWaitForElementToBeClickable(driver, by, sec);
		clickElement(driver, by);
		clearField(driver, by);
		enterValue(driver, by, descTextToBeEntered);
	}

	public static void enterValueInTextBox(WebDriver driver, String by, String descTextToBeEntered, int sec) {
		explicitWaitForElementToBeClickable(driver, by, sec);
		clearField(driver, by);
		enterValue(driver, by, descTextToBeEntered);
	}
	

	public static String enterValueInTextBoxAndGetID(WebDriver driver, By by, String descTextToBeEntered) {
		clearField(driver, by);
		enterValue(driver, by, descTextToBeEntered);
		String id = driver.findElement(by).getAttribute("value").toString();
		return id;
	}

	public static void enterValue(WebDriver driver, By by, String descTextToBeEntered) {
		driver.findElement(by).sendKeys(descTextToBeEntered);

	}

	public static void enterValue(WebDriver driver, String by, String descTextToBeEntered) {
		driver.findElement(By.cssSelector(by)).sendKeys(descTextToBeEntered);

	}

	public static String getTextByAttrValue(WebDriver driver, By by) {
		String text = driver.findElement(by).getAttribute("value").toString();
		return text;
	}

	public static String getTextByAttrValue(WebDriver driver, String by) {
		String text = driver.findElement(By.cssSelector(by)).getAttribute("value").toString();
		return text;
	}

	public static String getTextByAttrValue(WebDriver driver, String by, Locators loc) {
		String text = findWebElement(driver, by, loc).getAttribute("value").toString();
		return text;
	}

	public static void clearField(WebDriver driver, By by) {
		driver.findElement(by).clear();

	}

	public static void clearField(WebDriver driver, String by) {
		driver.findElement(By.cssSelector(by)).clear();

	}

	public static void clearField(WebDriver driver, String by, Locators loc) {
		findWebElement(driver, by, loc).clear();

	}

	 public static WebElement findWebElement(WebDriver driver, By by) {
	
	 return driver.findElement(by);
	 }

	 public static WebElement findWebElement(WebDriver driver, String by) {
	 WebElement element = null;
	 try {
	 element = driver.findElement(By.cssSelector(by));
	 } catch (NoSuchElementException e) {
	 throw e;
	 }
	 return element;
	 }

	public static WebElement findWebElement(WebDriver driver, String by, Locators loc) {
		WebElement element = null;
		try {
			if (loc.equals(Locators.ID))
				element = driver.findElement(By.id(by));
			else if (loc.equals(Locators.CSS_SELECTOR))
				element = driver.findElement(By.cssSelector(by));
			else if (loc.equals(Locators.CLASS_NAME))
				element = driver.findElement(By.className(by));
			else if (loc.equals(Locators.NAME))
				element = driver.findElement(By.name(by));
			else if (loc.equals(Locators.TAG_NAME))
				element = driver.findElement(By.tagName(by));
			else if (loc.equals(Locators.lINK_TEXT))
				element = driver.findElement(By.linkText(by));
			else if (loc.equals(Locators.PARTICAL_LINK_TEXT))
				element = driver.findElement(By.partialLinkText(by));
			else if (loc.equals(Locators.XPATH))
				element = driver.findElement(By.xpath(by));
		} catch (NoSuchElementException e) {
			throw e;
		}
		return element;
	}

	public static List<WebElement> findWebElements(WebDriver driver, By by) {
		return driver.findElements(by);
	}

	public static List<WebElement> findWebElements(WebDriver driver, String by) {
		return driver.findElements(By.cssSelector(by));
	}

	public static List<WebElement> findWebElements(WebDriver driver, String by, Locators loc) {
		try {
			if (loc.equals(Locators.ID))
				return driver.findElements(By.id(by));
			else if (loc.equals(Locators.CSS_SELECTOR))
				return driver.findElements(By.cssSelector(by));
			else if (loc.equals(Locators.CLASS_NAME))
				return driver.findElements(By.className(by));
			else if (loc.equals(Locators.NAME))
				return driver.findElements(By.name(by));
			else if (loc.equals(Locators.TAG_NAME))
				return driver.findElements(By.tagName(by));
			else if (loc.equals(Locators.lINK_TEXT))
				return driver.findElements(By.linkText(by));
			else if (loc.equals(Locators.PARTICAL_LINK_TEXT))
				return driver.findElements(By.partialLinkText(by));
			else if (loc.equals(Locators.XPATH))
				return driver.findElements(By.xpath(by));
		} catch (NoSuchElementException e) {
			throw e;
		}
		return null;
	}

	public static String clickElementAndGetNotification(WebDriver driver, By by) {
		clickElement(driver, by);
		String text = "";
		By vby = By.cssSelector(".ngn.ng-scope");
		explicitWaitForElementVisibility(driver, vby, 180);
		if (isElementDisplayed(driver, vby))
			for (int i = 0; i < 100; i++) {
				text = driver.findElement(vby).getText();
				if (!text.isEmpty())
					break;
				else {
					Helper.holdon(.1);
				}
			}
		Helper.holdon(5);
		return text;

	}

	public static String clickElementAndCheckIsNotificationPresent(WebDriver driver, By by) {
		clickElement(driver, by);
		String text = "";
		try {
			By vby = By.cssSelector(".ngn.ng-scope");
			explicitWaitForElementVisibility(driver, vby, 30);
			if (isElementDisplayed(driver, vby))
				for (int i = 0; i < 100; i++) {
					text = driver.findElement(vby).getText();
					if (!text.isEmpty())
						break;
					else {
						Helper.holdon(.1);
					}
				}
			Helper.holdon(5);
		} catch (Exception e) {
			text = "";
		}
		return text;

	}

	public static String clickElementAndGetNotification(WebDriver driver, String by) {
		clickElement(driver, by);
		String text = Wrapper.waitForElementAndGetInnerText(driver, By.cssSelector(by), 180);
		return text;

	}

	public static String isNotificationPresent(WebDriver driver) {

		String text = "";
		try {
			By vby = By.cssSelector(".ngn.ng-scope");
			explicitWaitForElementVisibility(driver, vby, 30);
			if (isElementDisplayed(driver, vby))
				for (int i = 0; i < 100; i++) {
					text = driver.findElement(vby).getText();
					if (!text.isEmpty())
						break;
					else {
						Helper.holdon(.1);
					}
				}
			Helper.holdon(5);
		} catch (Exception e) {
			text = "";
		}
		return text;

	}

	public static void waitForElement(WebDriver driver, By by) {
		try {
			for (int second = 0;; second++) {
				if (second >= 180)
					throw new SkipException("timeout");
				if (isElementPresent(driver, by))
					break;
				else
					Helper.holdon(1);
			}
		} catch (NoSuchElementException e) {
			throw e;
		}

	}

	public static void waitForElementToDisappear(WebDriver driver, By by) {
		try {
			for (int second = 0;; second++) {
				if (second >= 240)
					throw new SkipException("timeout");

				if (isElementDisplayed(driver, by))
					Helper.holdon(1);
				else
					break;
			}

		} catch (NoSuchElementException e) {

		}

	}

	public static void waitForElementUntilGetText(WebDriver driver, By by) {
		try {
			for (int second = 0;; second++) {
				if (second >= 180)
					throw new SkipException("timeout");
				String text = getElementText(driver, by);
				if (!text.isEmpty())
					break;
				else
					Helper.holdon(1);
			}
		} catch (NoSuchElementException e) {
			throw e;
		}

	}

	public static void waitForModalActive(WebDriver driver, By by) {
		try {
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			for (int itration = 0;; itration++) {
				if (itration >= 180)
					throw new IllegalArgumentException("timeout");
				boolean flag = isElementDisplayed(driver, by);
				if (flag)
					Helper.holdon(1);
				else
					break;
			}
		} catch (NoSuchElementException e) {

		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public static void waitForPageActive(WebDriver driver, By by) {
		try {
			explicitWaitForElementToBeClickable(driver, by, 180);
		} catch (NoSuchElementException e) {
			throw new SkipException("timeout");
		}

	}

	public static void waitForPageActive(WebDriver driver, By by, int sec) {
		try {
			explicitWaitForElementToBeClickable(driver, by, sec);
		} catch (NoSuchElementException e) {
			throw new SkipException("timeout");
		}

	}

	public static String waitForElementAndGetInnerText(WebDriver driver, By by, int sec) {
		String text = "";
		explicitWaitForElementToBeClickable(driver, by, sec);
		if (isElementDisplayed(driver, by))
			text = driver.findElement(by).getText();

		return text;

	}

	public static String waitForElementAndGetInnerText(WebDriver driver, By by) {
		String text = "";
		explicitWaitForElementVisibility(driver, by, 180);
		if (isElementDisplayed(driver, by))
			for (int i = 0; i < 100; i++) {
				text = driver.findElement(by).getText();
				if (!text.isEmpty())
					break;
				else {
					Helper.holdon(.1);
				}
			}
		return text;

	}

	public static String waitForElementAndGetInnerText(WebDriver driver, By by, String s, int sec) {
		String text = "";
		Wrapper.explicitWaitForTextToBePresent(driver, by, s, sec);
		if (isElementDisplayed(driver, by))
			text = driver.findElement(by).getText();

		return text;

	}

	public static void pressEnter(WebDriver driver, By by) {
		WebElement element = driver.findElement(by);

		if (driver instanceof InternetExplorerDriver) {
			element.sendKeys(Keys.ENTER);
		} else {
			element.click();
		}
	}

	public static void deselectDropdown(WebDriver driver, By by) {
		Select selectObj = new Select(driver.findElement(by));
		selectObj.deselectAll();

	}

	public static List<WebElement> getDropdownOptions(WebDriver driver, By by) {
		List<WebElement> ar = null;
		Select selectObj = new Select(driver.findElement(by));
		ar = selectObj.getOptions();
		return ar;

	}

	public static String getDropdownTextOfSelectedItemByValue(WebDriver driver, By by) {
		String textToRet = "";
		Select selectField = new Select(driver.findElement(by));
		textToRet = selectField.getFirstSelectedOption().getAttribute("value");
		return textToRet;
	}

	public static ArrayList<String> getDropdownTextAndValueOfSelectedItem(WebDriver driver, By by) {
		ArrayList<String> arr = new ArrayList<String>();
		Select selectField = new Select(driver.findElement(by));
		arr.add(selectField.getFirstSelectedOption().getText().toString());
//		arr.add(Common
//				.getTextFromArrayListByIndex(selectField.getFirstSelectedOption().getAttribute("value").toString(), 1));
		return arr;
	}

	public static String selectDropdownByVisibleTextAndGetValue(WebDriver driver, By by, String selection) {
		String textToRet = "";
		Select selectField = new Select(driver.findElement(by));
		selectField.selectByVisibleText(selection.trim());
		textToRet = selectField.getFirstSelectedOption().getAttribute("value");
		return textToRet;
	}

	public static String getDropdownTextOfSelectedItem(WebDriver driver, By by) {
		String textToRet = "";
		Select selectField = new Select(driver.findElement(by));
		textToRet = selectField.getFirstSelectedOption().getText();
		return textToRet;
	}

	public static void selectDropdownByValue(WebDriver driver, By by, String selection) {
		Select selectField = new Select(driver.findElement(by));
		selectField.selectByValue(selection);

	}

	public static void selectDropdownByIndex(WebDriver driver, By by, int selectionIndex) {
		Select selectField = new Select(driver.findElement(by));
		selectField.selectByIndex(selectionIndex);
	}

	public static void selectDropdownByVisibleText(WebDriver driver, By by, String selection) {
		Select selectField = new Select(driver.findElement(by));
		selectField.selectByVisibleText(selection.trim());

	}
	
	public static void selectOptionFromKendoDropdown(WebDriver driver, By dd, By ddOptsLi, String selection) {
		WebElement dropdown = findWebElement(driver, dd);
		dropdown.click();
		Helper.holdon(1);
		List<WebElement> options = findWebElements(driver, ddOptsLi);
		for (Iterator<WebElement> iterator = options.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			if (webElement.getText().equals(selection)) {
				webElement.click();
				break;
			}
		}
	}

	// public static void selectOptFrmKendoDropdown(WebDriver driver, By dd, By
	// ddOptsLi, String selection) {
	// WebElement dropdown = driver.findElement(dd);
	// dropdown.click();
	// List<WebElement> options = findWebElements(driver, ddOptsLi);
	// for (Iterator<WebElement> iterator = options.iterator();
	// iterator.hasNext();) {
	// WebElement webElement = (WebElement) iterator.next();
	// if (webElement.getText().equals(selection)) {
	// webElement.click();
	// break;
	// }
	// }
	// }
	//
	// public static void selectMultiOptsFrmKendoDropdown(WebDriver driver, By
	// dd, By ddOptsLi,
	// ArrayList<String> selection) {
	// WebElement dropdown = findWebElement(driver, dd);
	// List<WebElement> options = findWebElements(driver, ddOptsLi);
	// for (Iterator<WebElement> iterator = options.iterator();
	// iterator.hasNext();) {
	// Helper.holdon(1);
	// dropdown.click();
	// Helper.holdon(1);
	// WebElement webElement = (WebElement) iterator.next();
	// if (selection.contains(webElement.getText())) {
	// webElement.click();
	// Helper.holdon(1);
	// }
	//
	// }
	//
	// }

	public static String getImageLink(WebDriver driver, By by) {
		return driver.findElement(by).getAttribute("href");

	}

	public static String getImageLink(WebDriver driver, String by) {
		return driver.findElement(By.cssSelector(by)).getAttribute("href");

	}

	public static String getImageLink(WebDriver driver, String by, Locators loc) {
		return findWebElement(driver, by, loc).getAttribute("href");

	}

	public static String getImageSource(WebDriver driver, By by) {
		return driver.findElement(by).getAttribute("src");

	}

	public static String getImageSource(WebDriver driver, String by) {
		return driver.findElement(By.cssSelector(by)).getAttribute("src");

	}

	public static String getImageSource(WebDriver driver, String by, Locators loc) {
		return findWebElement(driver, by, loc).getAttribute("src");

	}

	public static void explicitWaitForElementToBeClickable(WebDriver driver, By by, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	@SuppressWarnings("deprecation")
	public static void explicitWaitForTextToBePresent(WebDriver driver, By by, String s, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.textToBePresentInElement(by, s));
	}

	public static void explicitWaitForElementInvisibility(WebDriver driver, By by, String s, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	public static void explicitWaitForElementToBeSelected(WebDriver driver, By by, String s, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.elementToBeSelected(by));
	}

	public static void explicitWaitForElementToBeClickable(WebDriver driver, String by, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(by)));
	}

	public static void explicitWaitForElementVisibility(WebDriver driver, By by, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public static void waitForAlert(WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.alertIsPresent());
		} catch (NoAlertPresentException ex) {
		}
	}

	public static boolean isAlertPresent(WebDriver driver) {
		boolean flag = false;
		try {
			driver.switchTo().alert();
			flag = true;
		} catch (NoAlertPresentException ex) {
			flag = false;
		}
		return flag;
	}

	public static void WaitAndAcceptAlert(WebDriver driver) {
		try {
			waitForAlert(driver);
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException ex) {
		}
	}

	public static void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public static void dismissAlert(WebDriver driver, String window) {
		driver.switchTo().alert().dismiss();
	}

}
