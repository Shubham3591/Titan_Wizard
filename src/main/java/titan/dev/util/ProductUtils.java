package titan.dev.util;

import org.testng.Assert;

import static titan.dev.frameworkConstants.Constants.DELIVERYCOMMENTS;
import static titan.dev.frameworkConstants.Constants.PAYMENTMETHODCOMMENTS;
import static titan.dev.util.Utilities.*;

public final class ProductUtils {
    private ProductUtils() {
    }

    public static void ConfirmOrder() {
        click(ProductsPage.billingDetailsContinueButton);
        click(ProductsPage.deliveryDetailsContinueButton);
        Type(ProductsPage.commentsDeliveryMethod, DELIVERYCOMMENTS);
        click(ProductsPage.deliveryMethodContinueButton);
        Type(ProductsPage.commentsPaymentMethod, PAYMENTMETHODCOMMENTS);
        click(ProductsPage.termsAndConditionCheckbox);
        click(ProductsPage.paymentMethodContinueButton);
        click(ProductsPage.confirmOrderButton);
        System.out.println("Order Successfully confirmed");
        String orderConfirmationText = getText(ProductsPage.orderConfirmationText);
        String expText = "Your order has been placed!";
        Assert.assertEquals(orderConfirmationText, expText);
    }
}



