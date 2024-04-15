package com.dwp.qa.BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import com.dwp.qa.pages.LoginPage;
import com.google.common.collect.ImmutableMap;


public class BaseClass {
	public WebDriver driver;
	
	public WebDriver initializeDriver() 
	{
		Properties prop=new Properties();
		try
		{
		FileInputStream fis=new FileInputStream("C:\\Users\\PERAV1\\eclipse-workspace\\Dimensionsweightsandpackages\\src\\main\\resources\\Global.Properties");
		prop.load(fis);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		//EdgeOptions edgeOptions = new EdgeOptions();
        //edgeOptions.addArguments("--inprivate");
		 //edgeOptions.setCapability("ms:edgeOptions", ImmutableMap.of("msInPrivate", true));
		 //edgeOptions.setExperimentalOption("excludeswitches", Arrays.asList("--disable-popup-blocking"));
		// edgeOptions.addArguments("--disable-popup-blocking");

		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("edge"))
		{
				
	 WebDriverManager.edgedriver().setup();
	  driver=new EdgeDriver();
	  //((JavascriptExecutor) driver).executeScript("window.open = function(){};");
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			
			WebDriverManager.chromedriver().setup(); 
            driver = new ChromeDriver();
        }
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 return driver;
	}
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
		}
		public LoginPage LaunchAppication()
	 {
		 driver=initializeDriver() ;
		 LoginPage page=new LoginPage(driver);
		 page.goTo();
		 return page;
	 }
	 
	}

