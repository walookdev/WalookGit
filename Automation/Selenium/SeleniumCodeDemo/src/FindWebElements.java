import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindWebElements {

    private WebDriver driver;
    private String baseUrl;
    private String url2;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://letskodeit.teachable.com/p/practice";
        url2 = "https://letskodeit.teachable.com/";

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void findWebElements() {
        driver.get(baseUrl);
        WebElement element;

        //Buscar elemento usando id
        element = driver.findElement(By.id("openwindow"));

        //Buscar elemento usando XPath
        element = driver.findElement(By.xpath("//*[@id=\"opentab\"]"));

        //Buscar un conjunto de radio buttons usando name
        element = driver.findElement(By.name("cars"));

        //Busca el primer elemento con la clase "btn-style"
        element = driver.findElement(By.className("btn-style"));

        driver.navigate().to(url2);

        //Busca un elemento cuyo texto entre la etiqueta sea "Login". Funciona para etiquetas anchor
        element = driver.findElement(By.linkText("Login"));

        //Busca un elemento cuyo texto entre la etiqueta contenga la subcadena "Prac". Funciona para etiquetas anchor
        element = driver.findElement(By.partialLinkText("Prac"));

        List<WebElement> elements;

        //Busca todos los elementos con la etiqueta anchor
        elements = driver.findElements(By.tagName("a"));
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

}
