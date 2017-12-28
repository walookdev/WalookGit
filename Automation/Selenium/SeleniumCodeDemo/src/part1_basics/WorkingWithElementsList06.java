package part1_basics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WorkingWithElementsList06 {

    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        baseUrl = "http://letskodeit.teachable.com/p/practice/?_ga=2.105300480.288802457.1506352705-1501667934.1506352705";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void test() throws InterruptedException {
        String xPathRadio = "//input[contains(@type, 'radio') and contains(@name, 'cars')]";
        List<WebElement> radioButtons = driver.findElements(By.xpath(xPathRadio));

        for (int i = 0; i < radioButtons.size(); i++) {
            boolean isChecked = false;
            isChecked = radioButtons.get(i).isSelected();

            if (!isChecked) {
                radioButtons.get(i).click();
                Thread.sleep(2000);
            }
        }
    }

    @After
    public void tearDown() throws Exception {

        Thread.sleep(3000);
        driver.quit();

    }

}
