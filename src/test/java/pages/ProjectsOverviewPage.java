package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsOverviewPage extends BasePage {
    public SideMenuPage sideMenuPage;

    @FindBy (id ="chart-line-fc")
    public WebElement chartTable;

    @FindBy (xpath = "//li/a[. = 'Replace']")
    public WebElement tab;

    public ProjectsOverviewPage(WebDriver driver) {
        super(driver);

        sideMenuPage = new SideMenuPage(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return chartTable;
    }

    public WebElement getTabByName(String tabName) {
        return tab;
    }
}
