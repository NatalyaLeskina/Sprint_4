package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterPage {

    private WebDriver driver;

    public FooterPage(WebDriver driver) {
        this.driver = driver;
    }

    // кнопка согласия на cookies
    private By cookiesAgree = By.className("App_CookieButton__3cvqF");

    public void clickAgreeCookies() {
        driver.findElement(cookiesAgree).click();
    }

}
