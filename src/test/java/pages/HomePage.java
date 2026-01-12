package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.UiUtils;

@Getter
public class HomePage extends BasePage{

    @FindBy(xpath = "//a[@id='wt-cli-accept-all-btn']")
    private WebElement acceptButtonOnTheCookie;

    @FindBy(css = "header#navigation")
    private WebElement header;

    @FindBy(css = "footer#footer")
    private WebElement footer;

    public void tapOnAcceptButtonOnTheCookie() {
        UiUtils.click(acceptButtonOnTheCookie);
    }

}
