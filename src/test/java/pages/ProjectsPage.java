package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsPage extends BasePage {
    private final static String pagePath = "/index.php?/admin/projects/overview";

    public SideMenuPage sideMenuPage;

    @FindBy (xpath = "//div[contains(@class, 'content-header-title') and contains(text(), 'Projects')]")
    public WebElement headerTitleLabelLocator;

    public ProjectsPage(WebDriver driver) {
        super(driver);

        sideMenuPage = new SideMenuPage(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }
}
