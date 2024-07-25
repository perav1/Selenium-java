package com.dwp.qa.pages;

import java.time.Duration;
import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultiCreate extends SearchContextMenu
{
	private SearchResults searchResults1;
public MultiCreate(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
		searchResults1=new SearchResults(driver);
	}
@FindBy(css = "a[tabindex='13']")
WebElement clickableLink;

public void multiCreateSearch(String itemnumber) {
	 JSONObject outputJson = new JSONObject();
	ItemNumberSearch.sendKeys(itemnumber);
	SearchRequiredDWP.click();
	OpenRecord.click();

	AllcpVisible.click();
	Select basedropdown = new Select(AllcpVisible);
	WebElement initialOption = basedropdown.getFirstSelectedOption();
	basedropdown.selectByIndex(1);
	WebElement selectedOption = basedropdown.getFirstSelectedOption();
	if (initialOption.getText().equals(selectedOption.getText())) {
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
	String baseselectedOption = selectedOption.getText();
	
	System.out.println("Selected Text: " + baseselectedOption);
	WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
	detailBurgerMenu.click();
	submitReqDWP.click();
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
	multiCreateButton.click();
	searchMultiCreateItemNumber.sendKeys("*03*");

	submitButton.click();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	List<WebElement> rows = wait.until(ExpectedConditions
			.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='multiCreateSearchResults']/tbody/tr")));
	int rowCount = rows.size();
	System.out.println("Total number of rows: " + rowCount);
	
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loadingContent")));
	for (WebElement multiCreateCheckbox : multiCreateCheckboxs) {
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait1.until(ExpectedConditions.elementToBeClickable(multiCreateCheckbox));
		multiCreateCheckbox.click();
		WebElement selectedDWPs = driver.findElement(By.id("sel1"));
		selectedDWPs.click();
		Select dropdown = new Select(selectedDWPs);
		dropdown.selectByIndex(1);
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
	WebElement searchpane1 = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='chevron fa fa-fw col-lg-1']")));
	searchpane1.click();
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



}
