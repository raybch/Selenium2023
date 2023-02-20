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
import pages.HomePage;
import pages.LoginPage;

public class SmokeTests {
    Logger log = null;
    SoftAssert softAssert;
    DriverFactory driverFactory;
    RemoteWebDriver driver;
    LoginPage login = new LoginPage();
    HomePage home = new HomePage();

    @BeforeClass(alwaysRun = true)
    public void startUp() throws Exception {
        log = Logger.getLogger(SmokeTests.class);
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
    public void verifyLogoTest() {
        log.info("verifyLogoTest() test started");
        softAssert.assertTrue(home.checkIfLogoIsPresent(driver));
        softAssert.assertAll();
        ReportListener.logToReport("Logo test completed successfully");
        log.info("verifyLogoTest() test completed");
    }

    @Test
    public void verifyProductsTest() {
        log.info("verifyProductsTest() test started");
        softAssert.assertTrue(home.checkIfProductsIsPresent(driver));
        softAssert.assertAll();
        ReportListener.logToReport("Products test completed successfully");
        log.info("verifyProductsTest() test completed");
    }

    @Test
    public void verifyHomeTest() {
        log.info("verifyHomeTest() test started");
        softAssert.assertTrue(home.checkIfHomeIsPresent(driver));
        softAssert.assertAll();
        ReportListener.logToReport("Home test completed successfully");
        log.info("verifyHomeTest() test completed");
    }

    @Test
    public void verifySaleTest() {
        log.info("verifySaleTest() test started");
        softAssert.assertTrue(home.checkIfSaleIsPresent(driver));
        softAssert.assertAll();
        ReportListener.logToReport("Sale test completed successfully");
        log.info("verifySaleTest() test completed");
    }

    @Test
    public void verifyShopTest() {
        log.info("verifyShopTest() test started");
        softAssert.assertTrue(home.checkIfShopIsPresent(driver));
        softAssert.assertAll();
        ReportListener.logToReport("Shop test completed successfully");
        log.info("verifyShopTest() test completed");
    }

    @Test
    public void verifyBlogTest() {
        log.info("verifyBlogTest() test started");
        softAssert.assertTrue(home.checkIfBlogIsPresent(driver));
        softAssert.assertAll();
        ReportListener.logToReport("Blog test completed successfully");
        log.info("verifyBlogTest() test completed");
    }

    @Test
    public void verifyAboutUsTest() {
        log.info("verifyAboutUsTest() test started");
        softAssert.assertTrue(home.checkIfAboutUsIsPresent(driver));
        softAssert.assertAll();
        ReportListener.logToReport("About us test completed successfully");
        log.info("verifyAboutUsTest() test completed");
    }

    @Test
    public void verifyContactTest() {
        log.info("verifyContactTest() test started");
        softAssert.assertTrue(home.checkIfContactIsPresent(driver));
        softAssert.assertAll();
        ReportListener.logToReport("Contact test completed successfully");
        log.info("verifyContactTest() test completed");
    }

    @Test
    public void verifyWatchesTest() {
        log.info("verifyWatchesTest() test started");
        softAssert.assertTrue(home.checkIfContactIsPresent(driver));
        softAssert.assertAll();
        ReportListener.logToReport("Watches test completed successfully");
        log.info("verifyWatchesTest() test completed");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }

}
