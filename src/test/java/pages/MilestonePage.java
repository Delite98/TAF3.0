package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MilestonePage extends BasePage {
    private final static String pagePath = "/index.php?/milestones/add/48";

    private By nameInputLocator = By.id("name");
    private By referencesInputLocator = By.id("reference");
    private By parentLocator = By.className("chzn-single");
    private By descriptionInputLocator = By.id("description_display");
    private By completedInputLocator = By.id("is_completed");
    private By acceptButtonLocator = By.id("accept");

    private By headerTitleLabelLocator = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'Add Milestone')]");

    public MilestonePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public WebElement getNameInputLocator() {
        return driver.findElement(nameInputLocator);
    }

    public WebElement getReferencesInputLocator() {
        return driver.findElement(referencesInputLocator);
    }

    public WebElement getParentLocator() {
        return driver.findElement(parentLocator);
    }

    public WebElement getDescriptionInputLocator() {
       return driver.findElement(descriptionInputLocator);
    }

    public WebElement getCompletedInputLocator() {
        return driver.findElement(completedInputLocator);
    }

    public WebElement getAcceptButtonLocator() {
        return driver.findElement(acceptButtonLocator);
    }

    public By getHeaderTitleLabelLocator() {
        return headerTitleLabelLocator;
    }
}
