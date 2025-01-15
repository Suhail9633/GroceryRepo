package testCase;

import java.io.IOException;

import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.SettingsMenu;

public class SettingsMenuTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	SettingsMenu sm;

	@Test
	public void logoutUsingSettingsMenu() throws IOException {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);

		lp.login("admin", "admin");
		hp.clickOnSettingsMenu();
		sm.logOut();

	}
}
