package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CheckoutPage extends BasePage {

    By firstName = By.id("billing_first_name");
    By lastName = By.id("billing_last_name");
    By billingAddress = By.id("billing_address_1");
    By city = By.id("billing_city");
    By postCode = By.id("billing_postcode");
    By phone = By.id("billing_phone");
    By placeOrder = By.id("place_order");

    public void enterFirstName(RemoteWebDriver driver, String name) throws InterruptedException {
        enterData(driver, firstName, name);
    }

    public void enterLastName(RemoteWebDriver driver, String name) throws InterruptedException {
        enterData(driver, lastName, name);
    }

    public void enterAddress(RemoteWebDriver driver, String address) throws InterruptedException {
        enterData(driver, billingAddress, address);
    }

    public void enterCity(RemoteWebDriver driver, String name) throws InterruptedException {
        enterData(driver, city, name);
    }

    public void enterPostCode(RemoteWebDriver driver, String code) throws InterruptedException {
        enterData(driver, postCode, code);
    }

    public void enterPhone(RemoteWebDriver driver, String no) throws InterruptedException {
        enterData(driver, phone, no);
    }
    public boolean checkIfPlaceOrderIsPresent(RemoteWebDriver driver) {
        return isElementPresent(driver, placeOrder);
    }


}
