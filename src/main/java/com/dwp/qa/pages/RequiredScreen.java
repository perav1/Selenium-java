package com.dwp.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

import java.awt.Window;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.bouncycastle.util.Selector;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;

public class RequiredScreen {
	public WebDriver driver;
	private SearchResults searchResults1;

	public RequiredScreen(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		searchResults1 = new SearchResults(driver);
	}

	@FindBy(css = "a[href='/Required/Required']")
	WebElement Screen;

	@FindBy(id = "itemNameReqSearch")
	WebElement TName;
	@FindBy(id = "populateItemNumberReq")
	WebElement Search;

	@FindBy(xpath = "//li[@id='notificationBadgeContainer']//a[@href='#']")
	WebElement Notification;
	@FindBy(xpath = "//div[@id='MSG1002']")
	WebElement Message;
	@FindBy(id = "itemNumberReqSearch")
	WebElement ItemNumberField;
	@FindBy(id = "itemNumberReqSearch")
	WebElement ItemNumberSearch;
	@FindBy(id = "searchRequiredDWP")
	WebElement SearchRequiredDWP;
	@FindBy(id = "reqSearchLoadInfo")
	List<WebElement> searchResults;
	@FindBy(xpath = "//button[@id='showItemSearchDialog']//span[@class='fa fa-book fa-fw']")
	WebElement ItemSearchDialog;
	@FindBy(id = "itemNamePattern")
	WebElement ItemNameSearch;
	@FindBy(id = "fuzzyitem")
	WebElement radioSearchitem;
	@FindBy(id = "searchItemName")
	WebElement searchitemname;
	@FindBy(id = "addItemNumber")
	WebElement Additemnumber;
	@FindBy(xpath = "//table[@id='requiredSearchResults']/tbody/tr[1]")
	WebElement OpenRecord;
	@FindBy(id = "productResponsibleUnitReqSearch")
	WebElement productResponsibleUnitReqSearch;
	@FindBy(id = "hfbReqSearch")
	WebElement HFBSearch;
	@FindBy(id = "paNumberReqSearch")
	WebElement paNumberSearch;
	@FindBy(xpath = "//button[@id='showProductAreaDialog']//span[@class='fa fa-book fa-fw']")
	WebElement showProductArea;
	@FindBy(id = "productAreaNumberPattern")
	WebElement PANumber;
	@FindBy(id = "productAreaNamePattern")
	WebElement PAName;
	@FindBy(id = "searchPAName")
	WebElement searchPAnumber;
	@FindBy(name = "ProductArea")
	WebElement productAreaName;
	@FindBy(id = "issuerReqSearch")
	WebElement issuerReqSearch;
	@FindBy(id = "clearAll")
	WebElement clearAllSearch;
	@FindBy(xpath = "//input[@id='dwpStatusCreatedReqSearch' and @value='false']")
	WebElement draftStatus;

	@FindBy(xpath = "//input[@id='dwpStatusExpiredReqSearch' and @value='true']")
	WebElement expiredStatus;
	@FindBy(xpath = "//input[@id='dwpStatusPreliminaryReqSearch' and @value='false']")
	WebElement preliminaryStatus;
	@FindBy(xpath = "//input[@id='dwpStatusCompletedReqSearch' and @value='false']")
	WebElement submittedStatus;
	@FindBy(xpath = "//div[@class='panel-body']")
	WebElement Message1;
	@FindBy(id = "packagingRequirementNumberReqSearch")
	WebElement packagingRequirementNReqSearch;
	@FindBy(id = "packagingRequirementVersionReqSearch")
	WebElement packagingRequirementVReqSearch;
	@FindBy(id = "packagingSolutionPSMIDReqSearch")
	WebElement packagingSolutionPSMIDReqSearch;

	public void RequiredScreenLogin() {

		Screen.click();
		/*
		 * driver.switchTo().newWindow(WindowType.TAB); Set<String>
		 * windows=driver.getWindowHandles(); java.util.Iterator<String>
		 * it=windows.iterator(); String parentid=it.next(); String childid=it.next();
		 * driver.switchTo().window(childid);
		 * driver.get("https://cfnew.www.supplychain-dwp.ikeadt.com/Required/Required");
		 */

	}

	public void ItemName(String name) {
		try {

			TName.clear();
			TName.sendKeys(name);
			Search.click();

			if (name.equals("BÄSTIS hook beige")) {

				SearchRequiredDWP.click();
				OpenRecord.click();
			} else if (name.equals("12")) {
				Notification.click();
				String validationMessage = Message.getText();
				System.out.println("Validation Message: " + validationMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int searchWithItemNumber(String itemnumber) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(By.id("itemNumberReqSearch")));
			ItemNumberSearch.clear();

			ItemNumberSearch.sendKeys(itemnumber);
			SearchRequiredDWP.click();
			OpenRecord.click();

			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("requiredSearchResults")));
			return searchResults1.getItemTotalRecords();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int searchItemNumberBook(String itemname) {
		try {
			ItemNumberSearch.sendKeys("");
			if (ItemNumberSearch.getAttribute("value").contains("40494491")) {
				ItemSearchDialog.click();
				ItemNameSearch.sendKeys(itemname);
				radioSearchitem.click();
				radioSearchitem.isSelected();
				searchitemname.click();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loadingContent")));
				List<WebElement> checkboxs = driver
						.findElements(By.xpath("(//input[@type='checkbox'])[8] | (//input[@type='checkbox'])[9]"));
				WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait1.until(ExpectedConditions.visibilityOfAllElements(checkboxs));
				// Iterate through the list and click each checkbox
				for (WebElement checkbox : checkboxs) {
					checkbox.click();
				}
				WebElement replaceItemNumber = driver.findElement(By.id("replaceItemNumber"));

				wait.until(ExpectedConditions.visibilityOfAllElements(replaceItemNumber));
				replaceItemNumber.click();
				SearchRequiredDWP.click();
				OpenRecord.click();
			}

			else if (ItemNumberSearch.getAttribute("value").contains("")) {
				ItemSearchDialog.click();
				ItemNameSearch.sendKeys(itemname);
				radioSearchitem.click();
				radioSearchitem.isSelected();
				searchitemname.click();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loadingContent")));
				List<WebElement> checkboxs = driver
						.findElements(By.xpath("(//input[@type='checkbox'])[8] | (//input[@type='checkbox'])[9]"));
				WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait1.until(ExpectedConditions.visibilityOfAllElements(checkboxs));
				// Iterate through the list and click each checkbox
				for (WebElement checkbox : checkboxs) {
					checkbox.click();
				}

				Additemnumber.click();
				SearchRequiredDWP.click();

				OpenRecord.click();
			}
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("requiredSearchResults")));
			return searchResults1.getItemTotalRecords();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}

	public void productResponsibleUnit() {
		try {
			productResponsibleUnitReqSearch.click();
			Select dropdown = new Select(productResponsibleUnitReqSearch);
			dropdown.selectByIndex(1);
			System.out.println(dropdown.getFirstSelectedOption().getText());
			SearchRequiredDWP.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(By.id("requiredSearchResults")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,2000)");
			OpenRecord.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void homeFurnishingBusiness() {
		try {
			HFBSearch.click();
			Select dropdown1 = new Select(HFBSearch);
			dropdown1.selectByIndex(3);
			System.out.println(dropdown1.getFirstSelectedOption().getText());
			SearchRequiredDWP.click();
			OpenRecord.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void productAreaNumber(String paNumber, String itemnumber) {
		try {
			ItemNumberSearch.sendKeys(itemnumber);
			paNumberSearch.sendKeys(paNumber);
			SearchRequiredDWP.click();
			OpenRecord.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void productAreaDialogSearch(String paNumber, String paName) {
		try {

			paNumberSearch.sendKeys("");
			if (paNumberSearch.getAttribute("value").contains("1031")) {
				showProductArea.click();
				PANumber.sendKeys(paNumber);
				searchPAnumber.click();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement searchPANameElement = wait
						.until(ExpectedConditions.elementToBeClickable(By.id("productAreaName")));
				searchPANameElement.click();
				PAName.sendKeys(paName);
				// Copying PAname form PA numbers and click on exact search
				// String paName1 = copyPAName.getText();
				// PAName.sendKeys(paName1);
				// WebElement exactPA=driver.findElement(By.id("exactPA"));
				// exactPA.click();
				searchPAnumber.click();
				List<WebElement> selectedSearchResults = driver
						.findElements(By.xpath("(//input[@type='checkbox'])[5]|(//input[@type='checkbox'])[6]"));
				WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait1.until(ExpectedConditions.visibilityOfAllElements(selectedSearchResults));
				for (WebElement selectedSearchResult : selectedSearchResults) {
					selectedSearchResult.click();
				}
				WebElement ReplacedElements = driver.findElement(By.id("replaceProductAreaNumber"));
				ReplacedElements.click();
				SearchRequiredDWP.click();
				OpenRecord.click();
			}

			else if (paNumberSearch.getAttribute("value").contains("")) {
				showProductArea.click();
				PANumber.sendKeys(paNumber);
				searchPAnumber.click();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement searchPANameElement = wait
						.until(ExpectedConditions.elementToBeClickable(By.id("productAreaName")));
				searchPANameElement.click();
				PAName.sendKeys(paName);
				searchPAnumber.click();
				List<WebElement> selectedSearchResults = driver
						.findElements(By.xpath("(//input[@type='checkbox'])[9]|(//input[@type='checkbox'])[10]"));
				WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait1.until(ExpectedConditions.visibilityOfAllElements(selectedSearchResults));
				for (WebElement selectedSearchResult : selectedSearchResults) {
					selectedSearchResult.click();
				}
				WebElement addSelection = driver.findElement(By.id("addProductAreaNumber"));
				addSelection.click();
				SearchRequiredDWP.click();

				OpenRecord.click();
				/*
				 * JavascriptExecutor js= (JavascriptExecutor)driver;
				 * js.executeScript("window.scrollBy(0,500)");
				 * js.executeScript("document.QuerySelector(.content).scrollBottom=5000");
				 */

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void issuerSearch(String issuerId) {
		issuerReqSearch.sendKeys(issuerId);

		OpenRecord.click();
	}

	public void clearResults(String paNumber, String itemnumber) {
		ItemNumberSearch.sendKeys(itemnumber);
		paNumberSearch.sendKeys(paNumber);
		clearAllSearch.click();
	}

	public void dwpDraftStatusSearch(String itemnumber) {
		ItemNumberSearch.sendKeys(itemnumber);
		clickElementWithJS(driver, submittedStatus);
		clickElementWithJS(driver, preliminaryStatus);
		// draftStatus.click();
		// expiredStatus.click();
		SearchRequiredDWP.click();

		OpenRecord.click();

	}

	public void dwpPreliminarySearch(String itemnumber) {
		ItemNumberSearch.sendKeys(itemnumber);
		clickElementWithJS(driver, submittedStatus);
		clickElementWithJS(driver, draftStatus);
		SearchRequiredDWP.click();

		OpenRecord.click();
	}

	public void dwpSubmittedSearch(String itemnumber) {
		ItemNumberSearch.sendKeys(itemnumber);
		clickElementWithJS(driver, preliminaryStatus);
		clickElementWithJS(driver, draftStatus);
		SearchRequiredDWP.click();

		OpenRecord.click();
	}

	public void dwpExpiredSearch(String itemnumber) {
		ItemNumberSearch.sendKeys(itemnumber);
		clickElementWithJS(driver, preliminaryStatus);
		clickElementWithJS(driver, draftStatus);
		clickElementWithJS(driver, submittedStatus);
		clickElementWithJS(driver, expiredStatus);
		SearchRequiredDWP.click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfAllElements(OpenRecord));
		// OpenRecord.click();
		// Notification.click();
		// String validationMessage=Message1.getText();
		// System.out.println("Validation Message: " + validationMessage);

	}

	public static void clickElementWithJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void packagingRequirementReqSearch(String prNumber) {
		String[] parts = prNumber.split("-");
		if (parts.length != 3) {
			System.out.println(
					"Invalid format: Please provide the packaging requirement in the format 'AA-Number-Edition'.");
			return;
		}

		String number = parts[1];
		String edition = parts[2];

		// Paste the number part into the number text field
		packagingRequirementNReqSearch.sendKeys(number);

		// Paste the edition part into the edition text field
		packagingRequirementVReqSearch.sendKeys(edition);
		SearchRequiredDWP.click();
		OpenRecord.click();
	}

}
