package part4_varios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ScrollingElementIntoView {

    private WebDriver driver;
    private String baseUrl;
    private JavascriptExecutor js;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://letskodeit.teachable.com/p/practice";
        js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testJavaScriptExecution() throws Exception {
        //Navigation
        //driver.get(baseUrl);
        js.executeScript("window.location = 'https://letskodeit.teachable.com/p/practice';");

        Thread.sleep(2000);
        //Scroll hacia abajo con 1900px
        js.executeScript("window.scrollBy(0, 1900);");
        Thread.sleep(2000);
        //Scroll hacia arriba con -1900px
        js.executeScript("window.scrollBy(0, -1900);");
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.id("mousehover"));

        //Se hace scroll hacia donde se encuentra el objeto dado como parámetro
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0, -190);");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

}