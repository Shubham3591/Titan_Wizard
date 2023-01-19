package titan.dev.productTest;

import org.testng.annotations.Test;
import titan.dev.BaseTest.BaseTest;
import titan.dev.products.CameraProducts;

public final class CameraProductsTest extends BaseTest {
    private CameraProductsTest(){}

    @Test(enabled = true)
    public void CameraProductsTest()  {
        CameraProducts.createNikonCameraProductOrder();
        log.info("CameraProductsTest Passed Successfully");

    }
}
