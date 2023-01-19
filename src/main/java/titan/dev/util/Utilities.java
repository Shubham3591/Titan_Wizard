package titan.dev.util;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import titan.dev.base.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import static titan.dev.frameworkConstants.FrameworkPathConstants.FILEUPLOADPATH;
import static titan.dev.frameworkConstants.FrameworkPathConstants.RESOURCESPATH;


public final class Utilities extends TestBase {
    public static File file;
    /**
     * This method intailize excel sheet and read/write data fron excel sheet
     *
     * @author: Shubham
     */

    public static String TESTDATA_SHEET_PATH = (System.getProperty("user.dir") + "\\src\\main\\java\\titan\\dev\\TestDataExcel\\TitanDevTestdata.xlsx");
    static String timeStamp;
    static Workbook book;
    static Sheet sheet;


    public static void doLogin(String userData, String passwordData) {

        try {
            String expText;
            expText = "My Account";
            Type(LoginPage.userNameField, userData);
            Type(LoginPage.passwordField, passwordData);
            click(LoginPage.loginButton);
            String actualText = getText(HomePage.showingResultsText);
            Assert.assertEquals(actualText, expText);
        } catch (Exception e) {
            Assert.fail("doLogin Method failed");
        }
    }


 /*    public static void EmailResults() throws FileNotFoundException, EmailException {
     DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
     LocalDateTime now = LocalDateTime.now();
     EmailAttachment attachment = new EmailAttachment();
     if(OsName.contains("windows")) {
     attachment.setPath(System.getProperty("user.dir") +"\\target\\surefire-reports\\FullRegression\\AllTests.html");
     //attachment.setPath(System.getProperty("user.dir") +"\\target\\surefire-reports\\emailable-report.html");

     } else {
     attachment.setPath(System.getProperty("user.dir") +"//test-output//emailable-report.html");
     }
     attachment.setDisposition(EmailAttachment.ATTACHMENT);
     attachment.setDescription("TitanUI CoreTest Report " + dtf.format(now));
     MultiPartEmail email = new MultiPartEmail();
     email.setHostName("secure.emailsrvr.com");
     email.setSmtpPort(995);
     email.setAuthentication("gokul.athi@fpsinc.com", "R_8wMg3Drf");
     email.setSSL(true); email.setFrom("gokul.athi@fpsinc.com");

     email.setSubject("Selenium Test Results");
     email.setMsg(" This is an automated message - Please do not reply");
     //email.addTo("gokul.athi@fpsinc.com");
         email.addTo("sundar@fpsinc.com");
     email.attach(attachment);
     email.send();
     System.out.println("Test Results Email Sent");
     }*/

    /**
     * This method verify that user is not Logged into Application when invalid login credential is entered
     *
     * @author: Shubham
     */


    public static void doNotLogin(String Username, String Password) {
        try {
            String expText, actualText;
            expText = "Log into IDEA Titan";
            Type(LoginPage.userNameField, Username);
            Type(LoginPage.passwordField, Password);
            click(LoginPage.loginButton);
            actualText = getText(LoginPage.loginText);
            Assert.assertEquals(actualText, expText, "User is not in Login Page");
            System.out.println("InValid Login Credential");
        } catch (Exception e) {
            System.out.println("Exception captured inside LogIn Method \n" + e);
            Assert.fail("doNotLogin method failed ");
        }
    }


    public static void loadUrl() {
        driver.get(configurationfile.getProperty("url"));
        driver.getPageSource().contains("404");
        driver.getPageSource().contains("not found");

    }


   /* public static void getScreenshot(String filename) {

            File a = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(Calendar.getInstance().getTime());
        try {
            FileHandler.copy(a, new File(
                    System.getProperty("user.dir") + "\\screenshots\\" + filename + "_" + timeStamp + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/

    public static void AddFile(int ButtonBeginValue, int ButtonEndValue) {
        List<WebElement> allButtons = driver.findElements(By.xpath("//input[@type='file']"));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        int count = 1, button;
        String percent;
        for (button = ButtonBeginValue; button < ButtonEndValue; button++) {
            allButtons.get(button).sendKeys(FILEUPLOADPATH);
            String btnPath = "(//*[text()='100%'])[" + count + "]";
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(btnPath)));
            percent = driver.findElement(By.xpath(btnPath)).getText();
            if (percent.equals("100%")) {
                System.out.println("File Uploaded");
            }
            count++;
        }
    }

    public static void AddZipVideoPdfFiles(int ButtonBeginValue, int ButtonEndValue, String FileName) {
        List<WebElement> allButtons = driver.findElements(By.xpath("//input[@type='file']"));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        int count = 1, button;
        String percent;
        for (button = ButtonBeginValue; button < ButtonEndValue; button++) {
            allButtons.get(button).sendKeys(RESOURCESPATH + FileName);
            String btnPath = "(//*[text()='100%'])[" + count + "]";
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(btnPath)));
            percent = driver.findElement(By.xpath(btnPath)).getText();
            if (percent.equals("100%")) {
                System.out.println("File Uploaded");
            }
            count++;
        }
    }

    public static void AddSingleFile(int ButtonBeginValue, int ButtonEndValue) {
        WebElement element = driver.findElement(By.xpath("//input[@type='file']"));
        element.sendKeys(FILEUPLOADPATH);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        String btnPath = "//*[text()='100%']";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(btnPath)));
        System.out.println("File status " + driver.findElement(By.xpath(btnPath)).getText());
        System.out.println("File Uploaded");
    }


    public static void UploadStatus() {
        try {
            List<WebElement> uploadStats = driver.findElements(By.xpath("//b/span"));
            WebDriverWait wait = new WebDriverWait(driver, 30);
            String percent;
            for (WebElement uploadStat : uploadStats) {
                String btnPath = uploadStat.toString();
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(btnPath)));
                percent = driver.findElement(By.xpath(btnPath)).getText();
                if (percent.equals("100%")) {
                    System.out.println("File Uploaded");
                }
            }
        } catch (Exception exception) {
            System.out.println("Exception captured in Upload Status method \n" + exception);
        }
    }


    public static Object[][] getTestData(String sheetName) throws InvalidFormatException {
        FileInputStream file = null;
        try {
            file = new FileInputStream(TESTDATA_SHEET_PATH);
        } catch (Exception e) {
            System.err.println("Exception captured inside Logout Method \n" + e);
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (Exception e) {
            System.err.println("Exception captured inside Logout Method \n" + e);
        }

        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        //System.out.println(sheet.getLastRowNum() + "--------");
        sheet.getRow(0).getLastCellNum();
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                //data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
                String str = sheet.getRow(i + 1).getCell(k).toString();
                data[i][k] = str.replace(".0", "");
                //System.out.println(data[i][k]);
            }
        }
        return data;
    }

    /**
     * This method selects the required value from dropdown
     *
     * @author: Shubham
     */
    public static void fn_Select(WebElement WE, String VisibleText) {
        Select selObj = new Select(WE);
        selObj.selectByVisibleText(VisibleText);
    }


    public static String generateString() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.substring(0, Math.min(uuid.length(), 10));
        return uuid;
    }

    public static void setUp() {
        File listOfFile[] = folder.listFiles();
        Assert.assertTrue(listOfFile.length > 0, "File Not Downloaded ");
        for (File file : folder.listFiles()) {
            Assert.assertTrue(listOfFile.length > 0, "File Not Downloaded ");
            file.delete();
        }
    }

    public static void deleteFolder() {
        folder.delete();
    }


    public static void safeJavaScriptClick(WebElement element) throws Exception {
        try {
            if (element.isEnabled() && element.isDisplayed()) {
                System.out.println("Clicking on element with using java script click");

                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            } else {
                System.out.println("Unable to click on element");
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is not attached to the page document " + e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("Element was not found in DOM " + e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Unable to click on element " + e.getStackTrace());
        }
    }

    public static void safeJavaScriptInput(WebElement element, Date endDate) throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','" + endDate + "')", element);
    }

    public static void scroll(int x) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,'" + x + "')");

    }


    public static void wait(WebElement Element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(Element));
        wait.until(ExpectedConditions.visibilityOf(Element));
    }

    public static void actionClick(WebElement Element) throws InterruptedException {
        Utilities.wait(Element);
        Actions actions = new Actions(driver);
        actions.click(Element);
        //actions.build().perform();

    }

    public static void Cls(WebElement Element) {
        Utilities.wait(Element);
        Element.clear();

    }

    public static void click(WebElement Element) {
        Utilities.wait(Element);
        Element.click();
    }

    public static void Type(WebElement Element, String sendKeyData) {
        Utilities.wait(Element);
        Element.clear();
        Element.sendKeys(sendKeyData);

    }

    public static void IsElementDisplayed(WebElement Element) throws InterruptedException {
        Utilities.wait(Element);
        if (Element.isDisplayed()) {
            System.out.println("Element is Displayed");
        } else {
            System.err.println("Element is not Displayed");
        }
    }

    public static boolean IsElementEnabled(WebElement Element) throws InterruptedException {
        Utilities.wait(Element);
        if (Element.isEnabled()) {
            System.out.println("Element is Displayed");
        } else {
            System.err.println("Element is not Displayed");
        }
        return false;
    }

    public static void IsElementNotDisplayed(WebElement Element) throws InterruptedException {
        Utilities.wait(Element);
        if (Element.isDisplayed()) {
            System.err.println("Element is Displayed");
        } else {
            System.out.println("Element is not Displayed");
        }
    }

    public static String getText(WebElement Element) {
        Utilities.wait(Element);
        return Element.getText();
    }


    public static void tabKeyPress() throws AWTException {
        Robot robot = new Robot();
        robot.delay(500);
        robot.keyPress(KeyEvent.VK_TAB);
    }


}



