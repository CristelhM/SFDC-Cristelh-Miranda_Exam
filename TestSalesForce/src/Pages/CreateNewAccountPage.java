package Pages;

import Framework.Browser.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;


/**
 * Created by Cristelh Miranda on 8/12/2015.
 */
public class CreateNewAccountPage extends UIElements {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "acc2")
    @CacheLookup
    private WebElement accountNameTxt;

    public CreateNewAccountPage(WebDriver driver)
    {
        this.driver = driver;
        wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public CreateNewAccountPage setAccountNameTxt(String accountName)
    {
        accountNameTxt.clear();
        accountNameTxt.sendKeys(accountName);
        return this;
    }

    public AccountDetailPage clickSaveButton()
    {
        saveButton.click();
        return new AccountDetailPage(driver);
    }
}