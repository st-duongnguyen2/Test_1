package viro.homepage;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import commons.AbstractTest;
import commons.PageFatoryManager;
import interfaces.AbstractPageUI;
import interfaces.ViroLoginPageUI;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.ViroLoginPageObject;

import java.io.FileReader;
import java.io.IOException;

public class Viro extends AbstractTest {
    WebDriver driver;
    String browserOpen, urlOpen;
    String CSV_PATH = System.getProperty("user.dir") + "/Data/Login_account.csv";
    ViroLoginPageObject viroLoginPageObject;

    @BeforeClass
    public void openUrl() {
        driver = openMultiBrowser(AbstractPageUI.BROWSER, AbstractPageUI.URL);
    }

    @AfterClass
    public void close() {
        log.info("Close Browser");
        closeBrowser();
    }

    @Test
    public void TC01() throws IOException, CsvValidationException {
        CSVReader reader = new CSVReader(new FileReader(CSV_PATH));
        String[] csvCell;
        int n = 4;
        for (int i = 1; i <= n; i++) {
            viroLoginPageObject = PageFatoryManager.getViroPage(driver);

            csvCell = reader.readNext();
            String FEmail = csvCell[0];
            String FPassword = csvCell[1];
            System.out.println("0" + i + " = " + FEmail);

            log.info("Step 01: Input Email");
            viroLoginPageObject.inputEmail(FEmail);

            log.info("Step 02: Input Password");
            viroLoginPageObject.inputPassword(FPassword);

        }
    }
}
