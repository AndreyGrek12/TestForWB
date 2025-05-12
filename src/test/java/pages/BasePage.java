package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static helpers.Waiters.waitForVisibility;

public class BasePage {

    protected final WebDriver driver;
    private static final int WAITING_TIME = 10;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void click(WebElement element) {
        waitForVisibility(WAITING_TIME, driver, element).click();
    }

    protected String getText(WebElement element) {
        return waitForVisibility(WAITING_TIME, driver, element).getText();
    }

}
