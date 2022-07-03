package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
    private final static String pagePath = "/index.php?/dashboard";

    ProjectPage projectPage = new ProjectPage(driver);
    public TopMenuPage topMenuPage;

    // Блок описания селекторов для элементов
    private By headerTitleLabelLocator = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'All Projects')]");

    public DashboardPage(WebDriver driver) {
        super(driver);

        topMenuPage = new TopMenuPage(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }


    // Блок атомарных методов
    public WebElement getHeaderTitleLabel() {
        return waitsService.waitForExists(headerTitleLabelLocator);
    }


    // Блок комплексных методов

    public ProjectsOverviewPage openProject (String projectName) {
        //ToDo: implement actions
        return new ProjectsOverviewPage(driver);
    }

    public void setHeaderTitleLabelLocator(By headerTitleLabelLocator) {
        this.headerTitleLabelLocator = headerTitleLabelLocator;
    }

    public ProjectPage openMyProject(){
        super.openPageByUrl(pagePath + "/");
        return projectPage;
    }

}
