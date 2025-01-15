package elementRepository;

import java.io.IOException;

// Java Class

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // with pageFactory
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement userNameField;
	@FindBy(name = "password")
	WebElement passwordField;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signinButton;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
//	@FindBy(xpath = "//h5[text()=' Alert!'] ")
	WebElement errorMessage;
	

	public HomePage login(String username,String password) throws IOException {
		userNameField.sendKeys(username);
		passwordField.sendKeys(password);
		signinButton.click();
		return new HomePage(driver);
	}
	public String readErrorMessage() {
		
		return errorMessage.getText();
	
	}
}
