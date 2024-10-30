package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;

    // блок "Вопросы о важном"
    private By importantQuestions = By.className("Home_FourPart__1uthg");

    // Верхняя кнопка "Заказать"
    private By topOrderButton = By.xpath("//button[@class='Button_Button__ra12g']");

    // Нижняя кнопка "Заказать"
    private By bottomOrderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Стрелка
    public By getArrowXpath(String arrowNumber) {
        return By.xpath("(//div[@class='accordion__heading'])[" + arrowNumber + "]");
    }

    // Дропдаун под стрелкой
    public By getArrowDropDownXpath(String arrowNumber) {
        return By.xpath("(//div[@class='accordion__panel'])[" + arrowNumber + "]");
    }

    // Главная страница
    public void openMainPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public void scrollToImportantQuestions() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                driver.findElement(importantQuestions));
    }


    public void clickArrow(String arrowNumber) {
        driver.findElement(getArrowXpath(arrowNumber)).click();
    }

    public String getArrowDropDownText(String arrowNumber) {
        scrollToImportantQuestions();
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(importantQuestions));
        clickArrow(arrowNumber);
        By dropDownElement = getArrowDropDownXpath(arrowNumber);
        new WebDriverWait(driver, Duration.ofSeconds(1))
            .until(ExpectedConditions.visibilityOfElementLocated(dropDownElement));
        return driver.findElement(dropDownElement).getText();
    }

    public void clickTopOrderButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                driver.findElement(topOrderButton));
        driver.findElement(topOrderButton).click();
    }

    public void clickBottomOrderButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                driver.findElement(bottomOrderButton));
        driver.findElement(bottomOrderButton).click();
    }

    public void clickOrderButton(String buttonNumber) {
        if (buttonNumber.equals("1")) {
            clickTopOrderButton();
        } else if (buttonNumber.equals("2")) {
            clickBottomOrderButton();
        }
    }
}
