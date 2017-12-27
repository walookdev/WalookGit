package Part3_waitTypes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExplicitWaitWithWaitTypesDemo {

    private WebDriver driver;
    private String baseUrl;
    private WaitTypes wt;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://letskodeit.teachable.com/p/practice";
        wt = new WaitTypes(driver);
        driver.manage().window().maximize();

        //Espera 3 segundos a la carga de los elementos.
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws Exception {
        driver.get(baseUrl);

        WebElement loginLink = driver.findElement(By.linkText("Login"));

        loginLink.click();

        WebElement emailField = wt.waitForElement(By.id("user_email"), 3);
        emailField.sendKeys("test_email");

        wt.clickWhenReady(By.name("commit"), 3);
        //driver.findElement(By.id("user_email")).sendKeys("test");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

}
