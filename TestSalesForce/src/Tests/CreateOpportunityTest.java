package Tests;

import Framework.Browser.WebDriverManager;

import Pages.LoginPage;
import Pages.OpportunityDetailPage;
import Pages.TabBar;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;

import static java.lang.Thread.sleep;

/**
 * Created by Cristelh Miranda on 8/10/2015.
 */
public class CreateOpportunityTest {
    LoginPage login;
    TabBar tabBar;
    OpportunityDetailPage opportunityDetailPage;

    Date currentDate;
    long unixTimeStamp;

    String opportunityName = "Opportunity";
    String accountName = "AccountName";
    String closeDate = "8/10/2015";
    String stage = "Prospecting";

    String browser = "Firefox";
    String baseUrl = "https://login.salesforce.com/";

    @BeforeMethod
    public void setUp() {

        WebDriverManager.getInstance().setBaseUrl(baseUrl);
        WebDriverManager.getInstance().setBrowser(browser);

        // Variables to get unix timestamp this will
        //  be added to Account name in order to have unique names
        // this is needed to be set here, in order to send the
        // accountName and Opportunity to other methods since it
        // changes constantly.
        currentDate = new Date();
        unixTimeStamp = currentDate.getTime()/1000;

        accountName = accountName + unixTimeStamp;
        opportunityName =opportunityName + unixTimeStamp;

        tabBar = new LoginPage()
                .setUserNameField("cristelhmiranda@gmail.com")
                .setPasswordField("Control123")
                .clickLogInToSalesforceButton();

        tabBar.clickAccountTab()
                .clickCreateNewAccountButton()
                .setAccountNameTxt(accountName)
                .clickSaveButton();
    }

    @Test
    public void testUntitled() {
        opportunityDetailPage = tabBar
                .clickOpportunityTab()
                .clickCreateNewOpportunityButton()
                .setOpportunityNameField(opportunityName)
                .setOpportunityCloseDate(closeDate)
                .setOpportunityStage(stage)
                .clickAccountNameLookUpButton()
                .selectAnAccountInTheTable(accountName)
                .clickSaveButton();

        Assert.assertEquals(opportunityDetailPage.getOpportunityName(), opportunityName);
        Assert.assertEquals(opportunityDetailPage.getCloseDate(), closeDate);
        Assert.assertEquals(opportunityDetailPage.getStage(), stage);
    }

    @AfterMethod
    public void tearDown() {
        opportunityDetailPage.clickDeleteButton();
        new TabBar().clickAccountTab().selectAccount(accountName).clickDeleteButton();
    }
}
