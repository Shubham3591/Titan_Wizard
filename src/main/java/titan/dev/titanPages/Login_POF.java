package titan.dev.titanPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import titan.dev.base.TestBase;
import titan.dev.util.Utilities;


import static titan.dev.util.Utilities.click;


public class Login_POF extends TestBase {

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    public WebElement myAccount;

    @FindBy(xpath = "//a[normalize-space()='Login']")
    public WebElement myAccountLogin;

    @FindBy(xpath = "//input[@id='input-email']")
    public WebElement userNameField;

    @FindBy(xpath = "//input[@id='input-password']")
    public WebElement passwordField;

    @FindBy(xpath = "//input[@value='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"login-section\"]/h1")
    public WebElement loginText;


    public Login_POF(WebDriver driver) {
        this.driver=driver;
    }

    public static void doInit(String username, String password) {

        try {
            doInitializationWin();
            click(LoginPage.myAccount);
            click(LoginPage.myAccountLogin);
            Utilities.doLogin(username, password);
            Utilities.wait(HomePage.showingResultsText);
        } catch (Exception e) {
          //  Utilities.getScreenshot("LoginFailure");
            System.err.println("Exception captured in doInit Method" + e);
            Assert.fail("");
        }
    }


    public static void doInit() {

        try {

            String username = configurationfile.getProperty("Username");
            String password = configurationfile.getProperty("Password");

            //click(LoginPage.myAccount);
            //click(LoginPage.myAccountLogin);
            Utilities.doLogin(username, password);
            Utilities.wait(HomePage.showingResultsText);
        } catch (Exception e) {
           // getScreenshot("LoginFailure");
            System.err.println("Exception captured in doInit Method " + e);
            Assert.fail("");
        }
    }
}
