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

public class DropdownSelect07 {

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
        WebElement element = driver.findElement(By.id("carselect"));
        //Conjunto de elementos web, correspondientes a las opciones de select con id "carselect".
        Select select = new Select(element);

        Thread.sleep(2000);
        System.out.println("Select Benz by value");
        //Seleccionar elemento por el atributo "value".
        select.selectByValue("benz");

        Thread.sleep(2000);
        System.out.println("Select Honda by index");
        //Seleccionar elemento por posición en la lista.
        select.selectByIndex(2);

        Thread.sleep(2000);
        System.out.println("Select BMW by visible text");
        //Seleccionar elemento por el texto visible en la página.
        select.selectByVisibleText("BMW");

        Thread.sleep(2000);
        System.out.println("Print the list of all options");
        List<WebElement> options = select.getOptions();

        for (int i = 0; i < options.size(); i++) {
            String optionName = options.get(i).getText();
            System.out.println(optionName);
        }
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

}
