package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Cristelh Miranda on 8/12/2015.
 */
abstract class UIElements {

    @FindBy(css = "input[value='Delete']")
    @CacheLookup
    protected WebElement deleteButton;

    @FindBy(name = "edit")
    @CacheLookup
    private WebElement editButton;

    @FindBy(name = "save")
    @CacheLookup
    protected WebElement saveButton;

    @FindBy(name = "new")
    @CacheLookup
    protected WebElement newButton;
}
