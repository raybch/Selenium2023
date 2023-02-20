package pages;

import constants.confg.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginPage extends BasePage {

	// locators
	By emailField = By.id("username");
	By passwordField = By.id("password");
	By login =By.name("login");

	HomePage home = new HomePage();
	public void enterUserName(RemoteWebDriver driver, String userName) throws InterruptedException {
		enterData(driver, emailField, userName);
	}

	public void enterPassword(RemoteWebDriver driver, String password) throws InterruptedException {
		enterData(driver, passwordField, password);
	}

	public void clickOnLogin(RemoteWebDriver driver) {
		click(driver, login);
	}
	public void logIntoAccount(RemoteWebDriver driver) throws InterruptedException {
		home.clickOnAccount(driver);
		enterUserName(driver, Config.USER_NAME);
		enterPassword(driver, Config.PASSWORD);
		clickOnLogin(driver);
		home.clickOnAccount(driver);
		enterPassword(driver, Config.PASSWORD);
		clickOnLogin(driver);
	}
	public boolean checkIfLoginButtonIsPresent(RemoteWebDriver driver) {
		return isElementPresent(driver,login);
	}
}
