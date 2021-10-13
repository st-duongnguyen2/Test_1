package pageObjects;

import commons.AbstractPage;
import interfaces.TravelsToursPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TravelsToursPageObject extends AbstractPage {
    WebDriver driver;

    public TravelsToursPageObject(WebDriver mapDriver) {
        driver = mapDriver;
    }

    public void checkToursLbl() {
        waitForControlVisible(driver, TravelsToursPageUI.TOURS_LNK);
        Assert.assertEquals(driver.findElement(By.xpath(TravelsToursPageUI.TOURS_LNK)).getText(), "Tours");
    }

    public void clickToursLnk() {
        waitForControlVisible(driver, TravelsToursPageUI.TOURS_LNK);
        clickOnElement(driver, TravelsToursPageUI.TOURS_LNK);
    }

    public void checkToursPageIsDisplay() {
        waitForControlVisible(driver, TravelsToursPageUI.TOURS_LNK);
        isElementDisplayed(driver, TravelsToursPageUI.TOURS_LNK);
    }

    public void checkDestinationLbl() {
        waitForControlVisible(driver, TravelsToursPageUI.SEARCHBYCITY_LBL);
        Assert.assertEquals(driver.findElement(By.xpath(TravelsToursPageUI.SEARCHBYCITY_LBL)).getText(), "Destination");
    }

    public void checkSearchByCityCbo(String expectText) {
        waitForControlVisible(driver, TravelsToursPageUI.SEARCHBYCITY_CBO);
        Assert.assertEquals(driver.findElement(By.xpath(TravelsToursPageUI.SEARCHBYCITY_CBO)).getText(), expectText);
    }

    public void clickSearchByCityCbo() {
        waitForControlVisible(driver, TravelsToursPageUI.SEARCHBYCITY_CBO);
        clickOnElement(driver, TravelsToursPageUI.SEARCHBYCITY_CBO);
    }

    public void checkAlertMessage(String alertMessage) {
        waitForControlVisible(driver, TravelsToursPageUI.MESSAGE_DESTINATION_LBL);
        Assert.assertEquals(driver.findElement(By.xpath(TravelsToursPageUI.MESSAGE_DESTINATION_LBL)).getText(), alertMessage);
    }

    public void inputSearchByCityCbo(String input) {
        waitForControlVisible(driver, TravelsToursPageUI.SEARCHBYCITY_TXB);
        sendkeyToElement(driver, TravelsToursPageUI.SEARCHBYCITY_TXB, input);
    }

    public void waitTwoSecons() throws InterruptedException{
            Thread.sleep(2000);
    }

    public void clickCityInDdl(String expectCity) {
        waitForControlVisible(driver, TravelsToursPageUI.CITY_NAME_DDL);
        List<WebElement> listCity = driver.findElements(By.xpath(TravelsToursPageUI.CITY_NAME_DDL));
        for (WebElement webElement : listCity) {
            if(webElement.getText().trim().equals(expectCity)) {
                webElement.click();
                break;
            }
        }
    }

    public void checkDateLbl() {
        waitForControlVisible(driver, TravelsToursPageUI.DATE_LBL);
        Assert.assertEquals(driver.findElement(By.xpath(TravelsToursPageUI.DATE_LBL)).getText(), "Date");
    }

    public void checkCurrentDay() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); //format date with dd-MM--yyyy
        Date date = new Date();                                                 //create current day

        Calendar c = Calendar.getInstance();        // convert date to calendar
        c.setTime(date);                            // convert date to calendar
        c.add(Calendar.DATE, 2);            // manipulate date to 2
        Date currentDatePlus = c.getTime();        // convert calendar to date

        waitForControlVisible(driver, TravelsToursPageUI.DATE_TXB);
        Assert.assertEquals(driver.findElement(By.xpath(TravelsToursPageUI.DATE_TXB)).getAttribute("value"), formatter.format(currentDatePlus));
    }

    public void clickDateTxb() {
        waitForControlVisible(driver, TravelsToursPageUI.DATE_TXB);
        clickOnElement(driver, TravelsToursPageUI.DATE_TXB);
    }

    public void clickPrevBtn() {
        waitForControlVisible(driver, TravelsToursPageUI.PREV_BTN);
        clickOnElement(driver, TravelsToursPageUI.PREV_BTN);
    }

    public void clickNextBtn() {
        waitForControlVisible(driver, TravelsToursPageUI.NEXT_BTN);
        clickOnElement(driver, TravelsToursPageUI.NEXT_BTN);
    }

    public void clickDisableDay() {
        waitForControlVisible(driver, TravelsToursPageUI.DISABLE_DAY);
        List<WebElement> listDisableDay = driver.findElements(By.xpath(TravelsToursPageUI.DISABLE_DAY));
        for (WebElement webElement : listDisableDay) {
                webElement.click();
        }
    }

    public void clickDay() throws InterruptedException {
        waitForControlVisible(driver, TravelsToursPageUI.DAY);

        SimpleDateFormat formatter = new SimpleDateFormat("dd");     //format date to dd
        Date date = new Date();                                             //get current day to date variable
        String day = formatter.format(date);                                //convert date with format dd to String
        int i = Integer.parseInt(day);                                      //convert date String to int change

        List<WebElement> listDay = driver.findElements(By.xpath("//table[@class=' table-condensed']//td[@class='day ']"));
        for (WebElement eachDay : listDay) {
            driver.findElement(By.xpath("//table[@class=' table-condensed']//td[@class='day '][contains(text(), "+i+")]")).click();
            //eachDay.click();
            i++;
            clickDateTxb();
        }
    }






    

}
