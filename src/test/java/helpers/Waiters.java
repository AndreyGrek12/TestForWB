package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiters {

    public static Boolean waitForAttributeContains(int duration, WebDriver driver, WebElement element,
                                                   String attributeName, String partOfAttribute) {
        return new WebDriverWait(driver, Duration.ofSeconds(duration))
                .until(ExpectedConditions.attributeContains(element, attributeName, partOfAttribute));
    }

    public static WebElement waitForVisibility(int duration, WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(duration)).until(ExpectedConditions.visibilityOf(element));
    }

}
