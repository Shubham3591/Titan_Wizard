package titan.dev.homeSuiteTest;

import org.testng.annotations.Test;

import static titan.dev.base.TestBase.LogoutPage;

public class LogoutTest {
    @Test(enabled = true)
    public void VerifyLogoutTest() {
        LogoutPage.doLogout_USME11();
        LogoutPage.closeBrowser();
    }
}
