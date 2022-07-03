package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage extends BasePage {
    DashboardPage dashboardPage = new DashboardPage(driver);

    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }

    public DashboardPage navigationToMilestones(){
        driver.findElement(By.id("navigation-milestones")).click();
        return dashboardPage;
    }
}
