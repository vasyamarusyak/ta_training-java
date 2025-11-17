package com.epam.training.testProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class MainPage {

    private final WebDriver driver;
    private final By title = By.xpath("//div[@class='app_logo']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    public String getTitleText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }

}
