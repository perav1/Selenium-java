package com.dwp.qa.BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import com.dwp.qa.pages.LoginPage;

public class BaseClass {
	public WebDriver driver;
    public Properties prop;

    public WebDriver initializeDriver() {
        prop = loadProperties();
        String browserName = prop.getProperty("browser");

        System.out.println("Initializing WebDriver with browser: " + browserName);

        if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browserName);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        return driver;
    }

    public Properties loadProperties() {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream("C:\\Users\\PERAV1\\eclipse-workspace\\Dimensionsweightsandpackages\\src\\main\\resources\\Global.Properties")) {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public String getScreenshot(String testCaseName) throws IOException {
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized.");
        }

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationPath = System.getProperty("user.dir") + File.separator + "reports" + File.separator + testCaseName + ".png";
        File destinationFile = new File(destinationPath);
        FileUtils.copyFile(source, destinationFile);
        return destinationPath;
    }

    public LoginPage launchApplication() {
        driver = initializeDriver();
        prop = loadProperties();
        LoginPage page = new LoginPage(driver, prop);
        page.goTo();
        return page;
    }
}