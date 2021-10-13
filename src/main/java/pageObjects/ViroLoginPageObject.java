package pageObjects;

import commons.AbstractPage;
import interfaces.ViroLoginPageUI;
import org.openqa.selenium.WebDriver;

public class ViroLoginPageObject extends AbstractPage {
    WebDriver driver;

    public ViroLoginPageObject(WebDriver mapDriver) {
        driver = mapDriver;
    }

    public void inputEmail(String email) {
        waitForControlVisible(driver, ViroLoginPageUI.EMAIL_TXB);
        sendkeyToElement(driver, ViroLoginPageUI.EMAIL_TXB, email);
    }

    public void inputPassword(String pwd) {
        waitForControlVisible(driver, ViroLoginPageUI.PASS_TXB);
        sendkeyToElement(driver, ViroLoginPageUI.PASS_TXB, pwd);
    }

    public void clickOnSignInBtn() {
        waitForControlVisible(driver, ViroLoginPageUI.SIGNIN_BTN);
        clickOnElement(driver, ViroLoginPageUI.SIGNIN_BTN);
    }

}
