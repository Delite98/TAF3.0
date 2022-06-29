package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectsPage extends BasePage {
    private final static String pagePath = "/index.php?/admin/projects/overview";
    public By navigateDashboard = By.id("navigation-dashboard");

    public SideMenuPage sideMenuPage;

    private By headerTitleLabelLocator = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'Projects')]");

    public ProjectsPage(WebDriver driver) {
        super(driver);

        sideMenuPage = new SideMenuPage(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public ProjectsPage navigateToProjectsPage() {
        navigateToProjectsPage().openPageByUrl();
        return this;
    }

    public DashboardPage navigateDashboardButton(){
        driver.findElement(navigateDashboard).click();
        return new DashboardPage(driver);
    }
}
