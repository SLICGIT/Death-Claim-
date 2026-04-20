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
import methods.FetchExcelData as FetchExcelData
import methods.CaptureScreenshot as SS
import calendar.DateSelector
 
Map data = FetchExcelData.getData('Death', TestCaseID)
 
WebUI.callTestCase(findTestCase('Test Cases/Claim_Portal/Login_Page'), [('UserID') : data['LvlTwo_ManagerID']])
 
WebUI.waitForElementVisible(findTestObject('Claim Intimation Shrilife/Page_Dashboard - SHRILIFE/Claim_option'), 10)
 
WebUI.mouseOver(findTestObject('Claim Intimation Shrilife/Page_Dashboard - SHRILIFE/Claim_option'))
 
WebUI.click(findTestObject('Claim Booked/Page_Dashboard - SHRILIFE/Claim Booked option'))
 
WebUI.click(findTestObject('Claim Intimation Shrilife/Page_Dashboard - SHRILIFE/a_Death Claim'))
 
WebUI.waitForElementClickable(findTestObject('Claim Booked/Page_Dashboard - SHRILIFE/Booked Claims button'), 20)
 
WebUI.click(findTestObject('Claim Booked/Page_Dashboard - SHRILIFE/Booked Claims button'))
 
// If The Policy is assigned to Early Claims
WebUI.click(findTestObject('Claim Booked/Page_Booked Claims/Early Claims'))
 
WebUI.delay(3)
 
 
WebUI.setText(findTestObject('Claim Booked/Page_Booked Claims/input_policy_no'), data['PolicyNumber'])
 
WebUI.delay(3)
 
String claimType
 
// Check Claim Type
TestObject checkbox = findTestObject('Object Repository/Claim Booked/Page_Booked Claims/input_checkbox')
 
if (WebUI.waitForElementVisible(checkbox, 10, FailureHandling.OPTIONAL)) {
    WebUI.waitForElementClickable(checkbox, 10, FailureHandling.OPTIONAL)
 
    claimType = WebUI.getText(findTestObject('Claim Booked/Page_Booked Claims/Early Claims'))
 
    WebUI.click(checkbox //    WebUI.comment('Policy Details did not become visible within 10s.')
        //If the Policy assigned to the Non-Early claims
        // If the Policy assiged to lapsed Policy
        )
} else {
    WebUI.clearText(findTestObject('Object Repository/Claim Booked/Page_Booked Claims/input_policy_no'))
 
    WebUI.click(findTestObject('Object Repository/Claim Booked/Page_Booked Claims/Dedupe Claims'))
	WebUI.delay(3)
 
    WebUI.setText(findTestObject('Claim Booked/Page_Booked Claims/input_policy_no'), data['PolicyNumber'])
	WebUI.delay(3)
 
    if (WebUI.waitForElementVisible(checkbox, 10, FailureHandling.OPTIONAL)) {
        WebUI.waitForElementClickable(checkbox, 10, FailureHandling.OPTIONAL)
 
        claimType = WebUI.getText(findTestObject('Object Repository/Claim Booked/Page_Booked Claims/Dedupe Claims'))
		WebUI.delay(2)
        WebUI.click(checkbox)
    } else {
        WebUI.clearText(findTestObject('Object Repository/Claim Booked/Page_Booked Claims/input_policy_no'))
 
        WebUI.click(findTestObject('Object Repository/Claim Booked/Page_Booked Claims/Non Early Claims'))
		WebUI.delay(3)

 
        WebUI.setText(findTestObject('Claim Booked/Page_Booked Claims/input_policy_no'), data['PolicyNumber'])
		WebUI.delay(3)

 
        if (WebUI.waitForElementVisible(checkbox, 10, FailureHandling.OPTIONAL)) {
            WebUI.waitForElementClickable(checkbox, 10, FailureHandling.OPTIONAL)
 
            claimType = WebUI.getText(findTestObject('Object Repository/Claim Booked/Page_Booked Claims/Non Early Claims'))
			WebUI.delay(2)
            WebUI.click(checkbox)
        } else {
            WebUI.clearText(findTestObject('Object Repository/Claim Booked/Page_Booked Claims/input_policy_no'))
 
            WebUI.click(findTestObject('Object Repository/Claim Booked/Page_Booked Claims/Lapsed Claims'))
			WebUI.delay(3)
 
            WebUI.setText(findTestObject('Claim Booked/Page_Booked Claims/input_policy_no'), data['PolicyNumber'])
			WebUI.delay(3)

 
            if (WebUI.waitForElementVisible(checkbox, 10, FailureHandling.OPTIONAL)) {
                WebUI.waitForElementClickable(checkbox, 10, FailureHandling.OPTIONAL)
 
                claimType = WebUI.getText(findTestObject('Object Repository/Claim Booked/Page_Booked Claims/Lapsed Claims'))
				WebUI.delay(2)
                WebUI.click(checkbox)
            } else {
                WebUI.comment('Policy Details not available.')
            }
        }
    }
}
 
WebUI.click(findTestObject('Object Repository/Claim Booked/Page_Booked Claims/Manual allocation'))
 
WebUI.click(findTestObject('Claim Booked/Page_Booked Claims/Select user'))
 
WebUI.selectOptionByValue(findTestObject('Object Repository/Claim Booked/Page_Booked Claims/Select user'), 'M05138', false)
 
WebUI.setText(findTestObject('Claim Booked/Page_Booked Claims/Remark'), 'ok')
 
WebUI.click(findTestObject('Claim Booked/Page_Booked Claims/button_Submit'))
 
SS.capture('N01436_Allocated_Details')
 
WebUI.waitForElementVisible(findTestObject('Claim Booked/Page_Booked Claims/h2_Claims successfully got assigned to User M05138'), 
    GlobalVariable.G_PageTimeout)
 
//WebUI.verifyElementVisible(findTestObject('Claim Booked/Page_Booked Claims/h2_Claims successfully got assigned to User M05138'),
//	FailureHandling.STOP_ON_FAILURE)
SS.capture('N01436_ User_Approved_Details')
 
WebUI.click(findTestObject('Claim Booked/Page_Booked Claims/OK_button'))
 
//**************************************Logout Function :- LVL 2 Manager N01436********************************************
WebUI.callTestCase(findTestCase('Test Cases/Claim_Portal/Logout_Function'), null)
 
//**************************************Login M Praveen User ID M05138********************************************
WebUI.callTestCase(findTestCase('Test Cases/Claim_Portal/Login_Page'), [('UserID') : 'M05138'])
 
WebUI.waitForElementVisible(findTestObject('Death Claim Assign/Page_Dashboard - SHRILIFE/Claim_option'), 10)
 
WebUI.mouseOver(findTestObject('Death Claim Assign/Page_Dashboard - SHRILIFE/Claim_option'))
 
WebUI.mouseOver(findTestObject('Death Claim Assign/Page_Dashboard - SHRILIFE/Scrutiny Option'))
 
WebUI.click(findTestObject('Death Claim Assign/Page_Dashboard - SHRILIFE/Scrutiny Death Claim'))
 
WebUI.waitForElementVisible(findTestObject('Death Claim Assign/Page_Dashboard - SHRILIFE/assigned Claim button'), 10)
 
WebUI.click(findTestObject('Death Claim Assign/Page_Dashboard - SHRILIFE/assigned Claim button'))
 
WebUI.comment(claimType)
 
WebUI.waitForElementClickable(findTestObject('Object Repository/Death Claim Assign/Page Claim Assessor/Claim Type', [('ClaimType') : claimType]), 
    GlobalVariable.G_PageTimeout)
 
//WebUI.click(findTestObject('Death Claim Assign/Page Claim Assessor/Early Claims'))
WebUI.click(findTestObject('Object Repository/Death Claim Assign/Page Claim Assessor/Claim Type', [('ClaimType') : claimType]))
 
WebUI.delay(3)
 
WebUI.setText(findTestObject('Death Claim Assign/Page Claim Assessor/Policy NO input'), data['PolicyNumber'])
 
WebUI.delay(3)
 
TestObject policydetails = findTestObject('Death Claim Assign/Page Claim Assessor/Policy Details')
 
if (WebUI.verifyElementPresent(policydetails, 2, FailureHandling.OPTIONAL)) {
    WebUI.click(policydetails)
}
 
 
WebUI.setText(findTestObject('Death Claim Assign/Page_Claims Assessor Review/Assessor Remark'), 'ok')
 
WebUI.click(findTestObject('Death Claim Assign/Page_Claims Assessor Review/Admit Button'))
 
WebUI.click(findTestObject('Death Claim Assign/Page_Claims Assessor Review/Manager Select'))
 
//CustomKeywords.'com.utils.DropdownKeywords.selectDropdown'(findTestObject('Death Claim Assign/Page_Claims Assessor Review/Manager Select'),
//	'Manager I Naresh Ameti (R0163)' // or '87'
//	, 'label' // use 'value' to select by value attribute
//	, 10)
WebUI.selectOptionByLabel(findTestObject('Death Claim Assign/Page_Claims Assessor Review/Manager Select'), 'Manager I Naresh Ameti (R0163)', 
    false)
 
WebUI.setText(findTestObject('Death Claim Assign/Page_Claims Assessor Review/Remark'), 'ok')
 
WebUI.click(findTestObject('Death Claim Assign/Page_Claims Assessor Review/button_Submit'))
 
WebUI.waitForElementVisible(findTestObject('Death Claim Assign/Page_Claims Assessor Review/button_OK'), GlobalVariable.G_PageTimeout)
 
SS.capture('M05138_ User_Approved_Details')
 
WebUI.click(findTestObject('Death Claim Assign/Page_Claims Assessor Review/button_OK'))
 
//**************************************Logout Function :- M Praveen User ID M05138********************************************
WebUI.callTestCase(findTestCase('Test Cases/Claim_Portal/Logout_Function'), null)
 
//**************************************Login Function :- M Praveen User ID M05138********************************************
WebUI.callTestCase(findTestCase('Test Cases/Claim_Portal/Login_Page'), [('UserID') : 'A05139'])
 
WebUI.waitForElementClickable(findTestObject('Death Claim Assign/Page_Dashboard - SHRILIFE/Claim_option'), 10)
 
WebUI.mouseOver(findTestObject('Death Claim Assign/Page_Dashboard - SHRILIFE/Claim_option'))
 
WebUI.mouseOver(findTestObject('Claim Intimate Decision/Page_Dashboard - SHRILIFE/Claim Intimation option'))
 
WebUI.click(findTestObject('Claim Intimate Decision/Page_Dashboard - SHRILIFE/Death Claim option'))
 
WebUI.waitForElementVisible(findTestObject('Claim Intimate Decision/Page_Dashboard - SHRILIFE/Decision Pending option'), 
    10)
 
WebUI.click(findTestObject('Claim Intimate Decision/Page_Dashboard - SHRILIFE/Decision Pending option'))
 
WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.delay(1)

String todayDate = new Date().format("dd-MM-yyyy")
WebUI.setText(findTestObject('Object Repository/Claim Intimate Decision/Page_Dashboard - SHRILIFE/FromDate'), todayDate)
WebUI.delay(0.5)
WebUI.setText(findTestObject('Object Repository/Claim Intimate Decision/Page_Dashboard - SHRILIFE/ToDate'), todayDate)
WebUI.delay(0.5)
WebUI.enhancedClick(findTestObject('Object Repository/Claim Intimate Decision/Page_Dashboard - SHRILIFE/FromDate'))

WebUI.delay(3)
 
//The Used XPath is parameterized
WebUI.click(findTestObject('Claim Intimate Decision/Page_Death Claims - SHRILIFE/Policy_details', [('policyNo') : data['PolicyNumber']]))
 
WebUI.delay(3)
 
// Checking for SA
//TestObject P_SA = findTestObject('Object Repository/Claim Intimate Decision/Page_Death Claims - SHRILIFE/SA')
 
//WebUI.comment(WebUI.getText(P_SA))
 
// Get text and parse to int
//int PSA = Integer.parseInt(WebUI.getText(P_SA))
 
//WebUI.comment("SA value: " + PSA)
 
WebUI.setText(findTestObject('Claim Intimate Decision/Page_Death Claims - SHRILIFE/M1remarks_text'), 'ok')
 
WebUI.click(findTestObject('Claim Intimate Decision/Page_Death Claims - SHRILIFE/Admit_Button'))
 
WebUI.delay(3)
 
 
SS.capture('A05139_ User_Approved_Details')
 
WebUI.click(findTestObject('Claim Intimate Decision/Page_Death Claims - SHRILIFE/button_OK'))
 
//**************************************Logout Function :- M Praveen User ID A05139********************************************
WebUI.callTestCase(findTestCase('Test Cases/Claim_Portal/Logout_Function'), null)
 

//if (PSA <= 100000 ) {
//	 WebUI.comment("Process Completed")
//}

//else {
	WebUI.callTestCase(findTestCase('Claim_Portal/User_Check'), [('TestCaseID') : TestCaseID], FailureHandling.STOP_ON_FAILURE)
	
	if(GlobalVariable.G_USER =='A05139') {
		
		WebUI.callTestCase(findTestCase('Test Cases/Claim_Portal/Logout_Function'), null)
	}
	
	 else if(GlobalVariable.G_USER =='K02979') {
		WebUI.callTestCase(findTestCase('Test Cases/Claim_Portal/Login_Page'), [('UserID') : data['LvlOne_ManagerID']])
		WebUI.waitForElementClickable(findTestObject('Death Claim Assign/Page_Dashboard - SHRILIFE/Claim_option'), 10)
		WebUI.mouseOver(findTestObject('Death Claim Assign/Page_Dashboard - SHRILIFE/Claim_option'))
		WebUI.mouseOver(findTestObject('Claim Intimate Decision/Page_Dashboard - SHRILIFE/Claim Intimation option'))
		WebUI.click(findTestObject('Claim Intimate Decision/Page_Dashboard - SHRILIFE/Death Claim option'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Claim Intimate Decision/Page_Dashboard - SHRILIFE/Decision Pending option_K02979'),
			10)
		WebUI.click(findTestObject('Object Repository/Claim Intimate Decision/Page_Dashboard - SHRILIFE/Decision Pending option_K02979'))
		WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)
		WebUI.delay(3)
		//The Used XPath is parameterized
		WebUI.click(findTestObject('Claim Intimate Decision/Page_Death Claims - SHRILIFE/Policy_details', [('policyNo') : data['PolicyNumber']]))
		WebUI.delay(3)
		WebUI.setText(findTestObject('Claim Intimate Decision/Page_Death Claims - SHRILIFE/M1remarks_text'), 'ok')
		WebUI.click(findTestObject('Claim Intimate Decision/Page_Death Claims - SHRILIFE/Admit_Button'))
		WebUI.delay(3)

		SS.capture('K02979_ User_Approved_Details')
		WebUI.click(findTestObject('Claim Intimate Decision/Page_Death Claims - SHRILIFE/button_OK'))
	}
		else if (GlobalVariable.G_USER =='N01436') {
			WebUI.callTestCase(findTestCase('Test Cases/Claim_Portal/Login_Page'), [('UserID') : data['LvlTwo_ManagerID']])
			 WebUI.waitForElementClickable(findTestObject('Claim Book Final Process/Page_Dashboard - SHRILIFE/Claim_option'), GlobalVariable.G_PageTimeout)
			 WebUI.mouseOver(findTestObject('Claim Book Final Process/Page_Dashboard - SHRILIFE/Claim_option'))
			 WebUI.click(findTestObject('Claim Book Final Process/Page_Dashboard - SHRILIFE/Claim Booked option'))
			 WebUI.click(findTestObject('Claim Book Final Process/Page_Dashboard - SHRILIFE/Death Claim'))
			 WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)
			// decision=findTestObject('Claim Book Final Process/Page_Dashboard - SHRILIFE/Decision Pending Option')
//			  if (WebUI.waitForElementNotClickable(policy, 10, FailureHandling.OPTIONAL)) {
//
//
//				  WebUI.comment('Policy is not assigned Here')
//			  }

			 WebUI.click(findTestObject('Claim Book Final Process/Page_Dashboard - SHRILIFE/Decision Pending Option'))
			 WebUI.waitForElementClickable(findTestObject('Object Repository/Claim Book Final Process/Page_Booked Claims/Claim_Type_N01436',
					 [('ClaimType') : claimType]), GlobalVariable.G_PageTimeout)
			 WebUI.delay(2)
			 WebUI.enhancedClick(findTestObject('Object Repository/Claim Book Final Process/Page_Booked Claims/Claim_Type_N01436', [('ClaimType') : claimType]))
			 WebUI.delay(2)
			 //WebUI.click(findTestObject('Claim Book Final Process/Page_Booked Claims/Early Claims'))
			 WebUI.setText(findTestObject('Claim Book Final Process/Page_Booked Claims/input_policy_no'), data['PolicyNumber'])
			 WebUI.delay(1)
			 //Check for policy assignment
			 policy= findTestObject('Claim Book Final Process/Page_Booked Claims/Policy_Details')
			 if (WebUI.waitForElementNotVisible(policy, 10, FailureHandling.OPTIONAL)) {
				 WebUI.waitForElementNotClickable(policy, 10, FailureHandling.OPTIONAL)
				 WebUI.stop()
			 }
			 WebUI.enhancedClick(findTestObject('Claim Book Final Process/Page_Booked Claims/Policy_Details'))
			 WebUI.setText(findTestObject('Claim Book Final Process/Page_Booked Claims/M2 Remark'), 'ok')
			 WebUI.click(findTestObject('Claim Book Final Process/Page_Booked Claims/button_admit'))
			 WebUI.waitForElementVisible(findTestObject('Claim Book Final Process/Page_Booked Claims/OK_button'), GlobalVariable.G_PageTimeout)
			 WebUI.delay(1)
			 SS.capture('Process_Completed')
			 WebUI.click(findTestObject('Claim Book Final Process/Page_Booked Claims/OK_button'))

		}
		else {
			//**************************************Login Function :- M Praveen User ID R03146********************************************
			 WebUI.callTestCase(findTestCase('Test Cases/Claim_Portal/Login_Page'), [('UserID') : 'R03146'])
			 WebUI.waitForElementClickable(findTestObject('Claim Book Final Process/Page_Dashboard - SHRILIFE/Claim_option'), GlobalVariable.G_PageTimeout)
			 WebUI.mouseOver(findTestObject('Claim Book Final Process/Page_Dashboard - SHRILIFE/Claim_option'))
			 WebUI.click(findTestObject('Claim Book Final Process/Page_Dashboard - SHRILIFE/Claim Booked option'))
			 WebUI.click(findTestObject('Claim Book Final Process/Page_Dashboard - SHRILIFE/Death Claim'))
			 WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)
			 decision=findTestObject('Claim Book Final Process/Page_Dashboard - SHRILIFE/Decision Pending Option')

			 WebUI.click(findTestObject('Claim Book Final Process/Page_Dashboard - SHRILIFE/Decision Pending Option'))
			 WebUI.waitForElementClickable(findTestObject('Object Repository/Claim Book Final Process/Page_Booked Claims/Claim Type',
					 [('ClaimType') : claimType]), GlobalVariable.G_PageTimeout)
			 WebUI.enhancedClick(findTestObject('Object Repository/Claim Book Final Process/Page_Booked Claims/Claim Type', [('ClaimType') : claimType]))
			 WebUI.delay(2)
			 //WebUI.click(findTestObject('Claim Book Final Process/Page_Booked Claims/Early Claims'))
			 WebUI.setText(findTestObject('Claim Book Final Process/Page_Booked Claims/input_policy_no'), data['PolicyNumber'])
			 WebUI.delay(1)
			 //Check for policy assignment
			 policy= findTestObject('Claim Book Final Process/Page_Booked Claims/Policy_Details')
			 if (WebUI.waitForElementNotVisible(policy, 10, FailureHandling.OPTIONAL)) {
				 WebUI.waitForElementNotClickable(policy, 10, FailureHandling.OPTIONAL)
				 WebUI.stop()
			 }
			 WebUI.enhancedClick(findTestObject('Claim Book Final Process/Page_Booked Claims/Policy_Details'))

			 WebUI.setText(findTestObject('Claim Book Final Process/Page_Booked Claims/M3 Remark'), 'ok')
			 WebUI.click(findTestObject('Claim Book Final Process/Page_Booked Claims/button_admit'))
			 WebUI.waitForElementVisible(findTestObject('Claim Book Final Process/Page_Booked Claims/OK_button'), GlobalVariable.G_PageTimeout)
			 WebUI.delay(1)
			 SS.capture('Registration_Complete')
			 WebUI.click(findTestObject('Claim Book Final Process/Page_Booked Claims/OK_button'))

		}
//}