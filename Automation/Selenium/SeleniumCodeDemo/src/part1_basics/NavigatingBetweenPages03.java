package part1_basics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class NavigatingBetweenPages03 {

    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "http://letskodeit.teachable.com/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void test() throws InterruptedException {
        //Obtenemos el título de la página
        String title = driver.getTitle();
        System.out.println("Title of the page: " + title);

        //Obtenemos la url donde nos encontramos actualmente.
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        //Url hacia donde queremos navegar.
        String urlToNavigate = "https://sso.teachable.com/secure/42299/users/sign_in?clean_login=true&reset_purchase_session=1";
        //Nevagamos a la url especificada.
        driver.navigate().to(urlToNavigate);

        currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        //Tiempo de espera entre navegación. Lanza InterruptedException.
        Thread.sleep(2000);

        //Navegamos a la página anterior.
        driver.navigate().back();
        System.out.println("Navigate back");
        currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        Thread.sleep(2000);

        //Navegamos a la página siguiente, de la que provenimos al navegar atrás.
        driver.navigate().forward();
        System.out.println("Navigate forward");
        currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        Thread.sleep(2000);

        //Volvemos a la página anterior
        driver.navigate().back();
        System.out.println("Navigate back");
        currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        //Refrescamos/recargamos la página.
        driver.navigate().refresh();
        System.out.println("Navigate refresh");

        //Podemos refrescar usando get, pues nos lleva al url que estamos refrescando.
        driver.get(currentUrl);
        System.out.println("Navigate refresh");

        //Obtenemos el código fuente HTML de la página.
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }

}
