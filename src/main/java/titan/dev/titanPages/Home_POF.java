package titan.dev.titanPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import titan.dev.base.TestBase;

public class Home_POF extends TestBase {

    @FindBy(xpath = "//a[@id='create-new-order']//i[@class='fas fa-plus']")
    public WebElement CreateOrder_Wizard;

    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    public WebElement showingResultsText;


    @FindBy(css = "img[alt='Logo']")
    public WebElement DashboardLogo;


    @FindBy(xpath = "//*[@id=\"order-table\"]/tbody/tr/td[1]/a")
    public WebElement OrderNumberinHomePage;

    @FindBy(xpath = "//li[@class='gtm_nav_searchcontext_orders']")
    public WebElement HighlightedOrderNumberDisplayedOnGlobalSearchedList;


    @FindBy(xpath = "//span[normalize-space()='Quick Search']")
    public WebElement QuickSearch;

    @FindBy(xpath = "//span[@data-bind='text: $data.title'][normalize-space()='Orders']")
    public WebElement OrdersTab;

    @FindBy(xpath = "//span[@class='updated']")
    public WebElement UpdatedText;


    public Home_POF(WebDriver driver) {
        this.driver=driver;
    }

}
