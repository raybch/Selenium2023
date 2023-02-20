package tests;

import constants.confg.Config;
import constants.path.Path;
import init.DriverFactory;
import listner.ReportListener;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

public class UserTests {
    Logger log = null;
    SoftAssert softAssert;
    DriverFactory driverFactory;
    RemoteWebDriver driver;
    LoginPage login = new LoginPage();
    HomePage home = new HomePage();
    AccountPage account = new AccountPage();

    @BeforeClass(alwaysRun = true)
    public void startUp() throws Exception {
        log = Logger.getLogger(UserTests.class);
        PropertyConfigurator.configure(Path.CONFIG_LOG4J_FILE_PATH);
        this.driverFactory = new DriverFactory();
        this.driver = DriverFactory.getDriver();
        softAssert = new SoftAssert();
        DriverFactory.setDriverFactory(this.driverFactory);
        this.driver.get(Config.URL);
        log.info("URL is entered in browser");
    }

    @Test(priority = 1)
    public void verifyLoginTest() throws Exception {
        log.info("verifyLoginTest() test started");
        login.logIntoAccount(driver);
        home.clickOnDefaultAccount(driver);
        softAssert.assertTrue(home.getHeader(driver).contains("My account"));
        softAssert.assertAll();
        ReportListener.logToReport("Login test completed successfully");
        log.info("verifyLoginTest() test completed");
    }

    @Test(priority = 2)
    public void verifyDashboardTest() {
        log.info("verifyDashboardTest() test started");
        softAssert.assertTrue(home.getHeader(driver).contains("My account"));
        softAssert.assertAll();
        ReportListener.logToReport("Dashboard test completed successfully");
        log.info("verifyDashboardTest() test completed");
    }

    @Test(priority = 3)
    public void verifyOrdersTest() {
        log.info("verifyOrdersTest() test started");
        account.clickOnOrders(driver);
        softAssert.assertTrue(account.checkIfBrowseProductsIsPresent(driver));
        softAssert.assertAll();
        ReportListener.logToReport("Order test completed successfully");
        log.info("verifyOrdersTest() test completed");
    }

    @Test(priority = 4)
    public void verifyAccountDetailsTest() {
        log.info("verifyAccountDetailsTest() test started");
        account.clickOnAccountDetails(driver);
        softAssert.assertTrue(account.checkIfSaveChangesIsPresent(driver));
        softAssert.assertAll();
        ReportListener.logToReport("Account Details test completed successfully");
        log.info("verifyAccountDetailsTest() test completed");
    }

    @Test(priority = 5)
    public void verifyAddressesTest() {
        log.info("verifyAddressesTest() test started");
        account.clickOnAddresses(driver);
        softAssert.assertTrue(account.checkIfAddressMessageIsPresent(driver));
        softAssert.assertAll();
        ReportListener.logToReport("Addresses test completed successfully");
        log.info("verifyAddressesTest() test completed");
    }


    @Test(priority = 6)
    public void verifySignOutTest() {
        log.info("verifySignOutTest() test started");
        account.clickOnLogout(driver);
        softAssert.assertTrue(login.checkIfLoginButtonIsPresent(driver));
        softAssert.assertAll();
        ReportListener.logToReport("Sign Out test completed successfully");
        log.info("verifySignOutTest() test completed");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.close();
        this.driver.quit();
    }

}
