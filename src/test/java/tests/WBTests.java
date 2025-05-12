package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;

import static data.DataForWB.CART_LINK;
import static data.DataForWB.PRODUCT_NAME;

public class WBTests extends BaseTest {

    private ProductPage page;

    @BeforeMethod
    public void openPage() {
        page = new ProductPage(driver).openPage();
    }

    @Test
    public void checkCardTest() {
        page.addProductToCart()
                .isAddToCardButtonInvisible()
                .goToCart()
                .checkOpen()
                .checkProduct(PRODUCT_NAME);
    }

    @AfterMethod
    public void clearCart() {
        driver.get(CART_LINK);
        new CartPage(driver).clearCart();
    }

}