package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage(driver);

    @Test
    public void successLoginTest() {
        Assert.assertTrue(
                loginPage.successLogin(
                                ReadProperties.username(),
                                ReadProperties.password()
                        )
                        .isPageOpened()
        );
    }

    @Test
    public void incorrectEmailLoginTest() {
        Assert.assertEquals(
                loginPage.incorrectLogin("sdsd", ReadProperties.password()).getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");
        Assert.assertTrue(false);
    }

    @Test
    public void incorrectPswLoginTest() {
        Assert.assertEquals(
                loginPage.incorrectLogin(ReadProperties.username(), "123").getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");
    }

    @Test
    public void successLoginInvocationsTest() {
        Assert.assertTrue(
                new LoginPage(driver)
                        .successLogin("vsdfcdf", "sff")
                        .openProject("fytf")
                        .getTabByName("hjvjhv").isDisplayed()
        );
    }

}
