package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectsPage extends BasePage {
    String set = "/148";
    private final static String pagePath = "/index.php?/admin/projects/overview" + "set";
    public By navigateDashboard = By.id("navigation-dashboard");

    public ProjectsPage projectsPage;
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

    public ProjectsPage navigateToProjectsPage() {
        navigateToProjectsPage().openPageByUrl(pagePath);
        return this;
    }

    public DashboardPage navigateDashboardButton(){
        driver.findElement(navigateDashboard).click();
        return new DashboardPage(driver);
    }


}
