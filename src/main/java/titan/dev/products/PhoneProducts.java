package titan.dev.products;

import titan.dev.util.ProductUtils;
import titan.dev.util.Utilities;

import static titan.dev.base.TestBase.ProductsPage;
import static titan.dev.util.Utilities.click;
import static titan.dev.util.Utilities.getText;

public final class PhoneProducts {
    private PhoneProducts() {
    }

    public static void createIphoneProductOrder() {

        click(ProductsPage.phoneMenu);
        click(ProductsPage.Iphone);
        String ProductCount = getText(ProductsPage.cartValue);
        System.out.println(ProductCount);
        if (ProductCount.equalsIgnoreCase("0 item(s) - $0.00")) {
            click(ProductsPage.addToCart);
        } else {
            click(ProductsPage.cartValue);
            click(ProductsPage.emptyCart);
            click(ProductsPage.addToCart);
        }
        Utilities.wait(ProductsPage.checkoutOrderButton);
        click(ProductsPage.checkoutOrderButton);
        System.out.println("Item Successfully added");
        ProductUtils.ConfirmOrder();
        System.out.println("Iphone order Successfully placed");

    }
}
