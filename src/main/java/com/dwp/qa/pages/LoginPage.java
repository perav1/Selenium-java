package com.dwp.qa.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.TimeoutException;
//login functionality
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dwp.qa.util.TakeScreenshots;

public class LoginPage extends WebLocators {
	public WebDriver driver;
	public Properties prop;
	public TakeScreenshots screenshots;

	public LoginPage(WebDriver driver, Properties prop) {
		super(driver);
		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(driver, this);
		screenshots = new TakeScreenshots(driver);
	}

	public void LoginApplication(String email) throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		System.out.println("Logging in with email: " + email);
		Useremail.clear();
		Useremail.sendKeys(prop.getProperty("email"));
		submit.click();
		boolean errorMailVisible = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(errorEmail));
			errorMailVisible = true;
		} catch (TimeoutException e) {
			System.out.println("Error message not visible within the timeout period.");
		}
		if (errorMailVisible && isErrorMessageDisplayed()) {
			String errormessage = errorEmail.getText();
			System.out.println("Error message is:" + errormessage);
		} else {
			System.out.println("Login successful");
		}
		screenshots.takeScreenShots("ClickedSubmit");
	}

	public void loginDetails(String username, String password) throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		System.out.println("Logging in with username: " + username + " and password: " + password);
		userName.sendKeys(prop.getProperty("username"));
		Password.sendKeys(prop.getProperty("password"));
		signIn.click();
		boolean errorTextVisible = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(errorTextuser));
			errorTextVisible = true;
		}

		catch (TimeoutException e) {
			System.out.println("Error message not visible within the timeout period.");
		}
		if (errorTextVisible && isErrorTextDisplayed()) {
			String userErrorText = errorTextuser.getText();
			System.out.println("Error text is:" + userErrorText);

		} else {
			System.out.println("Login successful");
		}
		screenshots.takeScreenShots("ClcikedSignIn");
	}

	public void goTo() throws IOException {
		String url = prop.getProperty("URL");
		System.out.println("Navigating to URL: " + url);
		driver.get(url);
		screenshots.takeScreenShots("LandedLoginPage");
	}

	private boolean isErrorMessageDisplayed() {
		try {
			return errorEmail.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
		private boolean isErrorTextDisplayed() {
			try {
				return errorTextuser.isDisplayed();
			} catch (NoSuchElementException e) {
				return false;
			}
	}

}
