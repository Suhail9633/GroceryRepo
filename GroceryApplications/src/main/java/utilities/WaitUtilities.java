package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {
	public void waitForWebElementText(WebDriver driver, String text , int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec)); // 5s
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(text)));
	}
	
	public void waitForWebElement(WebDriver driver, WebElement element , String attribute , String value ,int sec ) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec)); // 5s 
		wait.until(ExpectedConditions.attributeToBe(element, attribute,value));
	}

	public void waitForAlertIsPresent(WebDriver driver, int total) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(total))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.alertIsPresent());
	}
}
