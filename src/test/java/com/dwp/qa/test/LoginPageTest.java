package com.dwp.qa.test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dwp.qa.BaseTest.BaseClass;
import com.dwp.qa.pages.LoginPage;
import com.dwp.qa.pages.RequiredScreen;
import com.dwp.qa.pages.SearchBurgerMenu;
import com.dwp.qa.pages.SearchContextMenu;
import com.dwp.qa.pages.SearchResults;


public class LoginPageTest<object> extends BaseClass {

	private RequiredScreen screen;
	private SearchContextMenu scontextmenu;
	private SearchBurgerMenu sburgermenu;
	private SearchResults sresults;

	@BeforeMethod
	public void setUp() {
		screen = new RequiredScreen(driver);
		scontextmenu = new SearchContextMenu(driver);
		sburgermenu = new SearchBurgerMenu(driver);
	}

	@Test
	public void submit() {
		LoginPage page = LaunchAppication();
		page.LoginApplication("penagani.ravali@inter.ikea.com");
		page.loginDetails("ikeadt\\testdwp", "Testing8");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		RequiredScreen screen = new RequiredScreen(driver);
		screen.RequiredScreenLogin();

	}
	
	@Test(dataProvider="ItemNameTest")
	public void ItemNameSearch(String name) {

		screen.ItemName(name);
	}

	@DataProvider
	public Object[][] ItemNameTest() {
		return new Object[][] { { "12" }, { "BÄSTIS hook beige" } };
	}

	@Test
	public void itemNumberSearch() {

		int itemCount1 = screen.searchWithItemNumber("30460566");
		System.out.println("Number of search results for item number '30460566': " + itemCount1);
		Assert.assertNotEquals(itemCount1, 0, "No search results found for item number '30460566'");

		// int itemCount2 = screen.searchWithItemNumber("*03*");
		// System.out.println("Number of search results for wildcard '*03*': " +
		// itemCount2);
		// Assert.assertNotEquals(itemCount2, 0, "No search results found for wildcard
		// '*03*'");
	}

	@Test
	public void searchDialogBox() {

		int itemCount2 = screen.searchItemNumberBook("*g*");
		System.out.println("Number of search results for item number : " + itemCount2);
		Assert.assertNotEquals(itemCount2, 0, "No search results found for item number '*g*'");

	}

	@Test
	public void PRU() {

		screen.productResponsibleUnit();
	}

	@Test
	public void HFB() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		screen.homeFurnishingBusiness();
	}

	@Test
	public void productArea() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		screen.productAreaNumber("1031", "00018118");
	}

	@Test
	public void showProductAreaDialog() {

		// Search with PA number and PA name "*03*"
		screen.productAreaDialogSearch("*03*", "*h*");
		// Copy the PAName form PA number search results
		// screen.productAreaDialogSearch("*03*");

	}

	@Test
	public void reqIssuerSearch() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		screen.issuerSearch("testdwp");
	}

	@Test
	public void Clear() {

		screen.clearResults("1031", "00018118");
	}

	@Test
	public void contextMenu() {
		SearchContextMenu sbmenu = new SearchContextMenu(driver);
		sbmenu.openContextMenu("30460566");
	}

	@Test
	public void draftStatus() {

		screen.dwpDraftStatusSearch("*03*");
	}

	@Test
	public void preliminaryStatus() {

		screen.dwpPreliminarySearch("*03*");
	}

	@Test
	public void submittedStatus() {

		screen.dwpSubmittedSearch("*01*");
	}

	@Test
	public void expiredStatus() {

		screen.dwpExpiredSearch("*01*");
	}

	@Test
	public void packagingRequireement() {

		screen.packagingRequirementReqSearch("AA-2351559-4");
	}

	@Test
	public void viewMode() {

		scontextmenu.openViewMode("30460566");
	}

	@Test
	public void copyNewDWP() {

		scontextmenu.openCopyNewDWP("60158771", "Centrally fulfilled");
	}

	@Test
	public void expiredButtonSearch() {

		scontextmenu.expiredContextMenuSearch("40494491");
	}

	@Test
	public void deleteButtonSearch() {

		scontextmenu.deleteContextMenuSearch("60139834");
	}

	@Test
	public void showActualDWPSearch() {

		scontextmenu.showActualDWPContextMenu("30460566");
	}

	@Test
	public void multiCreate() {

		scontextmenu.multiCreateSerach("30460566");
	}

	@Test
	public void multiUpdate() {
		scontextmenu.mulitUpdateSearch("30460566");
	}

	@Test
	public void newBlankSearch() {

		sburgermenu.openNewBlankDWP("90101957", "Store fulfilled");
	}

	@Test
	public void findChangeRequest() {
		sburgermenu.searchWithCRid("*01*", "215630001");

		// sburgermenu.searchWithItemNo("*02*","70563015");

	}

	
}
