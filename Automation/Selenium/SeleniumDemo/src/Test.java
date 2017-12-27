import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

    public static void main(String[] args) {

        setOSDriver();

        WebDriver driver = new ChromeDriver();
        String baseUrl = "http://www.google.com";

        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.findElement(By.name("q")).sendKeys("walook mexico");
        driver.findElement(By.name("q")).submit();
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div/div/div[1]/div/div/h3/a")).click();
        //*[@id="rso"]/div[1]/div/div[1]/div/div/h3/a
    }

    /**
     * Establece el controlador adecuado de acuerdo al OS en que se ejecutan las pruebas.
     */

    private static void setOSDriver() {

        if(System.getProperty("os.name").startsWith("Windows")) {

            /*
            System.setProperty(key, value)
            key - controlador a usar dependiendo del navegador.
            value - ubicación de la versión del controlador a usar dependiendo del OS.
             */
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        } else {

            System.setProperty("webdriver.chrome.driver", "chromedriver");

        }

    }

}