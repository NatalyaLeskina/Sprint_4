package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {

    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // кнопка согласия на cookies
    private By cookiesAgree = By.className("App_CookieButton__3cvqF");

    // форма заказа
    private By orderForm = By.className("Order_Content__bmtHS");

    // поле "Имя"
    private By nameField = By.xpath("//input[@placeholder='* Имя']");

    // поле "Фамилия"
    private By lastnameField = By.xpath("//input[@placeholder='* Фамилия']");

    // поле "Адрес"
    private By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");

    // поле "Станция метро"
    private By metroStationField = By.xpath("//input[@placeholder='* Станция метро']");

    // дропдаун выбора метро
    private By metroDropdown = By.xpath("//div[@class='select-search__select']");

    // первый пункт дропдауна выбора метро
    private By metroDropdownFirstItem = By.xpath("(//div[@class='select-search__select']//li[@class='select-search__row'])[1]");

    // поле "Телефон"
    private By phoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    // кнопка "Далее"
    private By nextButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // поле выбора даты доставки
    private By deliveryDateField = By.xpath("//input[@placeholder='* Когда привезти самокат']");

    // календарь
    private By calendar = By.className("react-datepicker__month-container");

    // стрелка переключения месяца в календаре вперёд
    private By nextMonthCalendarButton = By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--next']");

    // первая дата в календаре
    private By calendarFirstDate = By.xpath("(//div[@class='react-datepicker__week'])[1]/div[1]");

    // кнопка "Далее"
    private By rentalPeriod = By.xpath("//div[contains(text(), '* Срок аренды')]");

    // кнопка "Заказать"
    private By orderButton = By.xpath("//div[@class='Order_Content__bmtHS']//button[contains(text(), 'Заказать')]");

    // окно подтверждения заказа
    private By orderConfirmPopup = By.xpath("//div[@class='Order_Modal__YZ-d3']");

    // кнопка подтверждения заказа
    private By orderConfirmButton = By.xpath("//div[@class='Order_Modal__YZ-d3']//button[contains(text(), 'Да')]");

    // Заголовок окна успешного создания заказа
    private By successCreatedOrderTitle = By.xpath("//div[@class='Order_ModalHeader__3FDaJ']");

    // пункт в дропдауне "Срок аренды"
    public By rentalPeriodDropdownItem(String rentalPeriodItem) {
        return By.xpath("//div[@class='Dropdown-menu']/div[contains(text(), '" + rentalPeriodItem + "')]");
    }

    // чекбокс цвета самоката
    public By scooterColorCheckbox(String color) {
        return By.xpath("//div[@class='Order_Checkboxes__3lWSI']//label[contains(text(), '" + color + "')]");
    }

    public void makeOrder(String name, String lastname, String address, String metroStation, String phone, String rentalPeriodItem, String scooterColor) {

        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(orderForm));

        driver.findElement(cookiesAgree).click();
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(lastnameField).sendKeys(lastname);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(metroStationField).click();
        driver.findElement(metroStationField).sendKeys(metroStation);
        new WebDriverWait(driver, Duration.ofSeconds(7))
                .until(ExpectedConditions.visibilityOfElementLocated(metroDropdown));
        driver.findElement(metroDropdownFirstItem).click();
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(nextButton).click();


        driver.findElement(deliveryDateField).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(calendar));
        driver.findElement(nextMonthCalendarButton).click();
        driver.findElement(calendarFirstDate).click();
        driver.findElement(rentalPeriod).click();
        driver.findElement(rentalPeriodDropdownItem(rentalPeriodItem)).click();
        driver.findElement(scooterColorCheckbox(scooterColor)).click();
        driver.findElement(orderButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(orderConfirmPopup));
        driver.findElement(orderConfirmButton).click();
    }

    public String getSuccessCreatedOrderText() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(successCreatedOrderTitle));
        return driver.findElement(successCreatedOrderTitle).getText();
    }
}
