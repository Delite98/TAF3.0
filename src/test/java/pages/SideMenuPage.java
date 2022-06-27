package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SideMenuPage extends BasePage {
    public By sidebarLocator = By.id("sidebar");

    public SideMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return sidebarLocator;
    }

    public SideMenuPage buttonAddProject(){
        driver.findElement(sidebarLocator).click();
        return this;
    }
}
