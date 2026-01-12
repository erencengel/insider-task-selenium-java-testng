package pages.careers;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.Driver;
import utils.UiUtils;

import java.util.List;

@Getter
public class QualityAssuranceDepartmentPage extends BasePage {

    private final String locationOfJobsXpathLocator = "//div[@id='jobs-list']/div/div/div";

    @FindBy(css = "#filter-by-location")
    private WebElement allLocationsMenu;

    @FindBy(css = "#filter-by-department")
    private WebElement allDepartmentsMenu;

    @FindBy(xpath = "//div[@id='jobs-list']/div")
    private List<WebElement> openPositions;

    @FindBy(xpath = "//div[@id='jobs-list']//p")
    private List<WebElement> roles;

    @FindBy(xpath = "//div[@id='jobs-list']//span")
    private List<WebElement> deparments;

    @FindBy(xpath = "//div[@id='jobs-list']/div/div/div")
    private List<WebElement> locations;

    @FindBy(xpath = "//*[@id='jobs-list']//a[text()='View Role']")
    private WebElement viewRoleButton;

    private WebElement locateElementFromDropDown(String text) {
        return Driver.get().findElement(By.xpath("//option[text()= '" + text + "']"));
    }

    public void tapOnElementFromDropDown(String text) {
        UiUtils.click(locateElementFromDropDown(text));
        UiUtils.closeDropdownIfOpen();
    }

    public void tapOnAllLocationsDropDownMenu() {
        UiUtils.waitForVisibilityOfAllElements(openPositions);
        UiUtils.click(allLocationsMenu);
    }

    public void tapOnDepartmentsDropDownMenu() {
        UiUtils.waitForVisibilityOfAllElements(openPositions);
        UiUtils.click(allDepartmentsMenu);
    }

    public boolean isOpenPositionExistsAccordingToGivenEntry() {
        logger.info("checking if there is any open position...");
        return !openPositions.isEmpty();
    }

    public void tapOnViewRoleButton() {
        UiUtils.click(viewRoleButton);
    }

    public void waitUntilFilteredJobsListed(String locatorText, String location) {
        UiUtils.waitUntilGivenElementsContainsExpectedText(By.xpath(locatorText), location);
    }
}
