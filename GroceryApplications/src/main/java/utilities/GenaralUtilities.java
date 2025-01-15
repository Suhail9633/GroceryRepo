package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GenaralUtilities {
	
	public String getElementText(WebElement element) {
		return element.getText();
	}

	public boolean isSlected(WebElement element) {
		return element.isSelected();
	}

	public boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public boolean isEnabled(WebElement element) {
		return element.isEnabled();
	}

	public void selectValueFromDropdown(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
	}
	
	public void getFirstSelectedOption(WebElement element) {
		Select object = new Select(element);
		object.getFirstSelectedOption();
	}

	public void selectDropdownWithIndex(WebElement element, int indexNumber) {
		Select object = new Select(element);
		object.selectByIndex(indexNumber);
	}

	public void selectDropdownWithVisibleText(WebElement element, String text) {
		Select object = new Select(element);
		object.selectByVisibleText(text);
	}

	public void sendKeyFunction(WebElement element, String inputValue) {
		element.sendKeys(inputValue);
	}

	public void DragAndDrop(WebDriver driver, WebElement sourceElement, WebElement targetElement) {
		Actions actObject = new Actions(driver);
		actObject.dragAndDrop(sourceElement, targetElement).perform();
	}

	public void fileUploadUsingSendKeysFunction(WebElement element, String path) {
		element.sendKeys(path);
	}

	public void fileUploadUsingRobotClass(WebElement element, String path) throws AWTException {
		StringSelection ss = new StringSelection("path");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.delay(500);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(500);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void doubleClickFunction(WebElement element, WebDriver driver) {
		Actions actobject = new Actions(driver);
		actobject.doubleClick(element).perform();
	}

	public void rightClickFunction(WebElement element, WebDriver driver) {
		Actions actobject = new Actions(driver);
		actobject.contextClick(element).perform();
	}

	public void mouseHoveringFunction(WebElement element, WebDriver driver) {
		Actions actobject = new Actions(driver);
		actobject.moveToElement(element).perform();
	}

	public String selectVaueFromDynamicTable(List<WebElement> listOfRow, String Value, String locator) {
		String elementLocator = null;
		for (int i = 0; i < listOfRow.size(); i++) {
			if (listOfRow.get(i).getText().equals(Value)) {
				elementLocator = locator;
				break;
			}
		}
		return elementLocator;
	}

	public String getTitleOfPage(WebDriver driver) {
		return driver.getTitle();
	}
	

	public String getCurrentUrlOfPage(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void pageScroll(int horizontal, int vertical, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + horizontal + "," + vertical + ")", "");
	}

//	public void clickJavaScriptExecutor(WebElement element, WebDriver driver) {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeAsyncScript("argument[0].click()", element);
//	}
	
	public void clickJavaScriptExecutor(WebElement element, WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public String getCSSValueOfElement(WebElement element, String parameter) {
		return element.getCssValue(parameter);
	}

	public void mediumDelay() throws InterruptedException {
		Thread.sleep(2000);
	}

	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void alertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void switchToFrameByName(WebDriver driver, String name) {
		driver.switchTo().frame(name);
	}

	public void switchToFrameByWebElement(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	public String generateCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
		return formatter.format(date);
	}

	public int randon(int limit) {
		Random random = new Random();
		// int limit = 1000;
		int randomNumber = random.nextInt(limit);
		return randomNumber;
	}

	public void sendValueUsingJavaScript(WebDriver driver, WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '" + value + "'", element);
	}

	public void blurThePlaceHolder(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].blur()", element);
	}
}

