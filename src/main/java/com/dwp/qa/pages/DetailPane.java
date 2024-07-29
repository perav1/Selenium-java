//Existing Required DWP record
package com.dwp.qa.pages;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;


import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dwp.qa.util.TakeScreenshots;

public class DetailPane extends WebLocators {
	public WebDriver driver;
	public SearchBurgerMenu searchmenu;
	public SearchResults searchResults1;
	public TakeScreenshots screenshots;
	public DetailPane(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		searchmenu=new SearchBurgerMenu(driver);
		searchResults1=new SearchResults(driver);
		screenshots = new TakeScreenshots(driver);
	}
	
	
	public void checkRecord(String itemnumber, String requirement) {
	    JSONObject outputJson = new JSONObject();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    
	    try {
	        
	        ItemNumberSearch.sendKeys(itemnumber);
	        SearchRequiredDWP.click();
	        OpenRecord.click();
	        detailBurgerMenu.click();
	        screenshots.takeScreenShots("DetailBurgerMenu");
	        validateReqDWP.click();
	        System.out.println("Clicked on validateReqDWP");
	        boolean errorMessageVisible = false;
	        try {
	            wait.until(ExpectedConditions.visibilityOf(errorMessage));
	            errorMessageVisible = true;
	            System.out.println("Error message is visible.");
	        } catch (TimeoutException e) {
	            System.out.println("Error message not visible within the timeout period.");
	        }
	        
	        if (errorMessageVisible && isErrorMessageDisplayed()) {
	        	System.out.println("Error message displayed");
	            
	            wait.until(ExpectedConditions.visibilityOf(errorMessage));
	            String message = errorMessage.getText();
	            outputJson.put("errorMessage", message);
	            screenshots.takeScreenShots("errormessage");
	            okButton.click();
	            wait.until(ExpectedConditions.visibilityOf(badgeCont.get(0)));
	            for (WebElement badge : badgeCont) {
	                System.out.println("Badge count: " + badge.getText());
	            }

	            wait.until(ExpectedConditions.visibilityOf(messagePane));
	            String validationMessage1 = messagePane.getText();
	            JSONArray validationMessages = new JSONArray();
	            for (String line : validationMessage1.split("\n")) {
	                validationMessages.put(line.trim());
	            }
	            outputJson.put("validationMessages", validationMessages);

	            fullFilment.click();
	            WebElement option = fullFilment.findElement(By.xpath("//li[text()='" + requirement + "']"));
	            option.click();
	            searchResults1.selectDropdownOption(productCovered, 1);
	            searchResults1.selectDropdownOption(productVisible, 1);
	            searchResults1.selectDropdownOption(cpFragile, 2);
	            searchResults1.selectDropdownOption(cpReducibleInfo, 2);
	            searchResults1.selectDropdownOption(cpCavity, 2);

	            cpLength.clear();
	            cpLength.sendKeys("390");
	            //cpWidth.clear();
	            //cpWidth.sendKeys("300");
	            wait.until(ExpectedConditions.elementToBeClickable(AllcpVisible))  ;         
	            searchResults1.selectDropdownOption(AllcpVisible, 1);
	            searchResults1.selectDropdownOption(allcpInSameDirection, 2);
	            ulHeight.clear();
	    		ulHeight.sendKeys("900");
	            detailBurgerMenu.click();
	            validateReqDWP.click();
	            wait.until(ExpectedConditions.visibilityOf(successValidation));
	            String validationMessage = successValidation.getText();
	            outputJson.put("validMessage", validationMessage);
	            WebElement detailBurgerMenuElement = driver.findElement(By.cssSelector("i.fa.fa-th-list.fa-2x"));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", detailBurgerMenuElement);
	            wait.until(ExpectedConditions.elementToBeClickable(submitReqDWP)).click();
	            
	            handlePopups(outputJson);
	            screenshots.takeScreenShots("ExistingDWPRecord");
	        } else {
	            
	        	System.out.println("No error message displayed. Proceeding with further actions.");
	            searchResults1.selectDropdownOption(productVisible, 1);
	            WebElement detailBurgerMenuElement = driver.findElement(By.cssSelector("i.fa.fa-th-list.fa-2x"));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", detailBurgerMenuElement);
	            wait.until(ExpectedConditions.elementToBeClickable(submitReqDWP)).click();
	            
	            handlePopups(outputJson);
	            screenshots.takeScreenShots("ExistingDWPRecord");
	        }

	        // Write outputJson to file
	        try (FileWriter file = new FileWriter("output.json")) {
	            file.write(outputJson.toString(4));
	            System.out.println("Successfully wrote JSON object to file.");
	        } catch (Exception e) {
	            System.out.println("Error writing JSON to file: " + e.getMessage());
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
	private boolean isErrorMessageDisplayed() {
	    try {
	        return errorMessage.isDisplayed();
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	}

	public void handlePopups(JSONObject outputJson) {
	    if (changeRequestPOPUP.isDisplayed()) {
	        handleChangeRequest(outputJson);
	    } else if (deviationReportPOPUP.isDisplayed()) {
	        handleDeviationReport(outputJson);
	    } else if (updateReasonspopUP.isDisplayed()) {
	        handleUpdateReason(outputJson);
	    } else {
	        System.out.println("No expected popups displayed. Clicking Submit again.");
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.elementToBeClickable(submitReqDWP)).click(); // Submit again if no popups are displayed
	    }
	}

	

	public void handleUpdateReason(JSONObject outputJson) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    try {
	    	screenshots.takeScreenShots("updateReasonPOPUP");
	        wait.until(ExpectedConditions.elementToBeClickable(reqSpecifyUpdateReason)).click();
	        searchResults1.selectDropdownOption(reqSpecifyUpdateReason, 2);
	        wait.until(ExpectedConditions.elementToBeClickable(proceesSubmitUpdateReason)).click();
	        WebElement submitSuccessMessage = wait.until(ExpectedConditions
	                .visibilityOfElementLocated(By.xpath("//div[contains(text(), 'DWP submitted successfully')]")));
	        String successMessage = submitSuccessMessage.getText();
	        outputJson.put("successMessage", successMessage);
	        screenshots.takeScreenShots("successmessage");
	        wait.until(ExpectedConditions.elementToBeClickable(submitOkButton)).click();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public void handleDeviationReport(JSONObject outputJson) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    try {
	        String dMessage = deviationReportmessage.getText();
	        outputJson.put("message", dMessage);
	        wait.until(ExpectedConditions.elementToBeClickable(okDeviation)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(detailBurgerMenu)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(submitReqDWP)).click();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public void handleChangeRequest(JSONObject outputJson) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    try {
	        wait.until(ExpectedConditions.visibilityOf(changeRequestMesssage));
	        String cMessage = changeRequestMesssage.getText();
	        outputJson.put("message", cMessage);
	        wait.until(ExpectedConditions.elementToBeClickable(changeOKButton)).click();
	        WebElement detailBurgerMenu = driver.findElement(By.cssSelector("i.fa.fa-th-list.fa-2x"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", detailBurgerMenu);
	        wait.until(ExpectedConditions.elementToBeClickable(submitReqDWP)).click();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}