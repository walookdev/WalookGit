package part1_basics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class BasicActions02 {

    private WebDriver driver;
    private String baseUrl;

    /*
        Acciones a realizar antes de ejecutar la prueba.
     */
    @Before
    public void setUp() throws Exception {
        //Creamos una instacia del driver para Google Chrome
        driver = new ChromeDriver();
        //Usaremos esta url como base para trabajar.
        baseUrl = "http://letskodeit.teachable.com/";
        //Se esperan 10 segundos a que carguen los elementos web antes de lanzar una excepción.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Maximiza la ventana del navegador.
        driver.manage().window().maximize();
        //Abre una nueva instancia del navegador con la url solicitada.
        driver.get(baseUrl);
    }

    /*
        Acciones a realizar como prueba.
     */
    @Test
    public void test() {
        //Encontramos el botón "Login" y damos click en él.
        driver.findElement(By.xpath("//div[@id='navbar']//a[@href='/sign_in']")).click();

        //Limpiamos el campo de correo del usuario.
        driver.findElement(By.id("user_email")).clear();

        //Enviamos un correo al campo de correo de usuario.
        driver.findElement(By.id("user_email")).sendKeys("part1_basics@email.com");

        //Limpiamos el campo de contraseña del usuario.
        driver.findElement(By.id("user_password")).clear();

        //Enviamos las contraseña al campo de contraseña de usuario.
        driver.findElement(By.id("user_password")).sendKeys("password");
    }

    /*
        Acciones a realizar después de la prueba.
     */
    @After
    public void tearDown() throws Exception {
        //Esperamos 2 segundos antes de realizar la siguiente acción.
        Thread.sleep(2000);
        //Cerramos la instancia del navegador.
        driver.quit();
    }

}