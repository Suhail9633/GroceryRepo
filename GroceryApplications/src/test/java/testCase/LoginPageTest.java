package testCase;

import java.io.IOException;
//TestNG class
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;

public class LoginPageTest extends BaseClass {
	LoginPage lp; // instance variable
	HomePage hp;

	@Test // (enabled=false)//ee test run aavathirikkan ulla call
	public void loginWithValidCredential() throws IOException {
		lp = new LoginPage(driver); // login page access cheyyaan " @Test " ullil add aakkuka
		hp = lp.login(groceryLogin(0, 0), groceryLogin(0, 1));
//				lp.login("admin","admin");
		String actual = hp.getHomePageHeading();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.lp_loginWithValidCredential);

	}

	@Test(dataProvider = "data-provider")
	public void loginWithInvalidCredentials(String userName, String password) throws IOException {
		lp = new LoginPage(driver);
		hp=lp.login(userName, password);
		String actual = lp.readErrorMessage();
		String expected =  "×\n" + "Alert!\n" + "Invalid Username/Password";
		Assert.assertEquals(actual, expected, Constant.lp_loginWithInvalidCredential);

	}

	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() throws IOException {
		return new Object[][] { { groceryLogin(1, 0), groceryLogin(1, 1) }, { groceryLogin(2, 0), groceryLogin(2, 1) }, { groceryLogin(3, 0), groceryLogin(3, 1) } };
	}
}

//return new Object[][] { { groceryLogin(1, 0), groceryLogin(1, 1) }, { groceryLogin(2, 0), groceryLogin(2, 2) }, { groceryLogin(3, 0), groceryLogin(3, 3) } };