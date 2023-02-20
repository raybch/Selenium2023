package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchPage extends BasePage {

    By searchField = By.xpath("//input[@id='s']");
    By searchBtn = By.xpath("//form[@id='searchform']//button[@type='submit']");
    By addToCart = By.xpath("//a[text()='Add to cart']");
    By viewCart = By.xpath("//a[contains(@title,'View your shopping cart')]");

    public void enterSearch(RemoteWebDriver driver, String name) throws InterruptedException {
        enterData(driver, searchField, name);
    }

    public void clickOnSearch(RemoteWebDriver driver) {
        click(driver, searchBtn);
    }

    public void clickOnAddToCart(RemoteWebDriver driver) {
        scrollToElement(driver, addToCart);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(addToCart));
    }

    public void clickOnViewCart(RemoteWebDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        click(driver, viewCart);
    }

}
