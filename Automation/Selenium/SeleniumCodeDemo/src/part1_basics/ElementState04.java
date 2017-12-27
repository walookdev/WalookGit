package part1_basics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ElementState04 {

    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com.mx/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void test() {
        WebElement element = driver.findElement(By.id("lst-ib"));
        System.out.println("element is enabled? " + element.isEnabled());
        element.sendKeys("letskodeit");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }

}
