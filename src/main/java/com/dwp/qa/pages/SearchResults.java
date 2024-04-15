package com.dwp.qa.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResults {
	public WebDriver driver;
	public SearchResults(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath=("//table[@id='tblFindCRResult']/tbody/tr"))
	List<WebElement> fcTotalRecords;
	@FindBy(xpath=("//table[@id='requiredSearchResults']/tbody/tr"))
	List<WebElement> itemTotalRecords;
	
	public int getFCTotalRecords() {
		int totalRecords= fcTotalRecords.size();
        System.out.println("Records shown: " + totalRecords + " of total " + totalRecords);
        return totalRecords;
}
	public int getItemTotalRecords()
	{
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("requiredSearchResults")));
		int totalRecords= itemTotalRecords.size();
        System.out.println("Records shown: " + totalRecords + " of total " + totalRecords);
        return totalRecords;
	}
	
}
