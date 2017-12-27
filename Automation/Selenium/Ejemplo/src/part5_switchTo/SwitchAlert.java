package part5_switchTo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SwitchAlert {

    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://letskodeit.teachable.com/p/practice";

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void alertTest() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("name")).sendKeys("Walook");
        driver.findElement(By.id("alertbtn")).click();
        Thread.sleep(3000);

        Alert alert = driver.switchTo().alert();

        //Click ok en el pop up
        alert.accept();
    }

    @Test
    public void confirmTest() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("name")).sendKeys("Walook");
        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(3000);

        Alert alert = driver.switchTo().alert();

        //Click ok en el pop up
        alert.accept();
        //Click cancel en el pop up
        //alert.dismiss();
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

}
