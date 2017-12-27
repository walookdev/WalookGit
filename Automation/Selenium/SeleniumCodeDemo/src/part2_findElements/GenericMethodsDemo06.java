package part2_findElements;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GenericMethodsDemo06 {

    private WebDriver driver;
    private String baseUrl;
    private GenericMethods methods;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://letskodeit.teachable.com/p/practice/?_ga=2.105300480.288802457.1506352705-1501667934.1506352705";
        methods = new GenericMethods(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void test() throws InterruptedException {
        boolean result1 = methods.isElementPresent("name", "id");
        System.out.println("Is element present: " + result1);

        boolean result2 = methods.isElementPresent("name-not-present", "id");
        System.out.println("Is element present: " + result2);
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

}
