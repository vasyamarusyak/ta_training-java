package com.epam.training.testProject.tests;

import com.epam.training.testProject.testBase.TestBase;
import com.epam.training.testProject.pages.MainPage;
import com.epam.training.testProject.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;


public class SauceDemoTests extends TestBase {

    @Test
    public void loginWithEmptyCredentials_UC1() {
        LoginPage page = new LoginPage(getDriver());
        page.openLoginPage();
        page.typeUserName("anyUserName");
        page.typePassword("anyPassword");
        page.clearUserNameAndPasswordFields();
        page.clickLoginButton();

        String actualMessage = page.getErrorMessage();
        String expectedMessage = "Username is required";
        assertThat(actualMessage).contains(expectedMessage);
    }

    @Test
    public void loginWithoutPassword_UC2() {
        LoginPage page = new LoginPage(getDriver());
        page.openLoginPage();
        page.typeUserName("anyUserName");
        page.typePassword("anyPassword");
        page.clearPasswordField();
        page.clickLoginButton();

        String actualMessage = page.getErrorMessage();
        String expectedMessage = "Password is required";
        assertThat(actualMessage).contains(expectedMessage);
    }

    @ParameterizedTest(name = "Login with valid credentials {0},{1}")
    @MethodSource("com.epam.training.testProject.utils.TestDataProvider#validCredentials")
    public void loginWithValidUserNameAndpassword_UC3(String username, String password) {
        LoginPage page = new LoginPage(getDriver());
        page.openLoginPage();
        MainPage mainPage =   page.login(username, password);

        String actualTitle = mainPage.getTitleText();
        String expectedTitle = "Swag Labs";
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }
}
