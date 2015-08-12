package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Cristelh Miranda on 8/12/2015.
 */
public class OpportunityDetailPage extends UIElements {
    private WebDriver driver;
    private WebDriverWait wait;
    CommonMethods commonMethods;
    private String browserId;


    @FindBy(id = "opp3_ileinner")
    @CacheLookup
    private WebElement OppName;

    @FindBy(id = "opp9_ileinner")
    @CacheLookup
    private WebElement OppCloseDate;

    @FindBy(id = "opp11_ileinner")
    @CacheLookup
    private WebElement OppStage;


    public OpportunityDetailPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
        browserId = driver.getWindowHandle();
        commonMethods = new CommonMethods(driver);
    }

    public OpportunitiesPage clickDeleteButton()
    {
        wait = new WebDriverWait(driver, 15);
        deleteButton.click();
        commonMethods.switchToAlertMessage();
        driver.switchTo().window(browserId);
        return new OpportunitiesPage(driver);
    }

    public String getOpportunityName()
    {
        return OppName.getText();
    }

    public String getCloseDate()
    {
        return OppCloseDate.getText();
    }

    public String getStage()
    {
        return OppStage.getText();
    }
}
