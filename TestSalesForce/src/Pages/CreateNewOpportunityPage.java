package Pages;

import Framework.Browser.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Cristelh Miranda on 8/12/2015.
 */
public class CreateNewOpportunityPage extends UIElements{
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "opp3")
    @CacheLookup
    WebElement opportunityNameField;

    @FindBy(id = "opp9")
    @CacheLookup
    WebElement opportunityCloseDateField;

    @FindBy(id = "opp11")
    @CacheLookup
    WebElement opportunityStageField;

    @FindBy(id = "opp4_lkwgt")
    @CacheLookup
    WebElement accountNameLookupButton;

    String OpportunitiesBrowserId;


    public CreateNewOpportunityPage(WebDriver driver)
    {
        this.driver = driver;
        wait = WebDriverManager.getInstance().getWait();
        OpportunitiesBrowserId = driver.getWindowHandle();
        PageFactory.initElements(driver, this);
    }

    public CreateNewOpportunityPage setOpportunityNameField(String opportunityName) {
        opportunityNameField.clear();
        opportunityNameField.sendKeys(opportunityName);
        return this;
    }

    public CreateNewOpportunityPage setOpportunityCloseDate(String closeDateValue) {
        opportunityCloseDateField.clear();
        opportunityCloseDateField.sendKeys(closeDateValue);
        return this;
    }

    public CreateNewOpportunityPage setOpportunityStage(String stageValue){
        new Select(opportunityStageField).selectByVisibleText(stageValue);
        return this;
    }

    public AccountNameLookupPage clickAccountNameLookUpButton()
    {
        accountNameLookupButton.click();
        return new AccountNameLookupPage(driver);
    }

    public OpportunityDetailPage clickSaveButton()
    {
        saveButton.click();
        return new OpportunityDetailPage(driver);
    }
}

