package com.dwp.qa.pages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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
	@FindBy(xpath = "(//input[@type='checkbox'])[6]|(//input[@type='checkbox'])[7]")
	List<WebElement> multiCreateCheckboxs;
	@FindBy(id = "btnMultiCreate")
	WebElement createButton;
	@FindBy(xpath="//button[normalize-space()='Multi Update']")
	WebElement searchMultiUpdate;
	@FindBy(id="txtSearchMultiUpdatePANumber")
	WebElement multiupdatePANumber;
	@FindBy(id="btnMultiUpdateSearch")
	WebElement multiUpdateSearch;
	@FindBy(xpath="(//input[@type='checkbox'])[8]|(//input[@type='checkbox'])[9]|(//input[@type='checkbox'])[10]")
	List<WebElement> multiUpdateCheckboxs;
	@FindBy(id="btnMultiUpdateAll")
	WebElement updateAllAttributes;
	@FindBy(xpath = "//div[@id='MSG69']")
	WebElement Message1;

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

	public void openCopyNewDWP(String itemnumber, String requirement) {
		ItemNumberSearch.sendKeys(itemnumber);
		SearchRequiredDWP.click();
		Actions a = new Actions(driver);
		a.contextClick(OpenRecord).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(copyNewDWP));
		copyNewDWP.click();
		detailBurgerMenu.click();
		validateReqDWP.click();
		alertMessage.click();
		String ValidationMessage = errorMessage.getText();
		System.out.println("Validation Message: " + ValidationMessage);
		String ValidationMessage1 = messagePane.getText();
		System.out.println("Validation Message: " + ValidationMessage1);
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
		AllcpVisible.click();
		Select dropdown4 = new Select(AllcpVisible);
		dropdown4.selectByIndex(1);
		allcpInSameDirection.click();
		Select dropdown5 = new Select(allcpInSameDirection);
		dropdown5.selectByIndex(1);
		detailBurgerMenu.click();
		validateReqDWP.click();
		String success = successMessage.getText();

		System.out.println("Success Message: " + success);
		detailBurgerMenu.click();
		submitReqDWP.click();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement submitSuccessMessage = wait2.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'DWP submitted successfully')]")));
		;
		String successmessage = submitSuccessMessage.getText();
		System.out.println("Success:" + successmessage);
		submitOkButton.click();
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

	public void multiCreateSerach(String itemnumber) {
		ItemNumberSearch.sendKeys(itemnumber);
		SearchRequiredDWP.click();
		OpenRecord.click();

		AllcpVisible.click();
		Select basedropdown = new Select(AllcpVisible);
		WebElement initialOption = basedropdown.getFirstSelectedOption();
		basedropdown.selectByIndex(2);
		WebElement selectedOption = basedropdown.getFirstSelectedOption();
		if (initialOption.getText().equals(selectedOption.getText())) {
			detailBurgerMenu.click();
			submitReqDWP.click();
		    // selectByIndex(1) did not change the selected option
		    Notification.click();
		    String validationMessage = Message1.getText();
		    System.out.println("Validation Message: " + validationMessage);
		}
		else
		{
		String baseselectedOption = selectedOption.getText();
		
		System.out.println("Selected Text: " + baseselectedOption);

		detailBurgerMenu.click();
		submitReqDWP.click();
		
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement submitSuccessMessage = wait2.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'DWP submitted successfully')]")));
		;
		String successmessage = submitSuccessMessage.getText();
		System.out.println("Success:" + successmessage);
		submitOkButton.click();
		WebElement searchpane = driver.findElement(By.xpath("//i[@class='chevron fa fa-fw col-lg-1']"));
		searchpane.click();

		wait2.until(ExpectedConditions.elementToBeClickable(ItemNumberSearch));
		ItemNumberSearch.clear();
		ItemNumberSearch.sendKeys(itemnumber);
		SearchRequiredDWP.click();
		Actions a = new Actions(driver);

		wait2.until(ExpectedConditions.elementToBeClickable(OpenRecord));
		a.contextClick(OpenRecord).build().perform();
		multiCreateButton.click();
		searchMultiCreateItemNumber.sendKeys("*03*");

		submitButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		List<WebElement> rows = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='multiCreateSearchResults']/tbody/tr")));
		int rowCount = rows.size();
		System.out.println("Total number of rows: " + rowCount);
		for (WebElement multiCreateCheckbox : multiCreateCheckboxs) {
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait1.until(ExpectedConditions.elementToBeClickable(multiCreateCheckbox));
			multiCreateCheckbox.click();
			WebElement selectedDWPs = driver.findElement(By.id("sel1"));
			selectedDWPs.click();
			Select dropdown = new Select(selectedDWPs);
			dropdown.selectByIndex(2);
			System.out.println(dropdown.getFirstSelectedOption().getText());

		}
		createButton.click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		List<WebElement> rows1 = wait1.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='multiCreateResults']/tbody/tr")));
		int rowCount1 = rows1.size();
		System.out.println("Total number of rows: " + rowCount1);
		
		WebElement copyNumber = driver.findElement(By.xpath(
				"(//td[translate(normalize-space(), '0123456789', '0000000000') = '00000000'])[4]"));
		String itemNumber = copyNumber.getText();
		WebElement closeButton = driver.findElement(By.xpath("//button[@title='Close']"));
		closeButton.click();
		searchpane.click();
		ItemNumberSearch.clear();
		ItemNumberSearch.sendKeys(itemNumber);
		SearchRequiredDWP.click();
		wait2.until(ExpectedConditions.elementToBeClickable(OpenRecord));
		OpenRecord.click();
		Select targetDropdown = new Select(AllcpVisible);
		WebElement selectedOption1 = targetDropdown.getFirstSelectedOption();
		String targetselectedOption = selectedOption1.getText();
		System.out.println("Selected Text: " + targetselectedOption);
		if (baseselectedOption.equals(targetselectedOption)) {
			System.out.println("Values in the base record and target record are the same: " + baseselectedOption);
		} else {
			System.out.println("Values in the base record and target record are different.");
			System.out.println("Base Record Value: " + baseselectedOption);
			System.out.println("Target Record Value: " + targetselectedOption);
		}
		}
	}

	
	public void mulitUpdateSearch(String itemnumber)
	{
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
		WebElement submitSuccessMessage = wait2.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'DWP submitted successfully')]")));
		;
		String successmessage = submitSuccessMessage.getText();
		System.out.println("Success:" + successmessage);
		submitOkButton.click();
		WebElement searchpane = driver.findElement(By.xpath("//i[@class='chevron fa fa-fw col-lg-1']"));
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
		searchpane.click();
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


	

