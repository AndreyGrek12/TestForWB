package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static data.DataForWB.PRODUCT_CARD_LINK;
import static helpers.Waiters.waitForAttributeContains;

public class ProductPage extends BasePage {

    @FindBy(css = ".product-page__aside .btn-main")
    protected WebElement addToCardButton;

    @FindBy(css = ".product-page__aside .j-go-to-basket")
    protected WebElement cartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage openPage() {
        driver.get(PRODUCT_CARD_LINK);
        checkOpen(driver);
        return this;
    }

    public void checkOpen(WebDriver driver) {
        Assert.assertEquals(driver.getCurrentUrl(),
                PRODUCT_CARD_LINK,
                "Открыта неверная ссылка");
    }

    public ProductPage addProductToCart() {
        click(addToCardButton);
        return this;
    }

    public ProductPage isAddToCardButtonInvisible() {
        Assert.assertTrue(waitForAttributeContains(10, driver, addToCardButton, "class", "hide"));
        return this;
    }

    public CartPage goToCart() {
        click(cartButton);
        return new CartPage(driver);
    }

}