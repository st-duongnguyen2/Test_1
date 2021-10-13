package pageObjects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;


public class AbstractPageObject extends AbstractPage {
    WebDriver driver;

    public AbstractPageObject(WebDriver mapDriver) {
        driver = mapDriver;
    }
}
