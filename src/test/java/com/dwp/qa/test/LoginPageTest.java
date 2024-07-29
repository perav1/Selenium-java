
package com.dwp.qa.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dwp.qa.BaseTest.BaseClass;
import com.dwp.qa.pages.DetailPane;
import com.dwp.qa.pages.LoginPage;
import com.dwp.qa.pages.MultiCreate;
import com.dwp.qa.pages.MultiUpdate;
import com.dwp.qa.pages.RequiredScreen;
import com.dwp.qa.pages.SearchBurgerMenu;
import com.dwp.qa.pages.SearchContextMenu;
import com.dwp.qa.pages.SearchResults;
import com.dwp.qa.util.ExcelDataDriven;


public class LoginPageTest<object> extends BaseClass {

	
	private RequiredScreen screen;
	private SearchContextMenu scontextmenu;
	private SearchBurgerMenu sburgermenu;
	private SearchResults sresults;
	public DetailPane detailresult;
	private MultiCreate create;
	private MultiUpdate update;
	private LoginPage page;
	
	DataFormatter formatter=new DataFormatter();

	@BeforeMethod
	public void setUp() throws IOException {
		
		screen = new RequiredScreen(driver);
		scontextmenu = new SearchContextMenu(driver);
		sburgermenu = new SearchBurgerMenu(driver);
		detailresult=new DetailPane(driver);
		create=new MultiCreate(driver);
		update=new MultiUpdate(driver);
		page = new LoginPage(driver, prop);
		
		
		}
	

	@Test
	public void submit() throws InterruptedException, IOException {
		
		LoginPage page = launchApplication();
		
		page.LoginApplication("email");
		//Thread.sleep(2000);
        page.loginDetails("username", "password");
		
	

	}
	@Test
	public void requiredLoginPage() throws InterruptedException, IOException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 Thread.sleep(2000);
		screen.RequiredScreenLogin();
	}
	
	@Test(dataProvider="itemNameTest")
	public void itemNameSearch(String name) {

		screen.ItemName(name);
	}

	@DataProvider
	public Object[][] itemNameTest() {
		return new Object[][] { { "12" }, { "BÄSTIS hook beige" } };
	}

	@Test(dataProvider="driverTest",dataProviderClass = ExcelDataDriven.class)
	public void itemNumberSearch(String itemnumber) {
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    int itemCount1 = screen.searchWithItemNumber(itemnumber); // Pass the actual itemNumber variable
	    System.out.println("Number of search results for item number 'itemnumber': " + itemCount1);
		Assert.assertNotEquals(itemCount1, 0, "No search results found for item number 'itemnumber'");
	

		// int itemCount2 = screen.searchWithItemNumber("*03*");
		// System.out.println("Number of search results for wildcard '*03*': " +
		// itemCount2);
		// Assert.assertNotEquals(itemCount2, 0, "No search results found for wildcard
		// '*03*'");
	}

	@Test
	public void searchDialogBox() {

		int itemCount2 = screen.searchItemNumberBook("*g*");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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

	@Test(dataProvider="productData",dataProviderClass = ExcelDataDriven.class)
	public void productArea(String itemnumber, String paNumber) {
                    
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 screen.productAreaNumber(paNumber, itemnumber);
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

	@Test(dataProvider="copyData",dataProviderClass = ExcelDataDriven.class)
	public void copyNewDWP(String itemnumber,String requirement) throws InterruptedException, IOException {

		scontextmenu.openCopyNewDWP(itemnumber, requirement);
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

	@Test(dataProvider="driverTest",dataProviderClass = ExcelDataDriven.class)
	public void multiCreate(String itemnumber) throws InterruptedException, IOException {
		
		create.multiCreateSearch(itemnumber);
	}

	@Test(dataProvider="driverTest",dataProviderClass = ExcelDataDriven.class)
	public void multiUpdate(String itemnumber) {
		update.multiUpdateSearch(itemnumber);
	}

	@Test(dataProvider="newData",dataProviderClass = ExcelDataDriven.class)
	public void newBlankSearch(String itemnumber,String requirement) {

		sburgermenu.openNewBlankDWP(itemnumber, requirement);
	}

	@Test
	public void findChangeRequest() {
		sburgermenu.searchWithCRid("*01*", "215630001");

		// sburgermenu.searchWithItemNo("*02*","70563015");

	}

     
     
     @Test(dependsOnMethods= {"submit","requiredLoginPage"})
     public void checkExistingRecord()
     {
    	 detailresult.checkRecord("30460566","Centrally fulfilled");//30460566,00125260
     }
	}
	

