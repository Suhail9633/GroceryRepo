package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.CategoryPage;
import elementRepository.HomePage;
import elementRepository.LoginPage;

public class CategoryPageTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	CategoryPage cp;

	@Test
	public void editCategory() throws IOException, InterruptedException {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		cp = new CategoryPage(driver);
		hp = lp.login(groceryLogin(0, 0), groceryLogin(0, 1));
		hp.clickOnCategoryMenu();
		cp.editCategory();
		boolean editAlertStatus = cp.editMessage().contains("Category Updated Successfully");
		Assert.assertEquals(editAlertStatus, true, "edit alert message not as expected");
	}
}
