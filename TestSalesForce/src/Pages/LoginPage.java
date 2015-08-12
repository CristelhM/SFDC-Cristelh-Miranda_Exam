package Pages;

import Framework.Browser.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Cristelh Miranda on 8/10/2015.
 */

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "username")
    @CacheLookup
    WebElement userNameField;

    @FindBy(id = "password")
    @CacheLookup
    WebElement passwordTxt;

    @FindBy(id = "Login")
    @CacheLookup
    WebElement loginField;

    public LoginPage()
    {
        driver = WebDriverManager.getInstance().getDriver();
        wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public LoginPage setUserNameField(String email) {
        userNameField.clear();
        userNameField.sendKeys(email);
        return this;
    }

    public LoginPage setPasswordField(String password) {
        passwordTxt.clear();
        passwordTxt.sendKeys(password);
        return this;
    }

    public TabBar clickLogInToSalesforceButton() {
        loginField.click();
        return new TabBar();
    }
}
