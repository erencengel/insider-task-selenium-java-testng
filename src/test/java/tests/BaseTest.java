package tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.careers.QualityAssuranceDepartmentPage;
import pages.careers.QualityAssuranceHomePage;
import utils.Driver;
import utils.LoggerHelper;

import static utils.Constants.DEFAULT_TIMEOUT;


public class BaseTest {

    protected HomePage homePage;
    protected QualityAssuranceHomePage qualityAssuranceHomePage;
    protected QualityAssuranceDepartmentPage qualityAssuranceDepartmentPage;

    protected WebDriver driver;
    protected Logger logger = LoggerHelper.getLogger(BaseTest.class);

    @BeforeMethod(alwaysRun = true)
    void setUpDriver() {

        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT);
        logger.info("driver initialized");

        homePage = new HomePage();
        qualityAssuranceHomePage = new QualityAssuranceHomePage();
        qualityAssuranceDepartmentPage = new QualityAssuranceDepartmentPage();

    }

    @AfterMethod(alwaysRun = true)
    void tearDownDriver() {
        Driver.closeDriver();
        logger.info("driver closed");
    }

}
