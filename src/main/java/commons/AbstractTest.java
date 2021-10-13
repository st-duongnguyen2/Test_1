package commons;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {

    private WebDriver driver;
    protected final Log log;

    protected AbstractTest() {
        log = LogFactory.getLog(getClass());
    }

    DriverType driverType = new DriverType();

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriver openMultiBrowser(String browser, String url) {
        log.info("Open Browser");
        if (browser.toLowerCase().equals("chrome")) {
            driver = driverType.chromeDriver();
        } else if (browser.toLowerCase().equals("firefox")) {
            driver = driverType.firefoxDriver();
        } else if (browser.toLowerCase().equals("safari")) {
            driver = driverType.safariDriver();
        } else if (browser.toLowerCase().equals("chromeheadless")) {
            driver = driverType.chromeHeadless();
        } else if (browser.toLowerCase().equals("firefoxheadless")) {
            driver = driverType.firefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        return driver;
    }

    protected WebDriver navigateToURLWithAuthorization(String username, String pwd, String browser, String url) {
        log.info("Open Browser");
        if (browser.toLowerCase().equals("chrome")) {
            driver = driverType.chromeDriver();
        } else if (browser.toLowerCase().equals("firefox")) {
            driver = driverType.firefoxDriver();
        } else if (browser.toLowerCase().equals("safari")) {
            driver = driverType.safariDriver();
        } else if (browser.toLowerCase().equals("chromeheadless")) {
            driver = driverType.chromeHeadless();
        } else if (browser.toLowerCase().equals("firefoxheadless")) {
            driver = driverType.firefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String newUrl = "http://" + username + ":" + pwd + "@" + url;
        driver.get(newUrl);
        return driver;
    }

    // Hàm close browser driver
    protected void closeBrowser() {
        try {
            // Detect OS (Windows/ Linux/ MAC)
            driver.quit();
            if (driver.toString().toLowerCase().contains("chrome")) {
                driverType.closeChromeDriver();
            }
            if (driver.toString().toLowerCase().contains("firefox")) {
                driverType.closeFirefoxDriver();
            }
            if (driver.toString().toLowerCase().contains("internetexplorer")) {
                driverType.closeIEDriver();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean checkTrue(boolean condition) {
        boolean pass = true;
        try {
            if (condition == true) {
                log.info(" -------------------------- PASSED -------------------------- ");
            } else {
                log.info(" -------------------------- FAILED -------------------------- ");
            }
            Assert.assertTrue(condition);
        } catch (Throwable e) {
            pass = false;

            // Add lỗi vào ReportNG
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyTrue(boolean condition) {
        return checkTrue(condition);
    }

    private boolean checkFailed(boolean condition) {
        boolean pass = true;
        try {
            if (condition == false) {
                log.info(" -------------------------- PASSED -------------------------- ");
            } else {
                log.info(" -------------------------- FAILED -------------------------- ");
            }
            Assert.assertFalse(condition);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        return checkFailed(condition);
    }

    private boolean checkEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            pass = false;
            log.info(" -------------------------- FAILED -------------------------- ");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        return checkEquals(actual, expected);
    }

    public int randomNumber() {
        Random num = new Random();
        int n = num.nextInt(99999999) + 1;
        return n;
    }
}
