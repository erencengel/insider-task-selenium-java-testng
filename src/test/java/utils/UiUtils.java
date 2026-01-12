package utils;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static utils.Constants.DEFAULT_TIMEOUT;

public class UiUtils {

    private static final Logger logger = LoggerHelper.getLogger(UiUtils.class);

    public static void navigateTo(String url) {
        try {
            Driver.get().get(url);
            logger.info("navigated to the {}", url);
        } catch (Exception e) {
            logger.error("navigation failed to {}", url, e);
            throw e;
        }
    }

    public static void click(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    public static void waitForVisibilityOfAllElements(List<WebElement> list) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfAllElements(list));
    }

    public static String getText(WebElement element) {
        return element.getText();
    }

    public static void closeDropdownIfOpen() {
        new Actions(Driver.get())
                .moveByOffset(0, 0)
                .click()
                .perform();
    }

    public static void waitUntilGivenElementsContainsExpectedText(By by, String text) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), DEFAULT_TIMEOUT);
        wait.until(d -> d.findElements(by).stream().allMatch(n -> UiUtils.getText(n).contains(text)));
    }

    public static void swapBetweenWindows() {
        WebDriverWait wait = new WebDriverWait(Driver.get(), DEFAULT_TIMEOUT);
        String currentWindow = Driver.get().getWindowHandle();
        wait.until(driver -> driver.getWindowHandles().size() > 1);
        for (String window : Driver.get().getWindowHandles()) {
            if (!window.equals(currentWindow)) {
                Driver.get().switchTo().window(window);
                break;
            }
        }
    }

}
