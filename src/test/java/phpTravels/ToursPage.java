package phpTravels;

import commons.AbstractTest;
import interfaces.AbstractPageUI;
import commons.PageFatoryManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.TravelsToursPageObject;
import java.lang.*;
import java.util.concurrent.TimeUnit;


public class ToursPage extends AbstractTest {
    WebDriver driver;
    TravelsToursPageObject travelsToursPageObject;

    @BeforeClass
    public void openUrl() {
        driver = openMultiBrowser(AbstractPageUI.BROWSER, AbstractPageUI.URL);
        travelsToursPageObject = PageFatoryManager.getTravelsToursPage(driver);
    }

    @AfterClass
    public void close() {
        log.info("Close Browser");
        closeBrowser();
    }

    @Test
    public void TC01_CHECK_TOURS_LBL() {
        log.info("Step 01: Get tours lable");
        travelsToursPageObject.checkToursLbl();
    }

    @Test
    public void TC02_CHECK_TOURS_PAGE_DISPLAY() {
        log.info("Step 01: Click tours link to open Tours page");
        travelsToursPageObject.clickToursLnk();

        log.info("Step 02: Check tours is display");
        travelsToursPageObject.checkToursPageIsDisplay();
    }

    @Test
    public void TC03_CHECK_DESTINATION_LBL() {
        log.info("Step 01: Click tours link to open Tours page");
        travelsToursPageObject.clickToursLnk();

        log.info("Step 02: Get destination lable");
        travelsToursPageObject.checkDestinationLbl();
    }

    @Test
    public void TC04_CHECK_SEARCHBYCITY_LBL() {
        String expectText = "Search By City";

        log.info("Step 01: Click tours link to open Tours page");
        travelsToursPageObject.clickToursLnk();

        log.info("Step 02: Get search by city combo box");
        travelsToursPageObject.checkSearchByCityCbo(expectText);
    }

    @Test
    public void TC05_CHECK_DESTINATION_ALERT_MESSAGE() throws InterruptedException {
        String[] input = { "", "S", "SD", "SDS", "abcxyz",};
        String[] alertMessage = {
                "Please enter 3 or more characters",
                "Please enter 2 or more characters",
                "Please enter 1 or more characters",
                "Searching…",
                "The results could not be loaded.",
        };

        int count = input.length;
        for (int i = 0; i < count; i++) { //i phai rat chinh sat
            log.info("Step 01: Click tours link to open Tours page");
            travelsToursPageObject.clickToursLnk();

            log.info("Step 02: Click search by city combo box");
            travelsToursPageObject.clickSearchByCityCbo();

            log.info("Step 03: Input into search by city combo box");
            travelsToursPageObject.inputSearchByCityCbo(input[i]);

            if (i > 3) {
                log.info("Step 04: Wait for element visible");
                travelsToursPageObject.waitTwoSecons();

                log.info("Step 05: Check alert message");
                travelsToursPageObject.checkAlertMessage(alertMessage[i]);
            } else {
                log.info("Step 05: Check alert message");
                travelsToursPageObject.checkAlertMessage(alertMessage[i]);
            }
        }
    }

    @Test
    public void TC06_CHECK_RESUL_CITY() throws InterruptedException {
        String inputCity = "New";
        String expectCity = "Cape Newenham,United States";
        String expectText = "Cape Newenham,United States";

        log.info("Step 01: Click tours link to open Tours page");
        travelsToursPageObject.clickToursLnk();

        log.info("Step 02: Click search by city combo box");
        travelsToursPageObject.clickSearchByCityCbo();

        log.info("Step 03: Input into search by city combo box");
        travelsToursPageObject.inputSearchByCityCbo(inputCity);

        log.info("Step 04: Wait for element visible");
        travelsToursPageObject.waitTwoSecons();

        log.info("Step 05: Click city in DDL");
        travelsToursPageObject.clickCityInDdl(expectCity);

        log.info("Step 06: Get SearchBYCity Cbo");
        travelsToursPageObject.checkSearchByCityCbo(expectText);
    }

    @Test
    public void TC07_CHECK_DATE_LBL() {
        log.info("Step 01: Click tours link to open Tours page");
        travelsToursPageObject.clickToursLnk();

        log.info("Step 02: Get date lable");
        travelsToursPageObject.checkDateLbl();
    }

    @Test
    public void TC08_CHECK_CURRENT_DAY() { //present +2 day
        log.info("Step 01: Click tours link to open Tours page");
        travelsToursPageObject.clickToursLnk();

        log.info("Step 02: Get date lable");
        travelsToursPageObject.checkCurrentDay();
    }
    @Test
    public void TC09_CHECK_BTN_DATE() {
        log.info("Step 01: Click tours link to open Tours page");
        travelsToursPageObject.clickToursLnk();

        log.info("Step 02: Click date box");
        travelsToursPageObject.clickDateTxb();

        log.info("Step 03: Click prev btn");
        travelsToursPageObject.clickPrevBtn();

        log.info("Step 04: Click next btn");
        travelsToursPageObject.clickNextBtn();
    }

    @Test
    public void TC010_CLICK_DISABLE_DAY() {
        log.info("Step 01: Click tours link to open Tours page");
        travelsToursPageObject.clickToursLnk();

        log.info("Step 02: Click date box");
        travelsToursPageObject.clickDateTxb();

        log.info("Step 03: Click disable day");
        travelsToursPageObject.clickDisableDay();
    }

    @Test
    public void TC011_CLICK_DAY() throws InterruptedException {
        log.info("Step 01: Click tours link to open Tours page");
        travelsToursPageObject.clickToursLnk();

        log.info("Step 02: Click date box");
        travelsToursPageObject.clickDateTxb();

        log.info("Step 03: Click day");
        travelsToursPageObject.clickDay();
    }




}
