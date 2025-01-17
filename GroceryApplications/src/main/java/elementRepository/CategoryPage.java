package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GenaralUtilities;
import utilities.WaitUtilities;

public class CategoryPage {

	WebDriver driver;
	GenaralUtilities gu = new GenaralUtilities();
	WaitUtilities wu = new WaitUtilities();

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[4]//a[1]")
	WebElement categoryEditIcon;
	@FindBy(xpath = "//input[@id='category']")
	WebElement editCategoryName;
	@FindBy(xpath = "//button[text()='Update']")
	WebElement categoryUpdateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement editMessage;
	
	public void editCategory() throws InterruptedException  {
		categoryEditIcon.click();
		editCategoryName.sendKeys("sss");
		gu.pageScroll(0, 1500, driver);
		wu.waitForWebElement(driver, categoryUpdateButton, "text", "Update", 5);
//		Thread.sleep(2000);
		categoryUpdateButton.click();
//		gu.clickJavaScriptExecutor(categoryUpdateButton, driver);
//		Staging sample
		
	}
	public String editMessage() {
		return editMessage.getText();
	}
	
}
