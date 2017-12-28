package part1_basics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RadioButtonsAndChecBoxes05 {

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
        WebElement bmwRadioBtn = driver.findElement(By.id("bmwradio"));
        bmwRadioBtn.click();

        Thread.sleep(2000);

        WebElement benzRadioBtn = driver.findElement(By.id("benzradio"));
        benzRadioBtn.click();

        Thread.sleep(2000);

        WebElement bmwCheckBox = driver.findElement(By.id("bmwcheck"));
        bmwCheckBox.click();

        Thread.sleep(2000);

        WebElement benzCheckBox = driver.findElement(By.id("benzcheck"));
        benzCheckBox.click();

        System.out.println("BMW radio is selected?" + bmwRadioBtn.isSelected());
        System.out.println("Benz radio is selected?" + benzRadioBtn.isSelected());
        System.out.println("BMW checkbox is selected?" + bmwCheckBox.isSelected());
        System.out.println("Benz checkbox is selected?" + benzCheckBox.isSelected());
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

}
