import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MetodosUtiles {

    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://letskodeit.teachable.com/p/practice/?_ga=2.105300480.288802457.1506352705-1501667934.1506352705";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void metodosUtilesTest() {
        WebElement element = driver.findElement(By.id("opentab"));
        int time = 3;
        int x = 0;
        int y = 0;

        //Valida si el elemento está seleccionado
        element.isSelected();

        //Valida si el elemento se encuentra en a la vista o está oculto
        element.isDisplayed();

        //Limpia los caracteres de un cuadro de entrada de texto
        element.clear();

        //Obtiene el nombre de etiqueta del elemento
        element.getTagName();

        //Ejecuta un click sobre el elemento web.
        element.click();

        //Obtiene el texto del botón "open tab"
        String elementText = element.getText();

        //Obtiene el nombre del atributo dado como parámetro. En este caso el placeholder
        String attributeValue = element.getAttribute("placeholder");

        //Enviar caracteres a un campo de texto
        element = driver.findElement(By.id("name"));
        element.sendKeys("sending a string to the input texbox");

        //Encuentra un elemento web, usando el id, css, texto visible, etc.
        driver.findElement(By.id(""));

        //Cierra la ventana actual del navegador
        driver.close();

        //Cierra todas las ventanas del navegador
        driver.quit();

        //Carga la url introducida como parámetro en el navegador
        driver.get(baseUrl);

        //Encuentra una lista de elementos web. Si no encuentra ningún elemento la lista estará vacía
        driver.findElements(By.id(""));

        //Obtiene el título de la página actual
        driver.getTitle();

        //Si se tienen múltiples ventanas abiertas, cambia el foco a la ventana deseada.
        driver.switchTo().window("handleName");

        //Obtiene la url de la ventana que está enfocada
        driver.getCurrentUrl();

        //Obtiene el "handle" de la ventana que está enfocada
        driver.getWindowHandle();

        //Obtiene todos los handles de todas las ventanas abiertas
        driver.getWindowHandles();

        //Obtiene el código fuente de la página que está enfocada
        driver.getPageSource();

        //Permite navegar entre páginas
        driver.navigate().to(baseUrl);
        driver.navigate().back();
        driver.navigate().forward();

        //Recarga la página
        driver.navigate().refresh();

        //Manejo de tiempos de espera. Se le brinda cantidad de tiempo y unidad de tiempo como parámetros
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(time, TimeUnit.SECONDS);

        //Manipulación de las ventanas del navegador
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
        driver.manage().window().getPosition();
        driver.manage().window().setPosition(new Point(x, y));
        driver.manage().window().getSize();
        driver.manage().window().setSize(new Dimension(x, y));
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

}
