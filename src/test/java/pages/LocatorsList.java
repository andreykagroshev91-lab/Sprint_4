package pages;

import org.openqa.selenium.By;

public class LocatorsList {
    // Домашняя страница
    public static final By ORDER_BUTTON_TOP = By.xpath("//button[text()='Заказать']");
    public static final By ORDER_BUTTON_BOTTOM = By.xpath("//button[text()='Заказать']/ancestor::div[contains(@class, 'Home_FinishButton')]");

    // Cookie
    public static final By COOKIE_BUTTON = By.id("rcc-confirm-button");

    // Первая страница заказа
    public static final By NAME_FIELD = By.xpath("//input[@placeholder='* Имя']");
    public static final By SURNAME_FIELD = By.xpath("//input[@placeholder='* Фамилия']");
    public static final By ADDRESS_FIELD = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    public static final By METRO_FIELD = By.xpath("//input[@placeholder='* Станция метро']");
    public static final By PHONE_FIELD = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    public static final By NEXT_BUTTON = By.xpath("//button[text()='Далее']");

    // Выпадающий список метро
    public static final By METRO_STATION_OPTION = By.xpath("//div[@class='select-search__select']//button");

    // Вторая страница заказа
    public static final By DATE_FIELD = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    public static final By RENTAL_PERIOD_FIELD = By.xpath("//div[contains(@class, 'Dropdown-control')]");
    public static final By CALENDAR_DAY = By.xpath("//div[contains(@class, 'react-datepicker__day') and text()='25']");
    public static final By RENTAL_OPTION_ONE_DAY = By.xpath("//div[text()='сутки']");
    public static final By COLOR_BLACK = By.id("black");
    public static final By COMMENT_FIELD = By.xpath("//input[@placeholder='Комментарий для курьера']");
    public static final By ORDER_BUTTON = By.xpath("//button[text()='Заказать' and contains(@class, 'Button_Middle')]");
    public static final By CONFIRM_ORDER_BUTTON = By.xpath("//button[text()='Да']");
    public static final By ORDER_SUCCESS_MODAL = By.xpath("//div[contains(text(), 'Заказ оформлен')]");
}