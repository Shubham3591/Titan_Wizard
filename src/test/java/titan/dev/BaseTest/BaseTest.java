package titan.dev.BaseTest;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import titan.dev.base.TestBase;

public class BaseTest extends TestBase {



    @BeforeClass

        public void loginToApp()  {

        TestBase.doInitializationWin();
        LoginPage.doInit();



    }

    @AfterClass
    public void logoutApp() {
        LogoutPage.doLogout_USME11();
        //LogoutPage.closeBrowser();
       // BrowserFactory.driver.remove();
    }
}
