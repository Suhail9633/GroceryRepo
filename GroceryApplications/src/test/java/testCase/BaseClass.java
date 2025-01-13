package testCase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utilities.ExcelUtility;
import utilities.ScreenShotCapture;

public class BaseClass {

	WebDriver driver; // create instance variable (before & after method same driver ill call cheyyan
	ScreenShotCapture sc;
	public static Properties pro;

	public static void testBasic() throws IOException {
		pro = new Properties();
		FileInputStream fp = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\config.properties");
		pro.load(fp);
	}

	public static String groceryLogin(int row, int column) throws IOException {
		String data = ExcelUtility.readStringData(row, column,
				System.getProperty("user.dir") + "\\src\\main\\resources\\Excel\\loginCredientials.xlsx", "Sheet1");
		return data;
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters("Browser")

	public void beforeMethod(String browserName) throws IOException {
		if (browserName.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("Edge")) {
			driver = new EdgeDriver();
		}
		testBasic();
//		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.get(pro.getProperty("Baseurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod(alwaysRun = true)

	public void afterMethode(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			sc = new ScreenShotCapture();
			sc.captureFailureScreenShot(driver, iTestResult.getName());
		}
		driver.quit();
	}

}
