package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HomePage extends BasePage {

    By account = By.id("popuplogin");
    By defaultAccount = By.id("defaultlogin");
    By header = By.xpath("//h1");
    By logo = By.xpath("//a[@rel=\"home\"]");
    By home = By.xpath("//a[@title='Home']");
    By products = By.xpath("//a[@title='Products']");
    By sale = By.xpath("//a[@title='Sale']");
    By shop = By.xpath("//a[@title='Shop']");
    By blog = By.xpath("//a[@title='Blog']");
    By about = By.xpath("//a[@title='About Us']");
    By contact = By.xpath("//a[@title='Contact']");
    By watches = By.xpath("//a[@title='Watches']");


    public void clickOnAccount(RemoteWebDriver driver) {
        click(driver, account);
    }

    public void clickOnDefaultAccount(RemoteWebDriver driver) {
        click(driver, defaultAccount);
    }

    public String getHeader(RemoteWebDriver driver) {
        return getText(driver, header);
    }

    public boolean checkIfLogoIsPresent(RemoteWebDriver driver) {
        return isElementPresent(driver, logo);
    }

    public boolean checkIfHomeIsPresent(RemoteWebDriver driver) {
        return isElementPresent(driver, home);
    }

    public boolean checkIfProductsIsPresent(RemoteWebDriver driver) {
        return isElementPresent(driver, products);
    }

    public boolean checkIfSaleIsPresent(RemoteWebDriver driver) {
        return isElementPresent(driver, sale);
    }

    public boolean checkIfShopIsPresent(RemoteWebDriver driver) {
        return isElementPresent(driver, shop);
    }

    public boolean checkIfBlogIsPresent(RemoteWebDriver driver) {
        return isElementPresent(driver, blog);
    }

    public boolean checkIfAboutUsIsPresent(RemoteWebDriver driver) {
        return isElementPresent(driver, about);
    }

    public boolean checkIfContactIsPresent(RemoteWebDriver driver) {
        return isElementPresent(driver, contact);
    }
    public boolean checkIfWatchesIsPresent(RemoteWebDriver driver) {
        return isElementPresent(driver, watches);
    }
}
