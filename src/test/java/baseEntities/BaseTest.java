package baseEntities;

import com.google.gson.Gson;
import configuration.ReadProperties;
import models.Project;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import services.BrowsersService;
import utils.Listener;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

@Listeners(Listener.class)
public class BaseTest {
    public WebDriver driver;

    protected Project mainProject;

    @BeforeTest
    public void prepareData() throws IOException {
    }

    @BeforeMethod
    public void setup() {
        driver = new BrowsersService().getDriver();

        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
