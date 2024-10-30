import org.example.pages.FooterPage;
import org.example.pages.MainPage;
import org.example.pages.OrderPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ScooterOrder extends BaseTest {

    private final String orderButton;
    private final String name;
    private final String lastname;
    private final String address;
    private final String metroStation;
    private final String phone;
    private final String rentalPeriod;
    private final String scooterColor;

    public ScooterOrder(String orderButton, String name, String lastname, String address, String metroStation, String phone, String rentalPeriod, String scooterColor) {
        this.orderButton = orderButton;
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentalPeriod = rentalPeriod;
        this.scooterColor = scooterColor;
    }

    @Parameterized.Parameters
    public static Object[][] getCities() {
        return new Object[][] {
                {"1", "Имя", "Фамилия", "Москва, Арбат, 1", "Арбатская", "+79001112233", "сутки", "чёрный жемчуг"},
                {"2", "Имяя", "Фамилияя", "Москва, Кремль, 1", "Дмитровская", "+79001112234", "двое суток", "серая безысходность"},
        };
    }

    @Test
    public void checkScooterOrder() {

        MainPage objMainPage = new MainPage(driver);
        objMainPage.openMainPage();

        objMainPage.clickOrderButton(orderButton);

        FooterPage objFooterPage = new FooterPage(driver);
        objFooterPage.clickAgreeCookies();

        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.makeOrder(name, lastname, address, metroStation, phone, rentalPeriod, scooterColor);

        Assert.assertEquals(true, objOrderPage.getSuccessCreatedOrderText().contains("Заказ оформлен"));

    }
}
