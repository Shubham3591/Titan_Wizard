package titan.dev.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import titan.dev.titanPages.Home_POF;
import titan.dev.titanPages.Login_POF;
import titan.dev.titanPages.Logout_POF;
import titan.dev.titanPages.Products_POF;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import static titan.dev.frameworkConstants.FrameworkPathConstants.CONFIGFILEPATH;


public class TestBase {

    protected static final java.util.UUID UUID = null;
    public static Properties configurationfile;
    public static Login_POF LoginPage;
    public static Logout_POF LogoutPage;
    public static Home_POF HomePage;
    public static Products_POF ProductsPage;
    public static String downloadFileLocation;
    public static File folder;
    public static WebDriver driver;
    public static Logger log;




    public static void doInitializationWin() {
        //WebDriver driver = null;
        try {
            FileInputStream config = new FileInputStream(CONFIGFILEPATH);
            configurationfile = new Properties();
            configurationfile.load(config);
        } catch (FileNotFoundException e) {
            System.err.println("CONFIG FILEPATH Issue");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("CONFIG FILEPATH Issue");
            e.printStackTrace();
        }


        folder = new File(UUID.randomUUID().toString());
        folder.mkdir();


            if (configurationfile.getProperty("browser").equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.setPageLoadStrategy(PageLoadStrategy.EAGER);
                options.addArguments("start-maximized");
                options.addArguments("enable-automation");
                options.addArguments("--remote-allow-origins=*");
                //options.addArguments("--headless");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-infobars");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-browser-side-navigation");
                options.addArguments("--disable-gpu");
                downloadFileLocation = folder.getAbsolutePath();
                HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                chromePrefs.put("profile.default_content_settings.popups", 0);
                chromePrefs.put("download.default_directory", downloadFileLocation);
                options.setExperimentalOption("prefs", chromePrefs);
                driver = new ChromeDriver(options);
                driver.manage().deleteAllCookies();
                // driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
                // driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
                PageFactoryInit();

            } else if (configurationfile.getProperty("browser").equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
                driver.manage().window().maximize();
            } else if (configurationfile.getProperty("browser").equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            }
            driver.get(configurationfile.getProperty("url"));
        }



    static {
        log = Logger.getLogger(TestBase.class);
    }

    protected static void PageFactoryInit () {

            HomePage = PageFactory.initElements(driver, Home_POF.class);
            LoginPage = PageFactory.initElements(driver, Login_POF.class);
            LogoutPage = PageFactory.initElements(driver, Logout_POF.class);
            ProductsPage = PageFactory.initElements(driver, Products_POF.class);
        }


}