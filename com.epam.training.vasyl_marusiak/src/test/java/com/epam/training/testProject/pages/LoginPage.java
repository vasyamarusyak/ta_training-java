package com.epam.training.testProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;
    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);
    private final String URL = "https://www.saucedemo.com/";

    private final By usernameField = By.xpath("//input[@id='user-name']");
    private final By passwordField = By.xpath("//input[@id='password']");
    private final By loginButton   = By.xpath("//input[@id='login-button']");
    private final By errorMessage  = By.xpath("//h3[contains(@data-test,'error')]");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openLoginPage() {
        log.info("Opening SauceDemo login page");
        driver.get(URL);
    }

    public void typeUserName(String username) {
        log.info("Typing username: {}", username);
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    public void typePassword(String password) {
        log.info("Typing password", password);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clearPasswordField() {
        log.info("Clearing password");
        driver.findElement(passwordField).sendKeys(Keys.CONTROL, "a");
        driver.findElement(passwordField).sendKeys(Keys.DELETE);
    }

    public void clearUserNameAndPasswordFields() {
        log.info("Clearing username and password fields");
        driver.findElement(usernameField).sendKeys(Keys.CONTROL, "a");
        driver.findElement(usernameField).sendKeys(Keys.DELETE);
        clearPasswordField();
    }

    public void clickLoginButton() {
        log.info("Clicking Login button");
        driver.findElement(loginButton).click();
    }
    public String getErrorMessage() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(errorMessage))
                .getText();
    }


    public MainPage login(String username, String password) {
        typeUserName(username);
        typePassword(password);
        clickLoginButton();

        return new MainPage(driver);
    }
}