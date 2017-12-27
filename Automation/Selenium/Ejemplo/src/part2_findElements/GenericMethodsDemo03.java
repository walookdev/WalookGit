package part2_findElements;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GenericMethodsDemo03 {

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
    public void test() throws InterruptedException, IOException {
        WebElement element = methods.getElement("name", "id");
        element.sendKeys("text");

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
           FileUtils.copyFile(scrFile, new File("/home/rafael/Documents/selenium_guide/screeshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @After
    public void tearDown() throws Exception {

        Thread.sleep(3000);
        driver.quit();

    }

}
