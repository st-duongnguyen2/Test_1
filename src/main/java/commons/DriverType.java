package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class DriverType {
    private static String osName = System.getProperty("os.name").toLowerCase();
    private static String cmd = "";
    private final String workingDir = System.getProperty("user.dir");

    public WebDriver chromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-incognito");
        options.addArguments("--disable-extensions");
        options.addArguments("disable-inforbars");
        options.addArguments("--disable-notifications");
        return new ChromeDriver(options);
    }

    public WebDriver firefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-notifications");
        return new FirefoxDriver(options);
    }

    public WebDriver safariDriver() {
        WebDriver driver = new SafariDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver ieDriver() {
        WebDriverManager.iedriver().arch32().setup();
        InternetExplorerOptions ieOp = new InternetExplorerOptions();
        ieOp.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        return new InternetExplorerDriver(ieOp);
    }

    public WebDriver edgeDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    public WebDriver chromeHeadless() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-incognito");
        options.addArguments("headless");
        options.addArguments("window-size=1366x768");
        return new ChromeDriver(options);
    }

    public void closeChromeDriver() {
        try {
            // Kill process
            if (osName.toLowerCase().contains("mac")) {
                cmd = "pkill chromedriver";
            } else {
                cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
            }
            Process process = Runtime.getRuntime().exec(cmd);
            process.waitFor();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void closeFirefoxDriver() {
        try {
            if (osName.toLowerCase().contains("mac")) {
                cmd = "pkill firefoxdriver";
            } else {
                cmd = "taskkill /F /FI \"IMAGENAME eq firefoxdriver*\"";
            }
            Process process = Runtime.getRuntime().exec(cmd);
            process.waitFor();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void closeIEDriver() {
        try {
            cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
            Process process = Runtime.getRuntime().exec(cmd);
            process.waitFor();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
