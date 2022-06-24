package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MilestonePage extends BasePage {
    private final static String pagePath = "/index.php?/milestones";

    @FindBy (id = "name")
    public WebElement nameInput;

    @FindBy (id = "reference")
    public WebElement referencesInput;

    @FindBy (className = "chzn-single")
    public WebElement parent;

    @FindBy (id = "description_display")
    public WebElement descriptionInput;

    @FindBy (id = "is_completed")
    public WebElement completedInput;

    @FindBy (id = "accept")
    public WebElement acceptButton;

    @FindBy (xpath ="//div[contains(@class, 'content-header-title') and contains(text(), 'Add Milestone')]")
    public WebElement headerTitleLabel;

    public MilestonePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return headerTitleLabel;
    }
}