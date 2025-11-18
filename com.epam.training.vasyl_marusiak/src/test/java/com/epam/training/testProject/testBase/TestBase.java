package com.epam.training.testProject.testBase;

import com.epam.training.testProject.drivers.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBase {

    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected static final Logger log = LoggerFactory.getLogger(TestBase.class);

    @BeforeEach
    public void setUp() {
        String browser = System.getProperty("browser", "firefox");
        log.info("Starting browser: {}", browser);
        driver.set(DriverFactory.create(browser));
        getDriver().manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        if (getDriver() != null) {
            log.info("Closing browser");
            getDriver().quit();
            driver.remove();
        }
    }

    protected WebDriver getDriver() {
        return driver.get();
    }
}

