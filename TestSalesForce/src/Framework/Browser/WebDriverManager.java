package Framework.Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Cristelh Miranda on 8/10/2015.
 */
public class WebDriverManager {

    private WebDriver driver;
    private WebDriverWait wait;
    private static WebDriverManager instance;
    //by default will use this in case not setUp
    private static final int TIMEOUT_NORMAL = 15;
    //by default will use this in case not setUp
    private String browser = "Firefox";

    private WebDriverManager() {
        initializeWebDriver();
    }

    public static WebDriverManager getInstance() {
        if (instance == null) {
            instance = new WebDriverManager();
        }
        return instance;
    }

    private void initializeWebDriver() {

        openBrowser();

        driver.manage().timeouts().implicitlyWait(TIMEOUT_NORMAL, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, TIMEOUT_NORMAL);

    }

    private void openBrowser() {

        if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("IE")) {
            driver = new InternetExplorerDriver();
        } else if (browser.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        } else {
            System.out.println("Not supported browser");
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void setBaseUrl(String baseUrl){
        driver.get(baseUrl);
    }

    public void setBrowser(String browser){
        this.browser = browser;
    }

}