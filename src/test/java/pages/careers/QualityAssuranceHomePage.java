package pages.careers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.UiUtils;

public class QualityAssuranceHomePage extends BasePage {

    @FindBy(xpath = "//a[text()='See all QA jobs']")
    private WebElement seeAllQAJobsButton;

    public void tapOnSeeAllQAJobsButton() {
        UiUtils.click(seeAllQAJobsButton);
    }

}
