package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AddProjectPage;
import pages.MilestonePage;
import pages.SideMenuPage;

public class CrudStep extends BaseStep {

    public CrudStep(WebDriver driver) {
        super(driver);
    }
    AddProjectPage addProjectPage = new AddProjectPage(driver);
    MilestonePage milestonePage = new MilestonePage(driver);

    @Step
    public void accessChapter() {
        addProjectPage.access.click();
    }

    @Step
    public void defectsChapter() {
        addProjectPage.defects.click();
    }

    @Step
    public void referencesChapter() {
        addProjectPage.references.click();
    }

    @Step
    public void userVariablesChapter() {
        addProjectPage.userVariables.click();
    }



    @Step
    public void mNameInput() {
        milestonePage.nameInput.sendKeys("My name1");
    }

    @Step
    public void mReferencesInput() {
        milestonePage.referencesInput.sendKeys("Testing");
    }

    @Step
    public void mDescriptionInput() {
        milestonePage.descriptionInput.sendKeys("Test text");
    }

    @Step
    public void mCompletedInput() {
        milestonePage.completedInput.click();
    }

    @Step
    public void mAcceptButton() {
        milestonePage.acceptButton.submit();
    }





}
