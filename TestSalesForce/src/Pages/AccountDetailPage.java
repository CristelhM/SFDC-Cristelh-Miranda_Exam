package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Cristelh Miranda on 8/12/2015.
 */

public class AccountDetailPage extends UIElements {
    private WebDriver driver;
    private WebDriverWait wait;
    CommonMethods commonMethods;

    public AccountDetailPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
        commonMethods = new CommonMethods(driver);
    }

    public AccountDetailPage clickDeleteButton()
    {
        deleteButton.click();
        commonMethods.switchToAlertMessage();
        return this;
    }
}
