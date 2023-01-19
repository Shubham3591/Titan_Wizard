package titan.dev.homeSuiteTest;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import titan.dev.util.Utilities;


import static titan.dev.base.TestBase.LoginPage;
import static titan.dev.base.TestBase.log;


class LoginTest {
    @DataProvider(name = "Login-TestData")
    public Object[][] getLoginTestData() throws InvalidFormatException {
        String sheetName = "LoginCredentials";
        Object data[][] = Utilities.getTestData(sheetName);
        return data;
    }

    @Test(enabled = true, dataProvider = "Login-TestData")
    public void LoginTest(String username, String password) {
        LoginPage.doInit(username, password);
        log.info("Logged In To Application SuccessFully");
    }

}
