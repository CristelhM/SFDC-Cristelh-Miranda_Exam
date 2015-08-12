package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Cristelh Miranda on 8/11/2015.
 */
public class CommonMethods {
    private WebDriver driver;
    private WebDriverWait wait;

    public CommonMethods(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public void switchToAlertMessage(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void switchBrowser()
    {
        Set<String> setWindows = driver.getWindowHandles();
        LinkedList<String> listWindows = new LinkedList<String>(setWindows);
        driver.switchTo().window(listWindows.getLast());
    }
}
