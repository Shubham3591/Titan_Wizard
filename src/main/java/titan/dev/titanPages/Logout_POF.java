package titan.dev.titanPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import titan.dev.base.TestBase;
import titan.dev.util.Utilities;

import static titan.dev.util.Utilities.click;
import static titan.dev.util.Utilities.loadUrl;

public class Logout_POF extends TestBase {

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    public WebElement logoutButton;

    public Logout_POF(WebDriver driver) {
        this.driver=driver;  }

    public static void doLogout_USME11() {
        try {
            loadUrl();
            click(LoginPage.myAccount);
            click(LogoutPage.logoutButton);
            System.out.println("Log out Button clicked");
        } catch (WebDriverException e) {
            System.err.println("Exception captured inside doLogout Method " + e);
            Assert.fail("");
        }
    }


    public static void closeBrowser() {
        try {
            driver.close();
            driver.quit();
            System.out.println("Browser Closed");
            Utilities.deleteFolder();
        } catch (WebDriverException e) {
            System.err.println("Exception captured inside closeBrowser Method " + e);
            Assert.fail("");
        }
    }
}
