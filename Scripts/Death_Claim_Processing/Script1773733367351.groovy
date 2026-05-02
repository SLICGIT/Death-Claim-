import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import methods.FetchExcelData
import methods.CaptureScreenshot as SS


Map data = FetchExcelData.getData("Death", TestCaseID)

WebUI.callTestCase(findTestCase('Test Cases/Login_Page_Shrilife'), [('UserID') : 'S08053'])

WebUI.waitForElementClickable(findTestObject('Object Repository/Death Claim Processing/ClaimsTab'), GlobalVariable.G_PageTimeout)

WebUI.enhancedClick(findTestObject('Object Repository/Death Claim Processing/ClaimsTab'))

WebUI.scrollToElement(findTestObject('Object Repository/Death Claim Processing/DeathProcessingScreen'), 2)

WebUI.enhancedClick(findTestObject('Object Repository/Death Claim Processing/DeathProcessingScreen'))

WebUI.enhancedClick(findTestObject('Object Repository/Death Claim Processing/AddBtn'))

WebUI.setText(findTestObject('Object Repository/Death Claim Processing/Input_PolicyNumber'), data['PolicyNumber'])

WebUI.enhancedClick(findTestObject('Object Repository/Death Claim Processing/GoBtn'))

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.enhancedClick(findTestObject('Object Repository/Death Claim Processing/BasicDetailsTab'))

WebUI.delay(1)

SS.capture("Death_Processing_Screen")

String todayDate = new Date().format('dd/MM/yyyy')

WebUI.selectOptionByLabel(findTestObject('Object Repository/Death Claim Processing/DeathCertificateStatus'), 'Received', false)

WebUI.setText(findTestObject('Object Repository/Death Claim Processing/DeathCertificateDate'), todayDate)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Death Claim Processing/DischargeCertificateStatus'), 'Received', false)

WebUI.setText(findTestObject('Object Repository/Death Claim Processing/DischargeCertificateDate'), todayDate)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Death Claim Processing/OriginalPolicyStatus'), 'Received', false)

WebUI.setText(findTestObject('Object Repository/Death Claim Processing/OriginalPolicyDate'), todayDate)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Death Claim Processing/OriginalPolicyStatus'), 'Received', false)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Death Claim Processing/IdentityCertificateStatus'), 'Waived', false)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Death Claim Processing/EmployerCertificateStatus'), 'Waived', false)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Death Claim Processing/LastIllnessCertificateStatus'), 'Waived', false)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Death Claim Processing/InvestigationReportStatus'), 'Waived', false)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Death Claim Processing/CourtVerdictStatus'), 'Waived', false)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Death Claim Processing/TitleProofStatus'), 'Waived', false)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Death Claim Processing/ClaimFormAStatus'), 'Waived', false)

//WebUI.scrollToElement(findTestObject('Object Repository/Death Claim Processing/UnderwritingNotes'), 2)
//
//SS.capture("Processing_Screen_Rider_details")

WebUI.setText(findTestObject('Object Repository/Death Claim Processing/UnderwritingNotes'), 'Ok')

WebUI.scrollToElement(findTestObject('Object Repository/Death Claim Processing/PolicyRider'), 2)

SS.capture("Processing_Screen_Rider_details")

WebUI.setText(findTestObject('Object Repository/Death Claim Processing/ClaimProcessorNote'), 'Ok')

if(data['DeathCause'].toString().contains("Accident")) {
	
	WebUI.enhancedClick(findTestObject('Object Repository/Death Claim Processing/EditBtn'))
	
	WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)
	
	WebUI.enhancedClick(findTestObject('Object Repository/Death Claim Processing/ChangeDeathCauseTab'))
	
	WebUI.setText(findTestObject('Object Repository/Death Claim Processing/PlaceofAccident'), data['DeathPlace'])
	
}

WebUI.enhancedClick(findTestObject('Object Repository/Death Claim Processing/SaveBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Death Claim Processing/OkBtn-Save'), GlobalVariable.G_PageTimeout)

WebUI.enhancedClick(findTestObject('Object Repository/Death Claim Processing/OkBtn-Save'))

int parentFrame = WebUI.getWindowIndex()
WebUI.enhancedClick(findTestObject('Object Repository/Death Claim Processing/ViewBtn'))

WebUI.waitForPageLoad(5) // or use a wait for window count as in Option A
WebUI.switchToWindowIndex(parentFrame + 1)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Death Claim Processing/SearchByDropdown'), 'Policy No', false)

WebUI.setText(findTestObject('Object Repository/Death Claim Processing/Input-SearchKey'), data['PolicyNumber'])

WebUI.enhancedClick(findTestObject('Object Repository/Death Claim Processing/GoBtn-PolicySearch'))

WebUI.enhancedClick(findTestObject('Object Repository/Death Claim Processing/a_PolicyNumber', [('Policy_Number') : data['PolicyNumber']]))

WebUI.switchToWindowIndex(parentFrame)

//WebUI.enhancedClick(findTestObject('Object Repository/Death Claim Processing/BasicDetailsTab'))
WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.delay(1)

if(data['DeathCause'].toString().contains("Accident")) {
	
	WebUI.enhancedClick(findTestObject('Object Repository/Death Claim Processing/BasicDetailsTab'))
	
	WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)
	
	WebUI.delay(1)
	
}
 

if(WebUI.waitForElementVisible(findTestObject('Object Repository/Death Claim Processing/AccidentRiderSA'),3 , FailureHandling.OPTIONAL)) {

	GlobalVariable.G_AB_Rider_SA = WebUI.getAttribute(findTestObject('Object Repository/Death Claim Processing/AccidentRiderSA'), 'textContent').trim()

}
if(WebUI.waitForElementVisible(findTestObject('Object Repository/Death Claim Processing/FIB_Rider_SA'),3 , FailureHandling.OPTIONAL)) {
	
	GlobalVariable.G_FIB_Rider_SA = WebUI.getAttribute(findTestObject('Object Repository/Death Claim Processing/FIB_Rider_SA'), 'textContent').trim()

}
if(WebUI.waitForElementVisible(findTestObject('Object Repository/Death Claim Processing/EICRiderSA'),3 , FailureHandling.OPTIONAL)) {
	
		GlobalVariable.G_EIC_Rider_SA = WebUI.getAttribute(findTestObject('Object Repository/Death Claim Processing/EICRiderSA'), 'textContent').trim()
	
	}

if(WebUI.waitForElementVisible(findTestObject('Object Repository/Death Claim Processing/StepUPRiderSA'),3 , FailureHandling.OPTIONAL)) {
	
		GlobalVariable.G_STEPUP_Rider_SA = WebUI.getAttribute(findTestObject('Object Repository/Death Claim Processing/StepUPRiderSA'), 'textContent').trim()
	
	}

WebUI.waitForElementClickable(findTestObject('Object Repository/Death Claim Processing/ApproveBtn'), GlobalVariable.G_PageTimeout)

WebUI.enhancedClick(findTestObject('Object Repository/Death Claim Processing/ApproveBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Death Claim Processing/OkBtn-Save'), GlobalVariable.G_PageTimeout)

WebUI.enhancedClick(findTestObject('Object Repository/Death Claim Processing/OkBtn-Save'))

WebUI.enhancedClick(findTestObject('Object Repository/Death Claim Processing/CloseBtn'))
