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

WebUI.callTestCase(findTestCase('Test Cases/Claim_Portal/Login_Page'), [('UserID') : data['LvlOne_ManagerID']])

//**************************************Claims Tracker Screen :- LVL 1 Manager********************************************
WebUI.waitForElementVisible(findTestObject('Claim Intimation Shrilife/Page_Dashboard - SHRILIFE/Claim_option'), 10)

WebUI.mouseOver(findTestObject('Claim Intimation Shrilife/Page_Dashboard - SHRILIFE/Claim_option'))

WebUI.click(findTestObject('Claim Intimation Shrilife/Page_Dashboard - SHRILIFE/Claims_Tracker'))

WebUI.click(findTestObject('Claim Intimation Shrilife/Page_Dashboard - SHRILIFE/Search_Type'))

WebUI.setText(findTestObject('Claim Intimation Shrilife/Page_Dashboard - SHRILIFE/Proposal_no'), data['PolicyNumber'])

WebUI.delay(2)

WebUI.click(findTestObject('Claim Intimation Shrilife/Page_Dashboard - SHRILIFE/Update Button'))

WebUI.setText(findTestObject('Claim Intimation Shrilife/Page_Dashboard - SHRILIFE/Remark'), 'OK')

WebUI.click(findTestObject('Claim Intimation Shrilife/Page_Dashboard - SHRILIFE/Save button'))

WebUI.click(findTestObject('Claim Intimation Shrilife/Page_Dashboard - SHRILIFE/OK button'))

WebUI.delay(2)

//**************************************Claims Intimation Screen :- LVL 1 Manager********************************************

WebUI.mouseOver(findTestObject('Claim Intimation Shrilife/Page_Dashboard - SHRILIFE/Claim_option'))

WebUI.delay(1)

WebUI.mouseOver(findTestObject('Claim Intimation Shrilife/Page_Dashboard - SHRILIFE/Claim_Intimation'))

WebUI.click(findTestObject('Claim Intimation Shrilife/Page_Dashboard - SHRILIFE/a_Death Claim'))

WebUI.waitForElementVisible(findTestObject('Claim Intimation Shrilife/Page_Death Claims - SHRILIFE/Open Claims'), 10)

WebUI.click(findTestObject('Claim Intimation Shrilife/Page_Death Claims - SHRILIFE/Open Claims'))

WebUI.delay(2)

WebUI.waitForElementVisible(findTestObject('Claim Intimation Shrilife/Page_Death Claims - SHRILIFE/grid_table'), 15)

WebUI.delay(1)

WebUI.setText(findTestObject('Claim Intimation Shrilife/Page_Death Claims - SHRILIFE/input_policy_no'), data['PolicyNumber'])

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Claim Intimation Shrilife/Page_Death Claims - SHRILIFE/input_checkbox'))

WebUI.click(findTestObject('Object Repository/Claim Intimation Shrilife/Page_Death Claims - SHRILIFE/Manual allocation'))

//WebUI.click(findTestObject('Object Repository/Claim Intimation Shrilife/Page_Death Claims - SHRILIFE/Select user'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Claim Intimation Shrilife/Page_Death Claims - SHRILIFE/Select user'), data['RegUserID_Maker'], false)

WebUI.setText(findTestObject('Object Repository/Claim Intimation Shrilife/Page_Death Claims - SHRILIFE/Text_Remarks'), 'OK')

WebUI.click(findTestObject('Object Repository/Claim Intimation Shrilife/Page_Death Claims - SHRILIFE/button_Submit'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Claim Intimation Shrilife/Page_Death Claims - SHRILIFE/button_OK'), 10)

WebUI.click(findTestObject('Object Repository/Claim Intimation Shrilife/Page_Death Claims - SHRILIFE/button_OK'))

//**************************************Logout Function :- LVL 1 Manager********************************************

WebUI.callTestCase(findTestCase('Test Cases/Claim_Portal/Logout_Function'), null)

//**************************************Claims Registration :- User ID Maker********************************************

WebUI.callTestCase(findTestCase('Test Cases/Claim_Portal/Login_Page'), [('UserID') : data['RegUserID_Maker']])

WebUI.waitForElementVisible(findTestObject('Claim Portal/Claim Registration/Page_Dashboard - SHRILIFE/Claim_option'), 10)

WebUI.delay(1)

WebUI.mouseOver(findTestObject('Claim Portal/Claim Registration/Page_Dashboard - SHRILIFE/Claim_option'))

WebUI.delay(1)

WebUI.click(findTestObject('Claim Portal/Claim Registration/Page_Dashboard - SHRILIFE/Claim Registration'))

WebUI.waitForElementClickable(findTestObject('Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/Open Claims'), 10)

WebUI.delay(2)

WebUI.click(findTestObject('Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/Open Claims'))

WebUI.waitForElementClickable(findTestObject('Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/txt_policyNo'), 5)

WebUI.delay(4)

WebUI.setText(findTestObject('Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/txt_policyNo'), data['PolicyNumber'])

WebUI.delay(4)

WebUI.click(findTestObject('Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/Policy_No_details', [('policyNo') : data['PolicyNumber']]))

WebUI.click(findTestObject('Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/Registration Details'))

WebUI.click(findTestObject('Object Repository/Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/Request_Date'), FailureHandling.STOP_ON_FAILURE)

//WebUI.sendKeys(findTestObject('Object Repository/Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/Request_Date'), '12/12/2025 09:14 am')
WebUI.click(findTestObject('Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/button_Now'))

WebUI.click(findTestObject('Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/button_Done'))

WebUI.setText(findTestObject('Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/Death_Date'), data['DeathDate'])

WebUI.delay(2)

WebUI.enhancedClick(findTestObject('Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/Cause_of_Death'))

WebUI.delay(0.2)

WebUI.selectOptionByLabel(findTestObject('Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/Cause_of_Death'), data['DeathCause'], false)

if (data['DeathCause'].toString().contains('Accident')) {
 
	WebUI.setText(findTestObject('Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/Accident_Date'), data['AccidentDate'])
 
	WebUI.setText(findTestObject('Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/Accident_Place'), data['AccidentPlace'])
	
	}

WebUI.setText(findTestObject('Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/Death_Place'), data['DeathPlace'])

WebUI.setText(findTestObject('Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/Reported By'), data['ReporterName'])

//String todayDate = new Date().format("dd/MM/yyyy")

WebUI.setText(findTestObject('Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/Reported_Date'), data['ReportingDate'])

WebUI.enhancedClick(findTestObject('Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/Bank_Detaiis_status'))

WebUI.selectOptionByLabel(findTestObject('Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/Bank_Detaiis_status'), 'Yes', false)

//if (WebUI.waitForElementPresent(findTestObject('Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/Benefit Type'), ))
//
//	 {
//		 WebUI.click(findTestObject('Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/Benefit Type'))
//	 }
// Benefits type available for PAB Plan
// Benefits Type element is present in the DOM but it is not visible
TestObject benefitType = findTestObject('Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/Benefit Type')


if (WebUI.waitForElementVisible(benefitType, 4, FailureHandling.OPTIONAL)) {
   WebUI.waitForElementClickable(benefitType, 4, FailureHandling.OPTIONAL)

   WebUI.selectOptionByLabel(benefitType, data['BenefitType'],
	   false)
} else {
   WebUI.comment('\'Benefit Type\' did not become visible within 10s.')
}


// WebUI.click(findTestObject('Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/Benefit Type'))
WebUI.setText(findTestObject('Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/Phone_no'), data['MobileNo'])

WebUI.setText(findTestObject('Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/Mobile_no'), data['MobileNo'])

WebUI.setText(findTestObject('Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/Whatsapp_no'), data['MobileNo'])

SS.capture("Registration_Details")

WebUI.click(findTestObject('Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/Address_checkbox'))

WebUI.click(findTestObject('Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/Register Button'))

WebUI.waitForElementClickable(findTestObject('Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/Button_OK'), GlobalVariable.G_PageTimeout)

WebUI.delay(3)

WebUI.click(findTestObject('Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/Button_OK'))

//**************************************Logout Function :- User ID Maker********************************************

WebUI.callTestCase(findTestCase('Test Cases/Claim_Portal/Logout_Function'), null)

//Checking for assigned User

WebUI.callTestCase(findTestCase('Claim_Portal/User_Check'), [('TestCaseID') : TestCaseID], FailureHandling.STOP_ON_FAILURE)


//**************************************Claims Registration :- User ID Checker********************************************

WebUI.callTestCase(findTestCase('Test Cases/Claim_Portal/Login_Page'), [('UserID') : GlobalVariable.G_USER])

WebUI.waitForElementVisible(findTestObject('Claim Portal/Claim Registration/Page_Dashboard - SHRILIFE/Claim_option'), 10)

WebUI.mouseOver(findTestObject('Claim Portal/Claim Registration/Page_Dashboard - SHRILIFE/Claim_option'))

WebUI.delay(0.5)

WebUI.click(findTestObject('Claim Portal/Claim Approval/Claim_Dashboard Page/Claim Approval Option'))
WebUI.delay(2)


WebUI.click(findTestObject('Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/Open Claims'))

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.setText(findTestObject('Claim Portal/Claim Approval/Page_ClaimsApproval - SHRILIFE/txt_policyNo'), data['PolicyNumber'])

WebUI.delay(1)

////check for death user allocation
//policyd=findTestObject('Claim Approval/Page_ClaimsApproval - SHRILIFE/Policy _Details')
// 
//if (WebUI.waitForElementNotPresent(policyd, 5, FailureHandling.OPTIONAL)) {
////	WebUI.waitForElementNotClickable(policyd, 10, FailureHandling.OPTIONAL)
//	
//	WebUI.callTestCase(findTestCase('Test Cases/Claim_Portal/Logout_Function'), null)
//	
//	WebUI.callTestCase(findTestCase('Test Cases/Claim_Portal/Login_Page'), [('UserID') : data['Reg_DeathUserID']])
//	
//	WebUI.waitForElementVisible(findTestObject('Claim Portal/Claim Registration/Page_Dashboard - SHRILIFE/Claim_option'), 10)
//	
//	WebUI.mouseOver(findTestObject('Claim Portal/Claim Registration/Page_Dashboard - SHRILIFE/Claim_option'))
//	
//	WebUI.delay(0.5)
//	
//	WebUI.click(findTestObject('Claim Portal/Claim Approval/Claim_Dashboard Page/Claim Approval Option'))
//	
//	WebUI.click(findTestObject('Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/Open Claims'))
//	
//	WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)
//	
//	WebUI.setText(findTestObject('Claim Portal/Claim Approval/Page_ClaimsApproval - SHRILIFE/txt_policyNo'), data['PolicyNumber'])
//	
//	WebUI.delay(2)
//}

WebUI.click(findTestObject('Claim Portal/Claim Approval/Page_ClaimsApproval - SHRILIFE/Policy _Details', [('policyNo') : data['PolicyNumber']]))

WebUI.click(findTestObject('Claim Portal/Claim Approval/Page_ClaimsApproval - SHRILIFE/Registration Details'))

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.delay(2.5)

WebUI.selectOptionByLabel(findTestObject('Claim Portal/Claim Registration/Page_ClaimsRegistration - SHRILIFE/Cause_of_Death'), data['DeathCause'], false)

WebUI.delay(1)

WebUI.click(findTestObject('Claim Portal/Claim Approval/Page_ClaimsApproval - SHRILIFE/Approve_Button'))

//WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.delay(1)

WebUI.waitForElementVisible(findTestObject('Claim Portal/Claim Approval/Page_ClaimsApproval - SHRILIFE/h2_Claims Approved'), 30)

SS.capture("Checker Details")
//WebUI.verifyElementVisible(findTestObject('Claim Portal/Claim Approval/Page_ClaimsApproval - SHRILIFE/h2_Claims Approved'))

WebUI.click(findTestObject('Claim Portal/Claim Approval/Page_ClaimsApproval - SHRILIFE/button_OK'))

//**************************************Logout Function :- User ID Checker********************************************
 
 WebUI.callTestCase(findTestCase('Test Cases/Claim_Portal/Logout_Function'), null)