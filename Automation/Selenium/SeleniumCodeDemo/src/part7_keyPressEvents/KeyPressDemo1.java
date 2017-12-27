package part7_keyPressEvents;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class KeyPressDemo1 {

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
    public void test() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(@href, 'sign_in')]")).click();
        driver.findElement(By.id("user_email")).sendKeys("test@gmail.com");

        Thread.sleep(2000);

        driver.findElement(By.id("user_password")).sendKeys("password");

        Thread.sleep(2000);

        //Simula que se presiona la tecla enter para presionar el botón
        driver.findElement(By.name("commit")).sendKeys(Keys.ENTER);
    }

    @Test
    public void test2() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(@href, 'sign_in')]")).click();
        driver.findElement(By.id("user_email")).sendKeys("test@gmail.com");

        Thread.sleep(2000);

        driver.findElement(By.id("user_email")).sendKeys(Keys.TAB);
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

}
