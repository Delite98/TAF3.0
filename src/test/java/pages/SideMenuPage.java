package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SideMenuPage extends BasePage {
    public By sidebarLocator = By.id("sidebar-projects-add");

    public SideMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return sidebarLocator;
    }

    public AddProjectPage buttonAddProject(){
        driver.findElement(sidebarLocator).click();
        return new AddProjectPage(driver);
    }
}
