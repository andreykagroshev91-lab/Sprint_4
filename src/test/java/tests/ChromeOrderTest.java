package tests;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.MainPage;
import pages.OrderPage;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ChromeOrderTest extends BaseTest {

    private final String buttonType;
    private final String name;
    private final String surname;
    private final String address;
    private final String phone;

    public ChromeOrderTest(String buttonType, String name, String surname, String address, String phone) {
        this.buttonType = buttonType;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"top", "Папппа", "Аппапа", "Проспект мира", "89999999999"},
                {"bottom", "Букля", "Петрося", "Пятка 1905", "+78888888888"}
        });
    }

    @Before
    public void setUp() {
        setupChrome();
    }

    @Test
    public void orderScooterTest() {
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);

        // Нажатие на кнопку заказа
        if (buttonType.equals("top")) {
            mainPage.clickOrderButtonTop();
        } else {
            mainPage.clickOrderButtonBottom();
        }

        // Заполняем первую страницу
        orderPage.fillFirstPage(name, surname, address, phone);
        orderPage.clickNextButton();

        // Заполняем вторую страницу
        orderPage.fillSecondPage("сутки", "черный", "Комментарий");
        orderPage.clickOrderButton();

        // Подтверждаем заказ
        orderPage.confirmOrder();

        // Проверка что заказ создан
        Assert.assertTrue("Заказ должен быть успешным", orderPage.isOrderSuccess());
    }
}