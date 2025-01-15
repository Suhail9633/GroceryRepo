package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsMenu {
	WebDriver driver;

	public SettingsMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@style='display: block;']//li[1]")
	WebElement changePasswordButton;
	@FindBy(xpath = "//ul[@style='display: block;']//li[2]")
	WebElement manageMenuButton;
	@FindBy(xpath = "//ul[@style='display: block;']//li[3]")
	WebElement logOutButton;

	public void logOut() {
		logOutButton.click();
		
	}
}
