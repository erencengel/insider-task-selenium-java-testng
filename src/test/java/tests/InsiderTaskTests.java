package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.AssertUtils;
import utils.ConfigurationReader;
import utils.Driver;
import utils.UiUtils;

import static utils.Constants.*;

    // Eren Çengel
    // 2026-01-12

public class InsiderTaskTests extends BaseTest{

    /**
     * Visit https://insiderone.com/
     * and check Insider home page is opened
     * and all main blocks are loaded
     */
    @Test
    void verifyHomePageIsLoaded() {

        //go home screen
        UiUtils.navigateTo(ConfigurationReader.get("url_home"));

        //accept cookies
        homePage.tapOnAcceptButtonOnTheCookie();

        //verify url, title, header and footer
        Assert.assertEquals(driver.getCurrentUrl(), HOME_URL);
        Assert.assertEquals(driver.getTitle(), HOME_TITLE);
        Assert.assertTrue(homePage.getHeader().isDisplayed());
        Assert.assertTrue(homePage.getFooter().isDisplayed());
    }

    /**
     * Go to https://insiderone.com/careers/quality-assurance/
     * click “See all QA jobs”
     * filter jobs by Location - Istanbul, Turkey and department - Quality Assurance
     * check presence of jobs list
     * Check that all jobs’ Position contains “Quality Assurance”
     * Department contains “Quality Assurance”
     * Location contains “Istanbul, Turkey”
     * Click “View Role” button and check that
     * this action redirects us to Lever Application form page
     */
    @Test
    void verifyJobApplicationFlow() {

        //go careers screen
        UiUtils.navigateTo(ConfigurationReader.get("url_careers_qa"));

        //accept cookies
        homePage.tapOnAcceptButtonOnTheCookie();

        //tap on see all QA jobs button
        qualityAssuranceHomePage.tapOnSeeAllQAJobsButton();

        //tap on all locations dropdown menu
        qualityAssuranceDepartmentPage.tapOnAllLocationsDropDownMenu();

        //select istanbul
        qualityAssuranceDepartmentPage.tapOnElementFromDropDown(LOCATION_ISTANBUL);

        //tap on departments dropdown menu
        qualityAssuranceDepartmentPage.tapOnDepartmentsDropDownMenu();

        //select quality assurance
        qualityAssuranceDepartmentPage.tapOnElementFromDropDown(DEPARTMENT_QUALITY_ASSURANCE);

        //wait until the filtered jobs are listed
        qualityAssuranceDepartmentPage.waitUntilFilteredJobsListed(qualityAssuranceDepartmentPage.getLocationOfJobsXpathLocator(), LOCATION_ISTANBUL);

        //verify presence of job list
        Assert.assertTrue(qualityAssuranceDepartmentPage.isOpenPositionExistsAccordingToGivenEntry());

        //verify filtered positions contain relevant texts
        Assert.assertTrue(AssertUtils.isGivenTextDisplayedInAllElements(qualityAssuranceDepartmentPage.getRoles(), DEPARTMENT_QUALITY_ASSURANCE));
        Assert.assertTrue(AssertUtils.isGivenTextDisplayedInAllElements(qualityAssuranceDepartmentPage.getDeparments(), DEPARTMENT_QUALITY_ASSURANCE));
        Assert.assertTrue(AssertUtils.isGivenTextDisplayedInAllElements(qualityAssuranceDepartmentPage.getLocations(), LOCATION_ISTANBUL));

        //tap on view role button
        qualityAssuranceDepartmentPage.tapOnViewRoleButton();

        //switch the window
        UiUtils.swapBetweenWindows();

        //verify user is on the new page
        Assert.assertEquals(Driver.get().getCurrentUrl(), URL_OF_QUALITY_ASSURANCE_APPLICATION_PAGE);
        Assert.assertEquals(Driver.get().getTitle(), TITLE_OF_QUALITY_ASSURANCE_APPLICATION_PAGE);
    }

}
