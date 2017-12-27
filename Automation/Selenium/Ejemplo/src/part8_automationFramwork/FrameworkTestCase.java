package part8_automationFramwork;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FrameworkTestCase {

    private WebDriver driver;
    private String baseUrl;
    private SearchPageFactory searchPage;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://www.expedia.mx";
        searchPage = new SearchPageFactory(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void test() throws InterruptedException {
        searchPage.clickFlightsTab();
        searchPage.setFligthOriginCity("Mérida, Yucatán, México");
        searchPage.setFlightDestinationCity("Monterrey, Nuevo León, México");
        searchPage.setFlightDepartureDate("31/12/2017");
        searchPage.setFlightReturnDate("06/01/2018");

        Thread.sleep(2000);

        searchPage.clickSearchFlightsButton();
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(6000);
        driver.quit();
    }

}
