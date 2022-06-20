package tests;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @BeforeSuite
    public void setUpBrowser(){
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.browser = ReadProperties.browserName();
        Configuration.browserSize = "1000x600";
        //Configuration.assertionMode = AssertionMode.SOFT;
        //Configuration.driverManagerEnabled = false;
        //Configuration.fastSetValue = false;
        Configuration.headless = true;
        Configuration.reportsFolder = "target/";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.pageLoadTimeout = 3000;
        Configuration.pageLoadTimeout = Duration.ofSeconds(30).toMillis();
        Configuration.timeout = 10;

    }

        @Test
    public void poSelenideTest (){
        open(ReadProperties.getUrl());

        LoginPage loginPage = new LoginPage();

        loginPage.username.setValue(ReadProperties.username());
        loginPage.psw.setValue(ReadProperties.password());
        loginPage.loginButton.click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));

    }
}
