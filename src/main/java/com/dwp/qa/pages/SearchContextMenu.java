//View,Expire,Delete,Show Actual DWP,Copy to New DWP
package com.dwp.qa.pages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
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

import sun.net.www.protocol.http.HttpURLConnection;

public class SearchContextMenu extends RequiredScreen {
	public WebDriver driver;
	private SearchResults searchResults1;
	
	public SearchContextMenu(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		searchResults1=new SearchResults(driver);
		
	}

	@FindBy(xpath = "//button[normalize-space()='View']")
	WebElement Viewbutton;
	@FindBy(xpath = "//button[normalize-space()='Copy to new DWP']")
	WebElement copyNewDWP;
	
	@FindBy(xpath = "(//i[@class='fa fa-th-list fa-2x'])[1]")
	WebElement detailBurgerMenu;
	@FindBy(id = "validateRequiredDWP")
	WebElement validateReqDWP;
	@FindBy(xpath = "(//div[@class='modal-body'])[1]")
	WebElement errorMessage;
	@FindBy(xpath = "//button[normalize-space()='OK']")
	WebElement alertMessage;
	@FindBy(xpath = "//div[@id='msgPane']")
	WebElement messagePane;
	@FindBy(xpath = "//ul[@class='select2-selection__rendered']")
	WebElement fullFilment;
	@FindBy(id = "cpProductiscoveredInfoEdit1")
	WebElement productCovered;
	@FindBy(id = "cpProductisvisibleInfoEdit1")
	WebElement productVisible;
	@FindBy(id = "ddlCPReducibleInfoEdit1")
	WebElement cpReducibleInfo;
	@FindBy(id = "cpCavityInfoEdit1")
	WebElement cpCavityInfo;
	@FindBy(id = "ulAllcpVisible")
	WebElement AllcpVisible;
	@FindBy(id = "ulAllcpInSameDirection")
	WebElement allcpInSameDirection;
	@FindBy(id = "reqCPReductionOptionSelection1")
	WebElement reqCPReductionOptionSelection;
	@FindBy(id = "btnUpdateCPReductionOptions")
	WebElement saveCPReductionOption;
	@FindBy(id = "ddlCPReductionSubOpt")
	WebElement cpReductionSub;
	@FindBy(id = "cpReductionLength")
	WebElement reductionLenth;
	@FindBy(id = "cpReductionDiameter")
	WebElement reductionDiameter;
	@FindBy(id = "cpLengthInfoEdit1")
	WebElement cpLength;
	@FindBy(id = "cpWidthInfoEdit1")
	WebElement cpWidth;
	@FindBy(id = "cpHeightInfoEdit1")
	WebElement cpHeight;
	@FindBy(xpath = "//div[normalize-space()='DWP is valid. Save / Submit can be performed.']")
	WebElement successMessage;
	@FindBy(id = "submitRequiredDWP")
	WebElement submitReqDWP;
	@FindBy(xpath = "//button[normalize-space()='OK']")
	WebElement submitOkButton;
	@FindBy(xpath = "//button[normalize-space()='Expire']")
	WebElement expiredButton;
	@FindBy(xpath = "//button[@type='button'][normalize-space()='Cancel']")
	WebElement cancelButton;
	@FindBy(xpath = "//button[normalize-space()='OK']")
	WebElement okButton;
	@FindBy(xpath = "//button[normalize-space()='Delete']")
	WebElement deleteButton;
	@FindBy(xpath = "//button[normalize-space()='OK']")
	WebElement deleteOkbutton;
	@FindBy(xpath = "//button[normalize-space()='Show Actual DWP(s)']")
	WebElement showActualDWP;
	@FindBy(id = "showActualConnectedToRequiredLegendContainer")
	WebElement showActualConnectedContainer;
	@FindBy(xpath = "//button[normalize-space()='Multi Create']")
	WebElement multiCreateButton;
	@FindBy(id = "txtSearchMultiCreateItemNumber")
	WebElement searchMultiCreateItemNumber;
	@FindBy(id = "btnMultiCreateSearch")
	WebElement submitButton;
	@FindBy(xpath = "(//input[@type='checkbox'])[20]|(//input[@type='checkbox'])[21]")
	List<WebElement> multiCreateCheckboxs;
	@FindBy(id = "btnMultiCreate")
	WebElement createButton;
	@FindBy(xpath="//button[normalize-space()='Multi Update']")
	WebElement searchMultiUpdate;
	@FindBy(id="txtSearchMultiUpdatePANumber")
	WebElement multiupdatePANumber;
	@FindBy(id="btnMultiUpdateSearch")
	WebElement multiUpdateSearch;
	@FindBy(xpath="(//input[@type='checkbox'])[18]|(//input[@type='checkbox'])[19]|(//input[@type='checkbox'])[20]")
	List<WebElement> multiUpdateCheckboxs;
	@FindBy(id="btnMultiUpdateAll")
	WebElement updateAllAttributes;
	@FindBy(xpath = "//div[@id='MSG69']")
	WebElement Message1;
	@FindBy(id="reqSpecifyUpdateReasonInfoEdit")
	WebElement reqSpecifyUpdateReason;
	@FindBy(id="btnProceedSubmitUpdateReason")
	WebElement proceesSubmitUpdateReason;
	@FindBy(id = "ulHeightInfoEdit")
	WebElement ulHeight;
	@FindBy(xpath="//div[@class='modal-content']")
	WebElement errorPOPUP;
	@FindBy(xpath="//i[@class='fa fa-bell faa-ring fa-2x']")
	WebElement notification;
	@FindBy(id="notificationBadgeCount")
	List<WebElement> badgeCont;

	public void openContextMenu(String itemnumber) {
		ItemNumberSearch.sendKeys(itemnumber);
		SearchRequiredDWP.click();
		Actions a = new Actions(driver);
		a.contextClick(OpenRecord).build().perform();
	}

	public void openViewMode(String itemnumber) {
		ItemNumberSearch.sendKeys(itemnumber);
		SearchRequiredDWP.click();
		Actions a = new Actions(driver);
		a.contextClick(OpenRecord).build().perform();
		Viewbutton.click();
	}

	public void openCopyNewDWP(String itemnumber, String requirement) throws InterruptedException {
		JSONObject outputJson = new JSONObject();
		ItemNumberSearch.sendKeys(itemnumber);
		Thread.sleep(2000);
		SearchRequiredDWP.click();
		Actions a = new Actions(driver);
		a.contextClick(OpenRecord).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(copyNewDWP));
		copyNewDWP.click();
		detailBurgerMenu.click();
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
	        
	        if (errorMessageVisible && isErrorMessageDisplayed())  {
        	System.out.println("Error message displayed");
            
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            String message = errorMessage.getText();
            outputJson.put("errorMessage", message);

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
		productCovered.click();
		Select dropdown = new Select(productCovered);
		dropdown.selectByIndex(1);
		productVisible.click();
		Select dropdown1 = new Select(productVisible);
		dropdown1.selectByIndex(1);
		cpReducibleInfo.click();

		Select dropdown2 = new Select(cpReducibleInfo);
		dropdown2.selectByIndex(2);
		/*
		 * reqCPReductionOptionSelection.click(); cpReductionSub.click(); Select
		 * suboption=new Select(cpCavityInfo); suboption.selectByIndex(1);
		 * reductionLenth.sendKeys("290"); reductionDiameter.sendKeys("290");
		 * saveCPReductionOption.click();
		 */
		cpCavityInfo.click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.elementToBeClickable(cpCavityInfo));
		Select dropdown3 = new Select(cpCavityInfo);
		dropdown3.selectByIndex(2);
		cpLength.clear();
		cpLength.sendKeys("150");
		cpWidth.clear();
		cpWidth.sendKeys("140");
		cpHeight.clear();
		cpHeight.sendKeys("100");
		AllcpVisible.click();
		Select dropdown4 = new Select(AllcpVisible);
		dropdown4.selectByIndex(1);
		allcpInSameDirection.click();
		Select dropdown5 = new Select(allcpInSameDirection);
		dropdown5.selectByIndex(1);
		ulHeight.clear();
		ulHeight.sendKeys("200");
		detailBurgerMenu.click();
		validateReqDWP.click();
		wait.until(ExpectedConditions.visibilityOf(successMessage));
        String validationMessage = successMessage.getText();
        outputJson.put("validMessage", validationMessage);
        WebElement detailBurgerMenuElement = driver.findElement(By.cssSelector("i.fa.fa-th-list.fa-2x"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", detailBurgerMenuElement);
        wait.until(ExpectedConditions.elementToBeClickable(submitReqDWP)).click();
		wait.until(ExpectedConditions.elementToBeClickable(reqSpecifyUpdateReason)).click();
        searchResults1.selectDropdownOption(reqSpecifyUpdateReason, 2);
        wait.until(ExpectedConditions.elementToBeClickable(proceesSubmitUpdateReason)).click();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement submitSuccessMessage = wait2.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'DWP submitted successfully')]")));
		;
		String successmessage = submitSuccessMessage.getText();
		System.out.println("Success:" + successmessage);
		submitOkButton.click();
		}
		else
		{
			System.out.println("No error message displayed. Proceeding with further actions.");
            searchResults1.selectDropdownOption(productVisible, 2);
            WebElement detailBurgerMenu = driver.findElement(By.cssSelector("i.fa.fa-th-list.fa-2x"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", detailBurgerMenu);
            wait.until(ExpectedConditions.elementToBeClickable(submitReqDWP)).click();
            wait.until(ExpectedConditions.elementToBeClickable(reqSpecifyUpdateReason)).click();
            searchResults1.selectDropdownOption(reqSpecifyUpdateReason, 2);
            wait.until(ExpectedConditions.elementToBeClickable(proceesSubmitUpdateReason)).click();
    		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
    		WebElement submitSuccessMessage = wait2.until(ExpectedConditions
    				.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'DWP submitted successfully')]")));
    		;
    		String successmessage = submitSuccessMessage.getText();
    		System.out.println("Success:" + successmessage);
    		submitOkButton.click();
		}
	}
	private boolean isErrorMessageDisplayed() {
	    try {
	        return errorMessage.isDisplayed();
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	}

	public void expiredContextMenuSearch(String itemnumber) {
		ItemNumberSearch.sendKeys(itemnumber);
		SearchRequiredDWP.click();
		Actions a = new Actions(driver);
		a.contextClick(OpenRecord).build().perform();
		expiredButton.click();
		okButton.click();
		ItemNumberSearch.clear();
		RequiredScreen screen = new RequiredScreen(driver);
		screen.dwpExpiredSearch(itemnumber);

		// cancelButton.click();
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// WebElement warningMessage =
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),
		// 'Are you sure you want to discard changes on Edit screen ?')]")));
		// String message=warningMessage.getText();
		// System.out.println("Warning:" +message);
	}

	public void deleteContextMenuSearch(String itemnumber) {

		ItemNumberSearch.sendKeys(itemnumber);
		SearchRequiredDWP.click();
		//List<WebElement> rows = driver.findElements(By.xpath("//table[@id='requiredSearchResults']/tbody/tr"));
		int totalRecordsBeforeDeletion = searchResults1.getItemTotalRecords();
		System.out.println("Records shown before deletion: " + totalRecordsBeforeDeletion);

		Actions a = new Actions(driver);
		a.contextClick(OpenRecord).build().perform();
		deleteButton.click();
		deleteOkbutton.click();
		ItemNumberSearch.clear();
		ItemNumberSearch.sendKeys(itemnumber);

		SearchRequiredDWP.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//table[@id='requiredSearchResults']/tbody/tr"),
				totalRecordsBeforeDeletion - 1));

		List<WebElement> rowsAfterDeletion = driver
				.findElements(By.xpath("//table[@id='requiredSearchResults']/tbody/tr"));
		int totalRecordsAfterDeletion = rowsAfterDeletion.size();
		System.out.println("Records shown after deletion: " + totalRecordsAfterDeletion);

	}

	public void showActualDWPContextMenu(String itemnumber) {
		ItemNumberSearch.sendKeys(itemnumber);
		SearchRequiredDWP.click();
		Actions a = new Actions(driver);
		a.contextClick(OpenRecord).build().perform();
		showActualDWP.click();

		WebElement columns = driver
				.findElement(By.xpath("//table[@id='showActualConnectedToRequiredResult']//thead//tr[@role='row']"));
		String columnNames = columns.getText();
		System.out.println("columns as:" + columnNames);
		String connectedContainer = showActualConnectedContainer.getText();
		System.out.println("ContainerText is:" + connectedContainer);
		List<WebElement> rows = driver
				.findElements(By.xpath("//table[@id='showActualConnectedToRequiredResult']/tbody/tr"));
		int rowCount = rows.size();
		System.out.println("Total number of rows: " + rowCount);
		for (int i = 0; i < rowCount; i++) {
			// Get the background color of the row
			WebElement row = rows.get(i);
			String color = row.getCssValue("background-color");
			System.out.println("Row " + (i + 1) + " Color: " + color);

		}
	}

}

