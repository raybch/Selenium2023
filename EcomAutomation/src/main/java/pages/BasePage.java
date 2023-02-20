package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    Logger log = null;
    public BasePage() {
        log = Logger.getLogger(BasePage.class);
    }

    public void waitForElementClickability(RemoteWebDriver driver, By locator) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForElementVisibility(RemoteWebDriver driver, By locator) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void enterData(RemoteWebDriver driver, By locator, String value) throws InterruptedException {
        waitForElementClickability(driver, locator);
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        Thread.sleep(1000);
        driver.findElement(locator).sendKeys(value);
        log.info("Value Entered : '"+ value + "' in " +locator.toString());
    }

    public void click(RemoteWebDriver driver, By locator) {
        waitForElementClickability(driver, locator);
        driver.findElement(locator).click();
        log.info("Clicked on "+ locator.toString());
    }

    public String getText(RemoteWebDriver driver, By locator) {
        waitForElementVisibility(driver, locator);
        return driver.findElement(locator).getText();
    }

    public void scrollToElement(RemoteWebDriver driver, By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
    }

    public boolean isElementPresent(RemoteWebDriver driver, By locator) {
        boolean exists = false;
        try {
            waitForElementVisibility(driver,locator);
            if (driver.findElement(locator).isDisplayed())
                exists = true;
        } catch (Exception e) {
            // nothing to do.
        }
        log.info("Checked if "+ locator.toString() +" is present" );
        return exists;
    }

}
