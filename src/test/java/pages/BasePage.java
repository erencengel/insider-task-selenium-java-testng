package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.LoggerHelper;

public class BasePage {

    protected Logger logger = LoggerHelper.getLogger(BasePage.class);

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

}
