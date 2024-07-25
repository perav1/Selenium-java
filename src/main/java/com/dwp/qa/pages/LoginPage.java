package com.dwp.qa.pages;
import java.util.Properties;

//login functionality
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	public Properties prop;
	public LoginPage(WebDriver driver,Properties prop)
	{
		this.driver=driver;
		this.prop=prop;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="username")
	WebElement Useremail;
	
	@FindBy(name="action")
	WebElement submit;
	@FindBy(id="userNameInput")
	WebElement userName;
	@FindBy(id="passwordInput")
	WebElement Password;
	@FindBy(id="submitButton")
	WebElement signIn;
	
	
	
	public void LoginApplication(String email) {
        System.out.println("Logging in with email: " + email);
        Useremail.sendKeys(prop.getProperty("email"));
        submit.click();
    }

    public void loginDetails(String username, String password) {
        System.out.println("Logging in with username: " + username + " and password: " + password);
        userName.sendKeys(prop.getProperty("username"));
        Password.sendKeys(prop.getProperty("password"));
        signIn.click();
    }

    public void goTo() {
        String url = prop.getProperty("URL");
        System.out.println("Navigating to URL: " + url);
        driver.get(url);
    }
}
    
