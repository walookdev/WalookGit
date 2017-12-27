package part8_automationFramwork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Object repository - Page class
public class SearchPageFactory {

    private WebDriver driver;

    @FindBy(id = "tab-flight-tab-hp")
    private WebElement flightsTab;

    @FindBy(id = "flight-type-roundtrip-hp-flight")
    private WebElement roundTrip;

    @FindBy(id = "flight-type-multi-dest-hp-flight")
    private WebElement multipleDestinations;

    @FindBy(id = "flight-origin-hp-flight")
    private WebElement fligthOriginCity;

    @FindBy(id = "flight-destination-hp-flight")
    private WebElement flightDestinationCity;

    @FindBy(id = "flight-departing-hp-flight")
    private WebElement flightDepartureDate;

    @FindBy(id = "flight-returning-hp-flight")
    private WebElement flightReturnDate;

    @FindBy(xpath = "//form[@id='gcw-flights-form-hp-flight']//button[@class='btn-primary btn-action gcw-submit']")
    private WebElement searchFlightsButton;

    public SearchPageFactory(WebDriver driver) {
        this.driver = driver;
        //Inicializa todos los elemetos web que declaramos como atributos de la clase
        PageFactory.initElements(driver, this);
    }

    public void clickFlightsTab() {
        flightsTab.click();
    }

    public void clickRoudTrip() {
        roundTrip.click();
    }

    public void clickMultipleDestinations() {
        multipleDestinations.click();
    }

    public void clickSearchFlightsButton() {
        searchFlightsButton.click();
    }

    public void setFligthOriginCity(String fligthOriginCity) {
        this.fligthOriginCity.sendKeys(fligthOriginCity);
    }

    public void setFlightDestinationCity(String flightDestinationCity) {
        this.flightDestinationCity.sendKeys(flightDestinationCity);
    }

    public void setFlightDepartureDate(String flightDepartureDate) {
        this.flightDepartureDate.sendKeys(flightDepartureDate);
    }

    public void setFlightReturnDate(String flightReturnDate) {
        this.flightReturnDate.sendKeys(flightReturnDate);
    }

}
