package part6_ActionsClass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MouseHover {

    private WebDriver driver;
    private String baseUrl;
    private JavascriptExecutor js;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://letskodeit.teachable.com/p/practice";
        js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void test() throws InterruptedException {
        js.executeScript("window.scrollBy(0, 900)");
        Thread.sleep(2000);

        WebElement parentElement = driver.findElement(By.id("mousehover"));
        //Creamos un objeto Actions que nos permite usar la acción hover sobre el botón
        Actions action = new Actions(driver);

        //Posiciona el cursor del mouse sobre el botón
        action.moveToElement(parentElement).perform();

        Thread.sleep(2000);

        //Encontramos el primer elemento del dropdown list del botón
        WebElement subelement = driver.findElement(By.xpath("//div[@class='mouse-hover-content']//a[text()='Top']"));
        //Click sobre el primer elemento del dropdown list
        //subelement.click();
        action.moveToElement(subelement).click().perform();
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

}
