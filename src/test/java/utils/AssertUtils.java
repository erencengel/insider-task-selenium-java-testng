package utils;

import org.openqa.selenium.WebElement;

import java.util.List;

public class AssertUtils {

    public static boolean isGivenTextDisplayedInAllElements(List<WebElement> list, String text) {
        return list.stream().allMatch(n -> UiUtils.getText(n).contains(text));
    }

}
