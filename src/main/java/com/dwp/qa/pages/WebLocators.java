package com.dwp.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebLocators {
	public WebLocators(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	WebElement Useremail;

	@FindBy(name = "action")
	WebElement submit;
	@FindBy(id = "userNameInput")
	WebElement userName;
	@FindBy(id = "passwordInput")
	WebElement Password;
	@FindBy(id = "submitButton")
	WebElement signIn;
	@FindBy(id = "error-element-username")
	WebElement errorEmail;
	@FindBy(id="errorText")
	WebElement errorTextuser;
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
	@FindBy(xpath = "//button[normalize-space()='OK']")
	WebElement warningOk;
	@FindBy(xpath = "//i[@class='chevron fa fa-fw col-lg-1']")
	WebElement searchPane;
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
	@FindBy(xpath = "//button[normalize-space()='Multi Update']")
	WebElement searchMultiUpdate;
	@FindBy(id = "txtSearchMultiUpdatePANumber")
	WebElement multiupdatePANumber;
	@FindBy(id = "btnMultiUpdateSearch")
	WebElement multiUpdateSearch;
	@FindBy(xpath = "(//input[@type='checkbox'])[18]|(//input[@type='checkbox'])[19]|(//input[@type='checkbox'])[20]")
	List<WebElement> multiUpdateCheckboxs;
	@FindBy(id = "btnMultiUpdateAll")
	WebElement updateAllAttributes;
	@FindBy(xpath = "//div[@id='MSG69']")
	WebElement Message2;
	@FindBy(xpath = "//div[@class='modal-content']")
	WebElement errorPOPUP;
	@FindBy(xpath = "//i[@class='fa fa-bell faa-ring fa-2x']")
	WebElement notification;
	@FindBy(id = "notificationBadgeCount")
	List<WebElement> badgeCont;
	@FindBy(css = "tbody tr:nth-child(1) td:nth-child(1) input:nth-child(1)")
	WebElement selectedSearchResults;
	@FindBy(xpath = "//i[@class='fa fa-th-list']")
	WebElement searchBurgerMenu;
	@FindBy(id = "ddlSaleSolutionIndicationInfoEdit")
	WebElement saleSolution;
	@FindBy(id = "cpPackagingMaterialInfoEdit1")
	WebElement cpPackagingMaterial;
	@FindBy(id = "cpFragileInfoEdit1")
	WebElement cpFragile;
	@FindBy(id = "cpCavityInfoEdit1")
	WebElement cpCavity;
	@FindBy(id = "cpDustProtectionNeededInfoEdit1")
	WebElement cpDustProtection;
	@FindBy(id = "cpServicePackagingInfoEdit1")
	WebElement cpServicePackaging;

	@FindBy(id = "ddlStoreFacingWidInfoEditCP1")
	WebElement storeFacingWidth;
	@FindBy(id = "ddlStoreFacingHeiInfoEditCP1")
	WebElement storeFacingHeight;
	@FindBy(id = "cpGrossWeightInfoEdit1")
	WebElement cpGrossWeight;
	@FindBy(id = "ulQtyInfoEdit")
	WebElement ulQty;
	@FindBy(id = "mpQtyInfoEdit")
	WebElement mpQty;
	@FindBy(id = "ddlMPSalesSolutionIndicationInfoEdit")
	WebElement mpSalesSolutionIndication;
	@FindBy(id = "ddlMPSuitableForSideLengthFillingInfoEdit")
	WebElement mpSuitableForSideLength;
	@FindBy(id = "mpLenInfoEdit")
	WebElement mpLength;
	@FindBy(id = "mpWidInfoEdit")
	WebElement mpWidth;
	@FindBy(id = "mpHeiInfoEdit")
	WebElement mpHeight;
	@FindBy(id = "pmpReqAdd")
	WebElement partAdd;
	@FindBy(xpath = "//div[@data-target='#multiPack']")
	WebElement mpPanelHeading;
	@FindBy(id = "reqPartIDInfoEdit")
	WebElement partId;
	@FindBy(id = "reqPartNameInfoEdit")
	WebElement partName;
	@FindBy(id = "reqPartQtyInfoEdit")
	WebElement partQty;
	@FindBy(id = "reqPartWgtInfoEdit")
	WebElement partWeight;
	@FindBy(id = "btnNext1")
	WebElement nextButton;
	@FindBy(id = "reqPMMatInfoPMType")
	WebElement packagingMaterial;
	@FindBy(id = "reqPMMatRecycledMaterialShare")
	WebElement recycleMaterialShare;
	@FindBy(xpath = "//button[@id='reqPMNextMatInfoBtn']")
	WebElement materialNextButton;
	@FindBy(xpath = "//button[normalize-space()='OK']")
	WebElement clickOk;
	@FindBy(id = "ulStakingIndicationInfoEdit")
	WebElement stakingIndication;
	@FindBy(id = "ulSutableforTopFillInfoEdit")
	WebElement sutableTopFilling;
	@FindBy(id = "ulSalesolutionindicationInfoEdit")
	WebElement ulSaleSolution;
	@FindBy(id = "ulFireclassInfoEdit")
	WebElement ulFireClass;
	@FindBy(id = "ulLengthInfoEdit")
	WebElement ulLength;
	@FindBy(id = "ulWidthInfoEdit")
	WebElement ulWidth;
	@FindBy(id = "ulHeightInfoEdit")
	WebElement ulHeight;
	@FindBy(id = "ulStoreFacingInfoEditWid1")
	WebElement ulstoreFacing;
	@FindBy(id = "unitLoadCategory")
	WebElement unitLoadCategory;
	@FindBy(id = "saveRequiredDWP")
	WebElement saveRequiredDWP;
	@FindBy(xpath = "//div[contains(text(), 'DWP saved successfully')]")
	WebElement successSave;
	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[7]")
	WebElement getStatus;
	@FindBy(css = "button[class='btn pull-left ok-btn btn-warning']")
	WebElement warningOk1;
	@FindBy(id = "packagingRequirementInfoEdit")
	WebElement packagingRequirement;
	@FindBy(id = "findChangeRequestReqDWP")
	WebElement findChangeRequest;
	@FindBy(id = "searchValue")
	WebElement searchwithCR;
	@FindBy(id = "searchChangeRequestBtn")
	WebElement searchChangeRequest;
	@FindBy(xpath = "//input[@id='changeRequestSearchType' and @value='Smart']")
	WebElement smartChangeRequest;
	@FindBy(xpath = "//input[@id='changeRequestSearchType' and @value='Exact']")
	WebElement exactChangeRequest;
	@FindBy(xpath = "//table[@id='tblFindCRResult']/tbody/tr ")
	List<WebElement> findCRResult;
	@FindBy(xpath = "//input[@id='changeRequestSearchBy' and @value='CrId']")
	WebElement chenageRequestCrId;
	@FindBy(xpath = "//input[@id='changeRequestSearchBy' and @value='ItemNo']")
	WebElement changeRequestItem;
	@FindBy(id = "reqSpecifyUpdateReasonInfoEdit")
	WebElement reqSpecifyUpdateReason;
	@FindBy(id = "btnProceedSubmitUpdateReason")
	WebElement proceesSubmitUpdateReason;
	@FindBy(xpath = "//div[@class='modal-body']")
	WebElement errorMessage1;

	@FindBy(xpath = "//div[@class='modal-content']")
	WebElement deviationReportPOPUP;
	@FindBy(xpath = "//div[@class='modal-body']")
	WebElement deviationReportmessage;
	@FindBy(xpath = "//button[normalize-space()='OK']")
	WebElement okDeviation;

	@FindBy(xpath = "//div[@id='MSG348']")
	WebElement successValidation;
	@FindBy(xpath = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front ui-draggable ui-resizable']")
	WebElement updateReasonspopUP;

	@FindBy(xpath = "//div[@class='modal-content']")
	WebElement changeRequestPOPUP;
	@FindBy(xpath = "//button[normalize-space()='OK']")
	WebElement changeOKButton;
	@FindBy(xpath = "//div[@class='modal-body']")
	WebElement changeRequestMesssage;

}
