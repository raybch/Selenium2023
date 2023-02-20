package tests;

import constants.confg.Config;
import constants.path.Path;
import constants.testdata.Excel;
import init.DriverFactory;
import listner.ReportListener;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

public class CartTests {
    Logger log = null;
    SoftAssert softAssert;
    DriverFactory driverFactory;
    RemoteWebDriver driver;
    LoginPage login = new LoginPage();
    HomePage home = new HomePage();
    SearchPage search = new SearchPage();
    CartPage cart = new CartPage();
    CheckoutPage checkout = new CheckoutPage();

    @BeforeClass(alwaysRun = true)
    public void startUp() throws Exception {
        log = Logger.getLogger(CartTests.class);
        PropertyConfigurator.configure(Path.CONFIG_LOG4J_FILE_PATH);
        this.driverFactory = new DriverFactory();
        this.driver = DriverFactory.getDriver();
        softAssert = new SoftAssert();
        DriverFactory.setDriverFactory(this.driverFactory);
        this.driver.get(Config.URL);
        log.info("URL is entered in browser");
        login.logIntoAccount(driver);
    }

    @Test
    public void verifyCartTest() throws InterruptedException {
        log.info("verifyCartTest() test started");
        search.clickOnAddToCart(driver);
        search.clickOnViewCart(driver);
        softAssert.assertTrue(cart.checkIfProceedToCheckoutIsPresent(driver));
        softAssert.assertAll();
        ReportListener.logToReport("Cart test completed successfully");
        log.info("verifyCartTest() test completed");
    }

    @Test(dependsOnMethods = {"verifyCartTest"})
    public void verifyCheckoutTest() {
        log.info("verifyCheckoutTest() test started");
        cart.clickOnProceedToCheckout(driver);
        softAssert.assertTrue(home.getHeader(driver).contains("Checkout"));
        softAssert.assertAll();
        ReportListener.logToReport("Checkout test completed successfully");
        log.info("verifyCheckoutTest() test completed");
    }

    @Test(dependsOnMethods = {"verifyCheckoutTest"})
    public void verifyPaymentTest() throws Exception {
        log.info("verifyPaymentTest() test started");
        checkout.enterFirstName(driver, Excel.FIRST_NAME);
        checkout.enterLastName(driver, Excel.LAST_NAME);
        checkout.enterAddress(driver, Excel.ADDRESS);
        checkout.enterCity(driver, Excel.CITY);
        checkout.enterPostCode(driver, Excel.ZIPCODE);
        checkout.enterPhone(driver, Excel.PHONE);
        softAssert.assertTrue(checkout.checkIfPlaceOrderIsPresent(driver));
        softAssert.assertAll();
        ReportListener.logToReport("Payment test completed successfully");
        log.info("verifyPaymentTest() test completed");
    }

    @Test(dependsOnMethods = {"verifyPaymentTest"})
    public void verifyEmptyCartTest() throws Exception {
        log.info("verifyEmptyCartTest() test started");
        cart.clickOnCart(driver);
        cart.clickOnRemove(driver);
        softAssert.assertTrue(cart.checkIfCartIsEmpty(driver));
        softAssert.assertAll();
        ReportListener.logToReport("Empty cart test completed successfully");
        log.info("verifyEmptyCartTest() test completed");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.close();
        this.driver.quit();
    }

}
