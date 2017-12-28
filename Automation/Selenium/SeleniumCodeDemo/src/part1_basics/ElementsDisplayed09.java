package part1_basics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ElementsDisplayed09 {

    WebDriver driver;
    String baseUrl1;
    String baseUrl2;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        baseUrl1 = "http://letskodeit.teachable.com/p/practice/?_ga=2.105300480.288802457.1506352705-1501667934.1506352705";
        baseUrl2 = "https://www.expedia.mx/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testLetsKodeIT() throws InterruptedException {
        driver.get(baseUrl1);

        WebElement textBox = driver.findElement(By.id("displayed-text"));
        System.out.println("Text Box Displayed: " + textBox.isDisplayed());

        Thread.sleep(2000);

        WebElement hideButton = driver.findElement(By.id("hide-textbox"));
        hideButton.click();
        System.out.println("Clicked on hide button");

        System.out.println("Text Box Displayed: " + textBox.isDisplayed());

        Thread.sleep(2000);

        WebElement showButton = driver.findElement(By.id("show-textbox"));
        showButton.click();
        System.out.println("Clicked on show button");

        System.out.println("Text Box Displayed: " + textBox.isDisplayed());
    }

    @Test
    public void testExpedia() throws InterruptedException {
        driver.get(baseUrl2);

        //El elemento solo aparece en el DOM cuando se da click en la opción de 1 o más niños en la página, así que no
        //podemos acceder a él a pesar de tener su XPath.
        WebElement childDropdown = driver.findElement(By.id("package-1-age-select-1"));
        System.out.println("Child dropdown displayed" + childDropdown.isDisplayed());
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }

}
