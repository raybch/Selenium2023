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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;
import utils.FileOperations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SearchTests {
    Logger log = null;
    SoftAssert softAssert;
    DriverFactory driverFactory;
    RemoteWebDriver driver;
    LoginPage login = new LoginPage();
    HomePage home = new HomePage();
    SearchPage search = new SearchPage();

    @BeforeClass(alwaysRun = true)
    public void startUp() throws Exception {
        log = Logger.getLogger(SearchTests.class);
        PropertyConfigurator.configure(Path.CONFIG_LOG4J_FILE_PATH);
        this.driverFactory = new DriverFactory();
        this.driver = DriverFactory.getDriver();
        softAssert = new SoftAssert();
        DriverFactory.setDriverFactory(this.driverFactory);
        this.driver.get(Config.URL);
        log.info("URL is entered in browser");
        login.logIntoAccount(driver);
    }

    @Test(dataProvider = "getData")
    public void verifySearchTest(HashMap<String, String> input) throws Exception {
        log.info("verifySearchTest() test started");
        search.enterSearch(driver, input.get("search1"));
        search.clickOnSearch(driver);
        softAssert.assertTrue(home.getHeader(driver).contains(input.get("search1")));
        search.enterSearch(driver, input.get("search2"));
        search.clickOnSearch(driver);
        softAssert.assertTrue(home.getHeader(driver).contains(input.get("search2")));
        softAssert.assertAll();
        ReportListener.logToReport("Search test completed successfully");
        log.info("verifySearchTest() test completed");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.close();
        this.driver.quit();
    }

    @DataProvider
    public Object[][] getData() {
        List<HashMap<String, String>> data = Arrays.asList(FileOperations.getListFromExcel(Path.TESTDATA_PATH, "ExcelTestData.xlsx", "Details"));
        return new Object[][]{{data.get(0)}};

    }
}
