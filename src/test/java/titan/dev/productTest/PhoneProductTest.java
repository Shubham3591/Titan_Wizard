package titan.dev.productTest;

import org.testng.annotations.Test;
import titan.dev.BaseTest.BaseTest;
import titan.dev.products.PhoneProducts;




public final class PhoneProductTest extends BaseTest {
    private PhoneProductTest(){}

    @Test(enabled = true)
    public void phoneProductsTest()  {
        PhoneProducts.createIphoneProductOrder();
        log.info("Phone Product Ordered Successfully");
    }


}
