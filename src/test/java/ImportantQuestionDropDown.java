import org.example.pages.FooterPage;
import org.example.pages.MainPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ImportantQuestionDropDown extends BaseTest {

    private final String arrowNumber;
    private final String dropDownText;

    public ImportantQuestionDropDown(String arrowNumber, String dropDownText) {
        this.arrowNumber = arrowNumber;
        this.dropDownText = dropDownText;
    }

    @Parameterized.Parameters
    public static Object[][] getDropDownText() {
        return new Object[][] {
                {"1", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"2", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"3", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"4", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"5", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"6", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"7", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"8", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    public void checkDropDown() {

        MainPage objMainPage = new MainPage(driver);
        objMainPage.openMainPage();

        FooterPage objFooterPage = new FooterPage(driver);
        objFooterPage.clickAgreeCookies();

        Assert.assertEquals(dropDownText, objMainPage.getArrowDropDownText(arrowNumber));
    }
}
