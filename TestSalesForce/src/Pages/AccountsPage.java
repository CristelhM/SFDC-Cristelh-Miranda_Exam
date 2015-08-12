package Pages;

import Framework.Browser.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Cristelh Miranda on 8/10/2015.
 */
public class AccountsPage extends UIElements {

    WebDriver driver;
    WebDriverWait wait;

    public AccountsPage(WebDriver driver)
    {
        this.driver = driver;
        wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public CreateNewAccountPage clickCreateNewAccountButton() {
        newButton.click();
        return new CreateNewAccountPage(driver);
    }
    public AccountDetailPage selectAccount(String accountName){
        driver.findElement(By.linkText(accountName)).click();
        return new AccountDetailPage(driver);
    }

}
