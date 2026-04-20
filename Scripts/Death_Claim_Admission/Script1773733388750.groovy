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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil


import methods.FetchExcelData
import methods.CaptureScreenshot as SS

Map data = FetchExcelData.getData("Death", TestCaseID)

WebUI.waitForElementClickable(findTestObject('Object Repository/Death Claim Admission/ClaimsTab'), GlobalVariable.G_PageTimeout)

WebUI.enhancedClick(findTestObject('Object Repository/Death Claim Admission/ClaimsTab'))

WebUI.scrollToElement(findTestObject('Object Repository/Death Claim Admission/AdmissionScreen'), 2)

WebUI.enhancedClick(findTestObject('Object Repository/Death Claim Admission/AdmissionScreen'))

WebUI.setText(findTestObject('Object Repository/Death Claim Admission/Input-PolicyNumber'), data['PolicyNumber'])

WebUI.enhancedClick(findTestObject('Object Repository/Death Claim Admission/GoBtn'))

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.enhancedClick(findTestObject('Object Repository/Death Claim Admission/PrimaryInformationTab'))

String todayDate = new Date().format("dd/MM/yyyy")

WebUI.setText(findTestObject('Object Repository/Death Claim Admission/AdmittedDate'), todayDate)

SS.capture("Death_Claim_Admission")

//selects reason for repudiation
//WebUI.selectOptionByLabel(findTestObject('Object Repository/Death Claim Admission/RepudiateReason'), 'Pre Health Problems', false)

if(data['DeathCause'].toString().contains('Accident')) {
	
	if(WebUI.waitForElementPresent(findTestObject('Object Repository/Death Claim Admission/AccidentRiderChkbx'), 3)) {
		WebUI.enhancedClick(findTestObject('Object Repository/Death Claim Admission/AccidentRiderChkbx'))
		
		WebUI.scrollToElement(findTestObject('Object Repository/Death Claim Admission/AccidentRiderChkbx'), 2)
		SS.capture("AB_Rider_details")
	}
	
	if(WebUI.waitForElementPresent(findTestObject('Object Repository/Death Claim Admission/FIBRiderChkbx'), 3)) {
		WebUI.enhancedClick(findTestObject('Object Repository/Death Claim Admission/FIBRiderChkbx'))
		
		WebUI.scrollToElement(findTestObject('Object Repository/Death Claim Admission/FIBRiderChkbx'), 2)
		SS.capture("FIB_Rider_details")
	}
	
}
	

if(WebUI.waitForElementPresent(findTestObject('Object Repository/Death Claim Admission/EICRiderChkbx'), 2)) {
	
	WebUI.enhancedClick(findTestObject('Object Repository/Death Claim Admission/EICRiderChkbx'))
	
	WebUI.scrollToElement(findTestObject('Object Repository/Death Claim Admission/EICRiderChkbx'), 2)
	
	SS.capture("EIC_Rider_details")
}
if(WebUI.waitForElementPresent(findTestObject('Object Repository/Death Claim Admission/StepUPRiderChkbx'), 2)) {
	
	WebUI.enhancedClick(findTestObject('Object Repository/Death Claim Admission/StepUPRiderChkbx'))
	
	WebUI.scrollToElement(findTestObject('Object Repository/Death Claim Admission/StepUPRiderChkbx'), 2)
	
	SS.capture("StepUP_Rider_details")
}

SS.capture("Rider_details")

WebUI.setText(findTestObject('Object Repository/Death Claim Admission/ClaimProcessorNote'), 'Ok')

if(data['Admit_Decision'].toString().equalsIgnoreCase('Admit')) {

	WebUI.enhancedClick(findTestObject('Object Repository/Death Claim Admission/AdmitBtn'))

}

else {
	WebUI.selectOptionByLabel(findTestObject('Object Repository/Death Claim Admission/RepudiateReason'), 'Pre Health Problems', false)
	
	WebUI.enhancedClick(findTestObject('Object Repository/Death Claim Admission/RepudiateBtn'))
	
	WebUI.acceptAlert()
	
//	KeywordUtil.mark
}

WebUI.enhancedClick(findTestObject('Object Repository/Death Claim Admission/CloseBtn'))
