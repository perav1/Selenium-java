package com.dwp.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Actualscreen {
	public WebDriver driver;
	public Actualscreen(WebDriver driver)
	{
		super();
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy(css = "a[href='/Actual/Actual']")
	WebElement actualTab;
	
	public void actualLogin()
	{
		actualTab.click();
	}

}
