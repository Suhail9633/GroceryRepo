package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GenaralUtilities;

public class HomePage {
	WebDriver driver;
	GenaralUtilities gu = new GenaralUtilities();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='7rmart supermarket']")
	WebElement homePageHeading;
	@FindBy(xpath = "//a//p[text()='Sub Category']")
	WebElement subCategoryMenu;
	@FindBy(xpath = "//a//p[text()='Category']")
	WebElement CategoryMenu;
	@FindBy(xpath = "//a//p[text()='Manage Product']")
	WebElement manageProduct;
	@FindBy(xpath = "//i[@class='nav-icon sidebar-item-icon fa fa-cog']")
	WebElement SettingsMenu;
	@FindBy(xpath = "//a//p[text()='Manage Contact']")
	WebElement manageContact;

	public String getHomePageHeading() {

		return homePageHeading.getText();
	}

	public SubCategoryPage clickOnSubCategoryMenu() {
		subCategoryMenu.click();
		return new SubCategoryPage(driver);
	}

	public void clickOnCategoryMenu() {
		CategoryMenu.click();
	}

	public void clickOnSettingsMenu() {
		SettingsMenu.click();
		gu.pageScroll(0, 5000, driver);
	}
}
