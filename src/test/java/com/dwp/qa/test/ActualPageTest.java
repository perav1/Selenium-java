package com.dwp.qa.test;

import java.time.Duration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dwp.qa.BaseTest.BaseClass;
import com.dwp.qa.pages.Actualscreen;

public class ActualPageTest<object> extends BaseClass {
	private Actualscreen screen;
	private LoginPageTest pagetest;
	
	@BeforeMethod
	public void setUPScreen()
	{
		screen=new Actualscreen(driver);
		pagetest=new LoginPageTest<Object>();
	}
	@Test
	public void actualLoginPage()
	{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		screen.actualLogin();
	}

}
