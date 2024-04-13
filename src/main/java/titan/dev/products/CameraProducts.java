package titan.dev.products;

import titan.dev.util.ProductUtils;
import titan.dev.util.Utilities;

import static titan.dev.base.TestBase.ProductsPage;
import static titan.dev.base.TestBase.log;
import static titan.dev.util.Utilities.click;
import static titan.dev.util.Utilities.getText;

public final class CameraProducts {

    private CameraProducts() {
    }

    public static void createNikonCameraProductOrder() {

        click(ProductsPage.cameraMenu);
        click(ProductsPage.nikonCamera);
        String ProductCount = getText(ProductsPage.cartValue);
        log.info(ProductCount);
        if (ProductCount.equalsIgnoreCase("0 item(s) - $0.00")) {
            click(ProductsPage.addToCart);
        } else {
            click(ProductsPage.cartValue);
            click(ProductsPage.emptyCart);
            click(ProductsPage.addToCart);
        }
        Utilities.wait(ProductsPage.checkoutOrderButton);
        click(ProductsPage.checkoutOrderButton);
        //click(ProductsPage.finalCheckoutOrderButton);
        log.info("Item Successfully added");
       // ProductUtils.ConfirmOrder();
        log.info("Camera order Successfully placed");
    }


}


