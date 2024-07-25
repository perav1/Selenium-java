package com.dwp.qa.pages;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResults {
	public WebDriver driver;

	public SearchResults(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = ("//table[@id='tblFindCRResult']/tbody/tr"))
	List<WebElement> fcTotalRecords;
	@FindBy(xpath = ("//table[@id='requiredSearchResults']/tbody/tr"))
	List<WebElement> itemTotalRecords;

	public int getFCTotalRecords() {
		int totalRecords = fcTotalRecords.size();
		System.out.println("Records shown: " + totalRecords + " of total " + totalRecords);
		return totalRecords;
	}

	public int getItemTotalRecords() {
		try {

			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("requiredSearchResults")));

			if (itemTotalRecords == null) {
				throw new IllegalStateException("itemTotalRecords element is not initialized.");
			}

			int totalRecords = itemTotalRecords.size();
			System.out.println("Records shown: " + totalRecords + " of total " + totalRecords);

			return totalRecords;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public boolean isElementVisible(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void selectDropdownOption(WebElement dropdown, int index) {
		Select select = new Select(dropdown);
		select.selectByIndex(index);
	}

}
