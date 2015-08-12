package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.Set;


/**
 * Created by Cristelh Miranda on 8/10/2015.
 */

public class AccountNameLookupPage{
    private WebDriver driver;
    private WebDriverWait wait;

    CommonMethods commonMethods;

    @FindBy(id = "searchFrame")
    @CacheLookup
    private WebElement frameIDSearch;

    @FindBy(id = "resultsFrame")
    @CacheLookup
    private WebElement frameIDResult;

    @FindAll({@FindBy(className = "list"),@FindBy(tagName = "table")})
    @CacheLookup
    private WebElement recentlyViewerAccountTable;

    private String AccountBrowserId;

    public AccountNameLookupPage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
        commonMethods = new CommonMethods(driver);

        AccountBrowserId = driver.getWindowHandle();

        commonMethods.switchBrowser();

        try {
            wait.until(ExpectedConditions
                    .frameToBeAvailableAndSwitchToIt(frameIDSearch));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    public CreateNewOpportunityPage selectAnAccountInTheTable(String accountName)
    {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIDResult));
        driver.findElement(By.linkText(accountName)).click();
        driver.switchTo().window(AccountBrowserId);
        return new CreateNewOpportunityPage(driver);
    }
}