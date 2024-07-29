package com.dwp.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshots {
	public WebDriver driver;
	public Properties prop;

	public TakeScreenshots(WebDriver driver) {
		this.driver = driver;

	}

	public void takeScreenShots(String action) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String timeStamp = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss").format(LocalDateTime.now());
		String fileName = action + "_" + timeStamp + ".png";
		String screenshotDirectory = "C:\\Users\\PERAV1\\eclipse-workspace\\Dimensionsweightsandpackages\\screenshots";

		
		File dir = new File(screenshotDirectory);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		File dest = new File(screenshotDirectory + "/" + fileName);
		//System.out.println("Screenshot taken for: " + action + " and saved to: " + dest.getAbsolutePath());
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			System.out.println("Failed to take screenshot: " + e.getMessage());
			throw e; 
		}
	}

}
