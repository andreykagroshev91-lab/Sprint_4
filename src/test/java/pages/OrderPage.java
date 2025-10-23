package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class OrderPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void closeCookieBanner() {
        List<WebElement> cookieButtons = driver.findElements(LocatorsList.COOKIE_BUTTON);
        if (!cookieButtons.isEmpty() && cookieButtons.get(0).isDisplayed()) {
            cookieButtons.get(0).click();
        }
    }

    public void fillFirstPage(String name, String surname, String address, String phone) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LocatorsList.NAME_FIELD));

        driver.findElement(LocatorsList.NAME_FIELD).sendKeys(name);
        driver.findElement(LocatorsList.SURNAME_FIELD).sendKeys(surname);
        driver.findElement(LocatorsList.ADDRESS_FIELD).sendKeys(address);
        selectMetroStation();
        driver.findElement(LocatorsList.PHONE_FIELD).sendKeys(phone);
    }

    private void selectMetroStation() {
        driver.findElement(LocatorsList.METRO_FIELD).click();
        WebElement firstStation = wait.until(ExpectedConditions.elementToBeClickable(LocatorsList.METRO_STATION_OPTION));
        firstStation.click();
    }

    public void clickNextButton() {
        driver.findElement(LocatorsList.NEXT_BUTTON).click();
    }

    public void fillSecondPage(String rentalPeriod, String color, String comment) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LocatorsList.DATE_FIELD));
        closeCookieBanner();
        selectDateFromCalendar();
        selectRentalPeriod(rentalPeriod);
        selectColor(color);
        driver.findElement(LocatorsList.COMMENT_FIELD).sendKeys(comment);
    }

    private void selectDateFromCalendar() {
        driver.findElement(LocatorsList.DATE_FIELD).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(LocatorsList.CALENDAR_DAY));
        driver.findElement(LocatorsList.CALENDAR_DAY).click();
    }

    private void selectRentalPeriod(String period) {
        driver.findElement(LocatorsList.RENTAL_PERIOD_FIELD).click();
        driver.findElement(LocatorsList.RENTAL_OPTION_ONE_DAY).click();
    }

    private void selectColor(String color) {
        if ("черный".equals(color) || "чёрный".equals(color)) {
            driver.findElement(LocatorsList.COLOR_BLACK).click();
        }
    }

    public void clickOrderButton() {
        driver.findElement(LocatorsList.ORDER_BUTTON).click();
    }

    public void confirmOrder() {
        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(LocatorsList.CONFIRM_ORDER_BUTTON));
        confirmButton.click();
    }

    public boolean isOrderSuccess() {
        WebElement successElement = wait.until(ExpectedConditions.visibilityOfElementLocated(LocatorsList.ORDER_SUCCESS_MODAL));
        return successElement.isDisplayed();
    }

}