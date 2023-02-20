package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AccountPage extends BasePage {

    By orders = By.xpath("//a[text()='Orders']");
    By accountDetails = By.xpath("//a[text()='Account details']");
    By browseProducts = By.xpath("//a[text()='Browse products']");
    By saveChanges = By.name("save_account_details");
    By addresses = By.xpath("//a[text()='Addresses']");
    By logout = By.xpath("//a[text()='Logout']");
    By getAddressesMessage = By.xpath("//*[text()=' The following addresses will be used on the checkout page by default.']");


    public void clickOnOrders(RemoteWebDriver driver) {
        click(driver, orders);
    }

    public void clickOnAddresses(RemoteWebDriver driver) {
        click(driver, addresses);
    }

    public void clickOnLogout(RemoteWebDriver driver) {
        click(driver, logout);
    }

    public void clickOnAccountDetails(RemoteWebDriver driver) {
        click(driver, accountDetails);
    }

    public boolean checkIfBrowseProductsIsPresent(RemoteWebDriver driver) {
        return isElementPresent(driver, browseProducts);
    }

    public boolean checkIfSaveChangesIsPresent(RemoteWebDriver driver) {
        return isElementPresent(driver, saveChanges);
    }

    public boolean checkIfAddressMessageIsPresent(RemoteWebDriver driver) {
        return isElementPresent(driver, getAddressesMessage);
    }
}
