package com.dwp.qa.pages;

import java.time.Duration;
import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultiUpdate extends SearchContextMenu {
	private SearchResults searchResults1;

	public MultiUpdate(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
		searchResults1=new SearchResults(driver);
	}
	public void multiUpdateSearch(String itemnumber)
	{
		JSONObject outputJson = new JSONObject();
		try
		{
		ItemNumberSearch.sendKeys(itemnumber);
		SearchRequiredDWP.click();
		OpenRecord.click();
		productCovered.click();
		Select basedrop1 = new Select(productCovered);
		WebElement initialOption1 = basedrop1.getFirstSelectedOption();
		basedrop1.selectByIndex(1);
		String basevalue1 = basedrop1.getFirstSelectedOption().getText();
		productVisible.click();
		Select basedown2 = new Select(productVisible);
		WebElement initialOption2 = basedown2.getFirstSelectedOption();
		basedown2.selectByIndex(1);
		String basevalue2 = basedown2.getFirstSelectedOption().getText();
		if(initialOption1.getText().equals(basevalue1)||initialOption2.getText().equals(basevalue2) )
		{
			detailBurgerMenu.click();
			submitReqDWP.click();
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(reqSpecifyUpdateReason)).click();
		    searchResults1.selectDropdownOption(reqSpecifyUpdateReason, 2);
		    wait.until(ExpectedConditions.elementToBeClickable(proceesSubmitUpdateReason)).click();
			 
		    // selectByIndex(1) did not change the selected option
		    Notification.click();
		    String validationMessage = Message1.getText();
		    System.out.println("Validation Message: " + validationMessage);
		}
		else
		{
		detailBurgerMenu.click();
		submitReqDWP.click();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait2.until(ExpectedConditions.elementToBeClickable(reqSpecifyUpdateReason)).click();
	    searchResults1.selectDropdownOption(reqSpecifyUpdateReason, 2);
	    wait2.until(ExpectedConditions.elementToBeClickable(proceesSubmitUpdateReason)).click();
		
		WebElement submitSuccessMessage = wait2.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'DWP submitted successfully')]")));
		;
		String successmessage = submitSuccessMessage.getText();
		System.out.println("Success:" + successmessage);
		submitOkButton.click();
		WebElement searchpane = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='chevron fa fa-fw col-lg-1']")));
		searchpane.click();
		wait2.until(ExpectedConditions.elementToBeClickable(ItemNumberSearch));
		ItemNumberSearch.clear();
		ItemNumberSearch.sendKeys(itemnumber);
		SearchRequiredDWP.click();
		Actions a = new Actions(driver);

		wait2.until(ExpectedConditions.elementToBeClickable(OpenRecord));
		a.contextClick(OpenRecord).build().perform();
		searchMultiUpdate.click();
		multiupdatePANumber.sendKeys("1122");
		multiUpdateSearch.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		List<WebElement> rows = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='multiUpdateSearchResults']/tbody/tr")));
		int rowCount = rows.size();
		System.out.println("Total number of rows: " + rowCount);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loadingContent")));
		for(WebElement multiUpdateCheckbox:multiUpdateCheckboxs)
		{
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait1.until(ExpectedConditions.elementToBeClickable(multiUpdateCheckbox));
			multiUpdateCheckbox.click();
			
		}
		updateAllAttributes.click();
		List<WebElement> rows1 = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='multiUpdateResults']/tbody/tr")));
		int rowCount1 = rows1.size();
		System.out.println("Total number of rows: " + rowCount1);
		WebElement copyNumber = driver.findElement(By.xpath(
				"(//td[translate(normalize-space(), '0123456789', '0000000000') = '00000000'])[6]"));
		String ItemNumber = copyNumber.getText();
		WebElement closeButton = driver.findElement(By.xpath("//button[@title='Close']"));

		closeButton.click();
		WebElement searchpane1 = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='chevron fa fa-fw col-lg-1']")));
		searchpane1.click();
		ItemNumberSearch.clear();
		ItemNumberSearch.sendKeys(ItemNumber);
		SearchRequiredDWP.click();
		wait2.until(ExpectedConditions.elementToBeClickable(OpenRecord));
		OpenRecord.click();
		Select targetdrop1 = new Select(productCovered);
		String targetvalue1 = targetdrop1.getFirstSelectedOption().getText();
		Select targetdrop2 = new Select(productVisible);
		String targetvalue2 = targetdrop2.getFirstSelectedOption().getText();
		
		if(basevalue1.equals(targetvalue1) && basevalue2.equals(targetvalue2))
		{
			System.out.println("Dropdown values are the same for both base and target records.");
		}
		else
		{
			System.out.println("Dropdown values are different for base and target records.");
		}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	}
