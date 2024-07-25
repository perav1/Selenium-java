package com.dwp.qa.testdata;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.dwp.qa.BaseTest.BaseClass;
import com.dwp.qa.util.DWPExtentReports;


public class Listeners  extends BaseClass implements ITestListener {
	private ExtentTest test;
    private static ExtentReports extent;

    // Initialize ExtentReports only once per test suite run
    @Override
    public void onStart(ITestContext context) {
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("extentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("OS", "Windows");
            extent.setSystemInfo("Browser", "edge");
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	String methodName = result.getMethod().getMethodName();
        try {
            BaseClass base = (BaseClass) result.getInstance();
            WebDriver driver = base.driver; // Ensure driver is properly initialized
            if (driver != null) {
                String screenshotPath = base.getScreenshot(methodName);
                test.fail(result.getThrowable().getMessage());
                test.addScreenCaptureFromPath(screenshotPath, "Failed Test Screenshot");
            } else {
                test.fail("Driver is not initialized.");
            }
        } catch (IOException e) {
            test.fail("Exception occurred while taking screenshot: " + e.getMessage());
        }
    }
    @Override
    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush();
        }
    }
}