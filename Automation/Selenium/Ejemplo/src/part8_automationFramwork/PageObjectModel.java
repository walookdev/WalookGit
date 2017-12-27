package part8_automationFramwork;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObjectModel {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://www.expedia.mx/";

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);

		SearchPage.clickFlightsTab(driver);

		Thread.sleep(1000);

		SearchPage.fillOriginTextBox(driver, "Mérida, Yucatán, México (MID-A. Internacional Manuel Crescencio Rejón)");

		Thread.sleep(1000);

		SearchPage.destinationTextBox(driver).sendKeys("Monterrey, Nuevo León, México");

		Thread.sleep(1000);

		SearchPage.departureDateTextBox(driver).sendKeys("31/12/2017");

		Thread.sleep(1000);

		SearchPage.returnDateTextBox(driver).sendKeys("06/01/2018");

		Thread.sleep(1000);

		SearchPage.clickOnSearchButton(driver);
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(10000);
		driver.quit();
	}

}
