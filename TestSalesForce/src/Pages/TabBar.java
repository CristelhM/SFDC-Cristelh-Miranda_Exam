package Pages;

import Framework.Browser.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Cristelh Miranda on 8/10/2015.
 */
public class TabBar {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "home_Tab")
    @CacheLookup
    WebElement tabBar;

    @FindBy(id = "Opportunity_Tab")
    @CacheLookup
    WebElement OpportunityTab;

    @FindBy(id = "Account_Tab")
    @CacheLookup
    WebElement AccountTab;

    public TabBar()
    {
        //this.driver = driver;
        driver = WebDriverManager.getInstance().getDriver();
        wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public OpportunitiesPage clickOpportunityTab() {
        OpportunityTab.findElement(By.linkText("Opportunities")).click();
        return new OpportunitiesPage(driver);
    }

    public AccountsPage clickAccountTab() {
        AccountTab.findElement(By.linkText("Accounts")).click();
        return new AccountsPage(driver);
    }
}

