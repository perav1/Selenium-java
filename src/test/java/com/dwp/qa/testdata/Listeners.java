package com.dwp.qa.testdata;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.dwp.qa.BaseTest.BaseClass;
import com.dwp.qa.util.DWPExtentReports;


public class Listeners  extends BaseClass implements ITestListener {
	ExtentTest test;
	ExtentReports extent=DWPExtentReports.getReportObject();
	@Override
	public void onTestStart(ITestResult result)
	{
	  test=extent.createTest(result.getMethod().getMethodName());
	}
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		test.log(Status.PASS, "Test Passed");
	}
	@Override
	public void onTestFailure(ITestResult result)
	{
		
		test.fail(result.getThrowable());
		String filePath=null;
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try
		{
		 filePath=getScreenshot(result.getMethod().getMethodName(), driver);
		}
		catch(Exception e)
		{
        e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}
    @Override
    public void onTestSkipped(ITestResult result)
    {
    	
    }
    @Override
    public void onFinish(ITestContext context)
    {
    	extent.flush();
    }
    
}
