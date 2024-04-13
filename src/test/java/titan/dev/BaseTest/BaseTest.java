package titan.dev.BaseTest;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import titan.dev.base.TestBase;

public class BaseTest extends TestBase {



    @BeforeSuite
        public void loginToApp()  {
        TestBase.doInitializationWin();
        LoginPage.doInit();



    }

    @AfterSuite
    public void logoutApp() {
        LogoutPage.doLogout_USME11();
        LogoutPage.closeBrowser();
       // BrowserFactory.driver.remove();
    }
}
