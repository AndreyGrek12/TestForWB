package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static data.DataForWB.CART_LINK;

public class CartPage extends BasePage {

    @FindAll(@FindBy(className = "list-item__wrap"))
    private List<WebElement> productList;

    @FindBy(className = "good-info__good-name")
    private WebElement productNameElement;

    @FindAll(@FindBy(className = "btn__del"))
    private List<WebElement> deleteProductButtons;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage openPage() {
        driver.get(CART_LINK);
        checkOpen();
        return this;
    }

    public CartPage checkOpen() {
        Assert.assertEquals(driver.getCurrentUrl(),
                CART_LINK,
                "Открыта неверная страница");
        return this;
    }

    public void checkProduct(String productName) {
        Assert.assertEquals(productList.size(),
                1,
                "Количество товаров в списке не совпадает");
        Assert.assertEquals(getText(productNameElement),
                productName,
                "В корзину попал неверный товар");
    }

    public void clearCart() {
        if (!deleteProductButtons.isEmpty()) {
            deleteProductButtons.forEach(WebElement::click);
        }
    }

}