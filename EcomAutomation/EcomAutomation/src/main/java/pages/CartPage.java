package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CartPage extends BasePage {

    By proceedToCheckout = By.xpath("//a[text()=' Proceed to checkout']");
    By cartBtn = By.xpath("//a[@title='View your shopping cart']");
    By removeBtn = By.className("remove");
    By emptyCart = By.xpath("//*[text()='Your cart is currently empty.']");

    public boolean checkIfProceedToCheckoutIsPresent(RemoteWebDriver driver) {
        return isElementPresent(driver, proceedToCheckout);
    }

    public boolean checkIfCartIsEmpty(RemoteWebDriver driver) {
        return isElementPresent(driver, emptyCart);
    }

    public void clickOnProceedToCheckout(RemoteWebDriver driver) {
        click(driver, proceedToCheckout);
    }

    public void clickOnCart(RemoteWebDriver driver) {
        click(driver, cartBtn);
    }

    public void clickOnRemove(RemoteWebDriver driver) throws InterruptedException {
        click(driver, removeBtn);
        Thread.sleep(5000);
    }
}
