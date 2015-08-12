package Pages;

import Framework.Browser.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;
import java.util.List;

/**
 * Created by Cristelh Miranda on 8/10/2015.
 */

public class OpportunitiesPage extends UIElements {
    WebDriver driver;
    WebDriverWait wait;
    CommonMethods commonMethods;

    public OpportunitiesPage(WebDriver driver)
    {
        this.driver = driver;

        wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
        commonMethods = new CommonMethods(driver);

    }

    public CreateNewOpportunityPage clickCreateNewOpportunityButton() {
        newButton.click();
        return new CreateNewOpportunityPage(driver);
    }

    public OpportunityDetailPage selectOpportunity(String opportunityName){
        driver.findElement(By.linkText(opportunityName)).click();
        return new OpportunityDetailPage(driver);
    }

    public OpportunitiesPage clickDeleteButton()
    {
        deleteButton.click();
        commonMethods.switchToAlertMessage();
        return new OpportunitiesPage(driver);
    }

}