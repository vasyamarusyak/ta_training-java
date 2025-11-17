package pages;

import org.openqa.selenium.By;
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
        driver.findElement(usernameField)
                .clear()
                .sendKeys(username);
    }

    public void typePassword(String password) {
        log.info("Typing password", password);
        driver.findElement(passwordField)
                .clear()
                .sendKeys(password);
    }

    public void clearUserNameAndPasswordFields() {
        log.info("Clearing username and password fields");
        driver.findElement(usernameField).clear();
        driver.findElement(passwordField).clear();
    }

    public void clickLoginButton() {
        log.info("Clicking Login button");
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }

    public void login(String username, String password) {
        typeUsername(username);
        typePassword(password);
        clickLoginButton();
    }
}
