package com.dwp.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
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
	
	
	
	public void LoginApplication(String email)
	{
		Useremail.sendKeys(email);
		submit.click();
		
		
	}
	public void loginDetails(String username,String password)
	{
		userName.sendKeys(username);
		Password.sendKeys(password);
		signIn.click();
		
	}
	
	public void goTo()
	{
		driver.get("https://cfnew.www.supplychain-dwp.ikeadt.com/");
	}

}
