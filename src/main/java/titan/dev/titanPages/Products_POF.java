package titan.dev.titanPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import titan.dev.base.TestBase;

public class Products_POF extends TestBase {

    @FindBy(xpath = "//a[normalize-space()='Cameras']")
    public WebElement cameraMenu;

    @FindBy(xpath = "//div[@class='caption']//a[contains(text(),'Nikon D300')]")
    public WebElement nikonCamera;

    @FindBy(xpath = "//button[@id='button-cart']")
    public WebElement addToCart;

    @FindBy(xpath = "//span[@id='cart-total']")
    public WebElement cartValue;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    public WebElement successAddToCartMessage;

    @FindBy(xpath = "//span[normalize-space()='Checkout']")
    public WebElement checkoutOrderButton;


    @FindBy(xpath = "//a[@class='btn btn-primary']")
    public WebElement finalCheckoutOrderButton;

    @FindBy(xpath = "//input[@id='button-payment-address']")
    public WebElement billingDetailsContinueButton;

    @FindBy(xpath = "//input[@id='button-shipping-address']")
    public WebElement deliveryDetailsContinueButton;

    @FindBy(xpath = "//input[@id='button-shipping-method']")
    public WebElement deliveryMethodContinueButton;

    @FindBy(xpath = "//input[@id='button-payment-method']")
    public WebElement paymentMethodContinueButton;

    @FindBy(xpath = "//textarea[@name='comment']")
    public WebElement commentsDeliveryMethod;

    @FindBy(xpath = "//div[@id='collapse-payment-method']//textarea[@name='comment']")
    public WebElement commentsPaymentMethod;

    @FindBy(xpath = "//input[@name='agree']")
    public WebElement termsAndConditionCheckbox;

    @FindBy(xpath = "//input[@id='button-confirm']")
    public WebElement confirmOrderButton;

    @FindBy(xpath = "//h1[normalize-space()='Your order has been placed!']")
    public WebElement orderConfirmationText;

    @FindBy(xpath = "//i[@class='fa fa-times']")
    public WebElement emptyCart;

    @FindBy(xpath = "//a[normalize-space()='Phones & PDAs']")
    public WebElement phoneMenu;

    @FindBy(xpath = "//a[normalize-space()='iPhone']")
    public WebElement Iphone;

    public Products_POF(WebDriver driver) {
        this.driver=driver;   }

}
