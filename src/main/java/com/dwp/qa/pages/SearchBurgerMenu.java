//New blank DWP functionality,find change request
package com.dwp.qa.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dwp.qa.util.TakeScreenshots;

public class SearchBurgerMenu extends WebLocators {
	public WebDriver driver;
	private SearchResults searchResults1;
	public TakeScreenshots screenshots;
	public SearchBurgerMenu(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		searchResults1=new SearchResults(driver);
		screenshots = new TakeScreenshots(driver);
		
	}

	

	public void openNewBlankDWP(String itemnumber, String requirement) {
		try {

			ItemNumberSearch.sendKeys(itemnumber);
			SearchRequiredDWP.click();
			selectedSearchResults.click();
			searchBurgerMenu.click();
			screenshots.takeScreenShots("burgermenu");
			WebElement newBlankDWP = driver.findElement(By.id("newDWP"));
			newBlankDWP.click();
			detailBurgerMenu.click();
			validateReqDWP.click();
			alertMessage.click();
			screenshots.takeScreenShots("alretMessage");
			String ValidationMessage1 = messagePane.getText();
			System.out.println("Validation Message: " + ValidationMessage1);
			fullFilment.click();
			WebElement option = fullFilment.findElement(By.xpath("//li[text()='" + requirement + "']"));
			option.click();
			saleSolution.click();
			Select saledropdown = new Select(saleSolution);
			saledropdown.selectByIndex(1);
			cpPackagingMaterial.click();
			Select cppackaging = new Select(cpPackagingMaterial);
			cppackaging.selectByIndex(1);
			productCovered.click();
			Select productcovered = new Select(productCovered);
			productcovered.selectByIndex(1);
			productVisible.click();
			Select productvisible = new Select(productVisible);
			productvisible.selectByIndex(1);
			cpFragile.click();
			Select cpfragile = new Select(cpFragile);
			cpfragile.selectByIndex(2);
			cpReducibleInfo.click();
			Select cpreducible = new Select(cpReducibleInfo);
			cpreducible.selectByIndex(2);
			cpCavity.click();
			Select cpcavity = new Select(cpCavity);
			cpcavity.selectByIndex(2);
			cpDustProtection.click();
			Select cpdustprotection = new Select(cpDustProtection);
			cpdustprotection.selectByIndex(1);
			cpServicePackaging.click();
			Select cpservicepackaging = new Select(cpServicePackaging);
			cpservicepackaging.selectByIndex(2);
			cpLength.sendKeys("150");
			cpWidth.sendKeys("140");
			cpHeight.sendKeys("100");
			storeFacingWidth.click();
			Select storefacingwidth = new Select(storeFacingWidth);
			storefacingwidth.selectByIndex(2);
			storeFacingHeight.click();
			Select storefacingheight = new Select(storeFacingHeight);
			storefacingheight.selectByIndex(1);
			cpGrossWeight.sendKeys("1");
			mpQty.sendKeys("15");
			mpPanelHeading.click();
			mpSalesSolutionIndication.click();
			Select mpsalessolution = new Select(mpSalesSolutionIndication);
			mpsalessolution.selectByIndex(1);
			mpSuitableForSideLength.click();
			Select mpsuitable = new Select(mpSuitableForSideLength);
			mpsuitable.selectByIndex(1);
			mpLength.sendKeys("200");
			mpWidth.sendKeys("190");
			mpHeight.sendKeys("180");
			partAdd.click();
			partId.sendKeys("AK");
			partName.click();
			Select partname = new Select(partName);
			partname.selectByIndex(1);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			partQty.sendKeys("1");
			partWeight.sendKeys("0.0001");
			nextButton.click();
			/*
			 * WebElement
			 * warningMessage=driver.findElement(By.xpath("//div[@class='modal-body']"));
			 * String getwarninginformation=warningMessage.getText();
			 * System.out.println("Warning message is:"+getwarninginformation);
			 */
			// clickOk.click();
			packagingMaterial.click();
			Select selectPackagingMaterial = new Select(packagingMaterial);
			selectPackagingMaterial.selectByIndex(2);
			recycleMaterialShare.sendKeys("50");
			materialNextButton.click();
			WebElement informationMessage = driver.findElement(By.xpath("//div[@id='pmMsgPane']"));
			String getinformation = informationMessage.getText();
			System.out.println("Warning message is:" + getinformation);
			WebElement messagePaneClose = driver.findElement(By.xpath("//span[@id='part-east-closer']"));
			messagePaneClose.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement materialPartAdd = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.id("reqPMAddBtn")));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", materialPartAdd);
			ulQty.sendKeys("30");
			stakingIndication.click();
			Select stakingindication = new Select(stakingIndication);
			stakingindication.selectByIndex(1);
			sutableTopFilling.click();
			Select sutabletopfilling = new Select(sutableTopFilling);
			sutabletopfilling.selectByIndex(2);
			AllcpVisible.click();
			Select allvisible = new Select(AllcpVisible);
			allvisible.selectByIndex(1);
			ulSaleSolution.click();
			Select ulsalesolution = new Select(ulSaleSolution);
			ulsalesolution.selectByIndex(2);
			ulFireClass.click();
			Select ulfireclass = new Select(ulFireClass);
			ulfireclass.selectByIndex(2);
			allcpInSameDirection.click();
			Select allcpinsamedirection = new Select(allcpInSameDirection);
			allcpinsamedirection.selectByIndex(1);
			ulLength.sendKeys("1000");
			ulWidth.sendKeys("280");
			ulHeight.sendKeys("200");
			ulstoreFacing.click();
			unitLoadCategory.click();
			Select unitloadcategory = new Select(unitLoadCategory);
			unitloadcategory.selectByIndex(1);
			detailBurgerMenu.click();
			validateReqDWP.click();
			String success = successMessage.getText();

			System.out.println("Success Message: " + success);
			screenshots.takeScreenShots("successmessage");
			Thread.sleep(2000);
			performSaveNewblankDWP();
			performSubmitwithoutPR();
			performSubmitwithPR();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void performSaveNewblankDWP() {
		try {

			// openNewBlankDWP("itemnumber", "requirement");
			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait2.until(ExpectedConditions.elementToBeClickable(detailBurgerMenu));
			detailBurgerMenu.click();
			Thread.sleep(2000);
			saveRequiredDWP.click();
			wait2.until(ExpectedConditions.elementToBeClickable(successSave));
			String successMessage = successSave.getText();
			System.out.println("Success is:" + successMessage);
			// wait2.until(ExpectedConditions.elementToBeClickable(clickOk));
			clickOk.click();
			Thread.sleep(2000);
			String saveGetStatus = getStatus.getText();
			System.out.println("Status:" + saveGetStatus);
			screenshots.takeScreenShots("DraftStatus");
			// wait2.until(ExpectedConditions.elementToBeClickable(OpenRecord));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void performSubmitwithoutPR() {
		try {
			OpenRecord.click();
			// WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
			// wait2.until(ExpectedConditions.elementToBeClickable(OpenRecord));
			// OpenRecord.click();
			// clickOk.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loadingContent")));
			WebElement detailBurgerMenu = driver.findElement(By.cssSelector("i.fa.fa-th-list.fa-2x"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", detailBurgerMenu);
			Thread.sleep(2000);
			submitReqDWP.click();
			wait.until(ExpectedConditions.elementToBeClickable(reqSpecifyUpdateReason)).click();
	        searchResults1.selectDropdownOption(reqSpecifyUpdateReason, 2);
	        wait.until(ExpectedConditions.elementToBeClickable(proceesSubmitUpdateReason)).click();
			//warningOk1.click();
			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement submitSuccessMessage = wait2.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'DWP submitted successfully')]")));
			;
			String successmessage = submitSuccessMessage.getText();
			System.out.println("Success:" + successmessage);
			submitOkButton.click();
			Thread.sleep(2000);
			String saveGetStatus = getStatus.getText();
			System.out.println("Status:" + saveGetStatus);
			screenshots.takeScreenShots("Prel status");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void performSubmitwithPR() {
		try {
			OpenRecord.click();

			packagingRequirement.click();
			Select pr = new Select(packagingRequirement);
			pr.selectByIndex(1);
			WebElement detailBurgerMenu = driver.findElement(By.cssSelector("i.fa.fa-th-list.fa-2x"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", detailBurgerMenu);
			Thread.sleep(2000);
			submitReqDWP.click();
			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait2.until(ExpectedConditions.elementToBeClickable(reqSpecifyUpdateReason)).click();
	        searchResults1.selectDropdownOption(reqSpecifyUpdateReason, 2);
	        wait2.until(ExpectedConditions.elementToBeClickable(proceesSubmitUpdateReason)).click();
			//warningOk.click();
			
			WebElement submitSuccessMessage = wait2.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'DWP submitted successfully')]")));
			;
			String successmessage = submitSuccessMessage.getText();
			System.out.println("Success:" + successmessage);
			submitOkButton.click();
			Thread.sleep(2000);
			String saveGetStatus = getStatus.getText();
			System.out.println("Status:" + saveGetStatus);
			screenshots.takeScreenShots("submit status");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchWithCRid(String crwildSearch,String cridFullSearch) {
		try
		{
			//SearchResults searchResults = new SearchResults(driver);
	    // Perform *01* search
	    searchBurgerMenu.click();
	    findChangeRequest.click();
	    searchwithCR.sendKeys(crwildSearch);
	    searchChangeRequest.click();
	    System.out.println("Results for wild search with CRId:");
	   int totalRecordsSmartWildSearch = searchResults1.getFCTotalRecords();

	    // Perform smart search with "215630001"
	    searchwithCR.clear();
	    searchwithCR.sendKeys(cridFullSearch);
	    searchChangeRequest.click();
	    System.out.println("\nResults for smart search with full CRId number:");
	    int totalRecordsSmartFullSearch = searchResults1.getFCTotalRecords();

	    // Perform exact search with "*01*"
	    searchwithCR.clear();
	    searchwithCR.sendKeys(crwildSearch);
	    exactChangeRequest.click();
	    searchChangeRequest.click();
	    System.out.println("\nResults for exact search with CRId wild:");
	    int totalRecordsExactWildSearch =searchResults1.getFCTotalRecords();
	  

	    // Perform exact search with "215630001"
	    searchwithCR.clear();
	    searchwithCR.sendKeys(cridFullSearch);
	    exactChangeRequest.click();
	    WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait2.until(ExpectedConditions.elementToBeClickable(searchChangeRequest));
	    searchChangeRequest.click();
	    System.out.println("\nResults for exact search with CRID full:");
	   int totalRecordsExactFullSearch = searchResults1.getFCTotalRecords();
		}
	    catch(Exception e)
	    {
	    	e.printStackTrace();	    }
	}
	public void searchWithItemNo(String itemNowildSearch,String itemNoFullSearch ) {
		try
		{

		
		 
		searchBurgerMenu.click();
	    findChangeRequest.click();
		changeRequestItem.click();
		searchwithCR.sendKeys(itemNowildSearch);
	    searchChangeRequest.click();
	    System.out.println("Results for wild search with ItemNo:");
	   int totalRecordsSmartWildSearch = searchResults1.getFCTotalRecords();

	    // Perform smart search with "215630001"
	    searchwithCR.clear();
	    searchwithCR.sendKeys(itemNoFullSearch);
	    searchChangeRequest.click();
	    System.out.println("\nResults for smart search with full ItemNo number:");
	    int totalRecordsSmartFullSearch = searchResults1.getFCTotalRecords();

	    // Perform exact search with "*01*"
	    searchwithCR.clear();
	    searchwithCR.sendKeys(itemNowildSearch);
	    exactChangeRequest.click();
	    searchChangeRequest.click();
	    System.out.println("\nResults for exact search with ItemNo wild:");
	    int totalRecordsExactWildSearch = searchResults1.getFCTotalRecords();

	    // Perform exact search with "215630001"
	    searchwithCR.clear();
	    searchwithCR.sendKeys(itemNoFullSearch);
	    exactChangeRequest.click();
	    
	    searchChangeRequest.click();
	    System.out.println("\nResults for exact search with full ItemNo:");
	    int totalRecordsExactFullSearch = searchResults1.getFCTotalRecords();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
}
}
		
	
		

	
