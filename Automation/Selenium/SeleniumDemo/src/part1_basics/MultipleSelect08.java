package part1_basics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MultipleSelect08 {

    WebDriver driver;
    String baseUrl;

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
        WebElement element = driver.findElement(By.id("multiple-select-example"));
        Select select = new Select(element);

        Thread.sleep(2000);
        System.out.println("Select orange by value");
        select.selectByValue("orange");

        Thread.sleep(2000);
        System.out.println("De-select orange by value");
        select.deselectByValue("orange");

        Thread.sleep(2000);
        System.out.println("Select peach by index");
        select.selectByIndex(2);
        //select.deselectByIndex(2);

        Thread.sleep(2000);
        System.out.println("Select apple by visible text");
        select.selectByVisibleText("Apple");
        //select.deselectByVisibleText("Apple");

        Thread.sleep(2000);
        System.out.println("Print all selected options");
        List<WebElement> selectedOptions = select.getAllSelectedOptions();

        for (WebElement option : selectedOptions) {
            System.out.println(option.getText());
        }

        Thread.sleep(2000);
        System.out.println("De-select all selected options");
        select.deselectAll();
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

}
