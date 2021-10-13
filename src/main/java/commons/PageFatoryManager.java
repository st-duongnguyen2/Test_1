package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class PageFatoryManager {

    public static AbstractPageObject getAbstractPageObject(WebDriver driver) {
        return new AbstractPageObject(driver);
    }

    public static ViroLoginPageObject getViroPage(WebDriver driver) {
        return new ViroLoginPageObject(driver);
    }

    public static TravelsToursPageObject getTravelsToursPage(WebDriver driver) {
        return new TravelsToursPageObject(driver);
    }

}
