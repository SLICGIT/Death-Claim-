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

import javax.swing.JOptionPane as JOptionPane


import methods.CaptureScreenshot as SS
import methods.FetchExcelData

Map data = FetchExcelData.getData("Death", TestCaseID)

//Login with PRF 1 approval manger user  N01436HDA
WebUI.callTestCase(findTestCase('Test Cases/Login_Page_Shrilife'), [('UserID') : 'N01436HDA'])

WebUI.waitForElementClickable(findTestObject('Object Repository/shrilifeadmission/prfApproval/ClaimsTab'), GlobalVariable.G_PageTimeout)

WebUI.enhancedClick(findTestObject('Object Repository/shrilifeadmission/prfApproval/ClaimsTab'))

WebUI.scrollToElement(findTestObject('shrilifeadmission/prfMangerTracker/prfMangerTracker'), 2)

WebUI.enhancedClick(findTestObject('shrilifeadmission/prfMangerTracker/prfMangerTracker'))

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.selectOptionByLabel(findTestObject('shrilifeadmission/prfApproval/searchBy'), 'Policy Number', false)

WebUI.setText(findTestObject('shrilifeadmission/prfApproval/txtSearch'), data['PolicyNumber'])

WebUI.enhancedClick(findTestObject('shrilifeadmission/prfApproval/search'))

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.enhancedClick(findTestObject('shrilifeadmission/prfApproval/viewPrf'))

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

//Prf download


//WebUI.setText(findTestObject('shrilifeadmission/claimpaymentApproval/paymentRequestform/addEmailid'), data['PRF_EmailID'])

WebUI.setText(findTestObject('shrilifeadmission/claimpaymentApproval/paymentRequestform/remarks'), data['PRF_Remarks'])

WebUI.enhancedClick(findTestObject('shrilifeadmission/claimpaymentApproval/paymentRequestform/approve'))

//shrilife brouwser pop handle
WebUI.waitForAlert(GlobalVariable.G_PageTimeout)

WebUI.acceptAlert()

WebUI.delay(2)

WebUI.closeBrowser()

//Login with PRF 2 approval account  user n03557
WebUI.callTestCase(findTestCase('Test Cases/Login_Page_Shrilife'), [('UserID') : 'n03557'])

WebUI.waitForElementClickable(findTestObject('Object Repository/shrilifeadmission/prfApproval/ReportTab'), GlobalVariable.G_PageTimeout)

WebUI.enhancedClick(findTestObject('Object Repository/shrilifeadmission/prfApproval/ReportT'))

WebUI.delay(5)

WebUI.enhancedClick(findTestObject('Object Repository/shrilifeadmission/prfApproval/accountReport'))

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.delay(5)

WebUI.waitForElementClickable(findTestObject('shrilifeadmission/downloadReports/policywsieTransactionReport'), 5 )

WebUI.enhancedClick(findTestObject('shrilifeadmission/downloadReports/policywsieTransactionReport'))



WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.setText(findTestObject('shrilifeadmission/downloadReports/policyNo'), data['PolicyNumber'])

WebUI.setText(findTestObject('shrilifeadmission/downloadReports/fromDate'), '01/01/2005')

WebUI.enhancedClick(findTestObject('Object Repository/shrilifeadmission/downloadReports/toDate'))

//WebUI.acceptAlert()

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

CustomKeywords.'calendar.DateSelector.selectTodayDate'(findTestObject('Object Repository/shrilifeadmission/downloadReports/toDate'))

String policyNo = data['PolicyNumber']

WebUI.setText(findTestObject('shrilifeadmission/downloadReports/reportName'), "One_" + policyNo)

SS.capture("Accounting_Report")

WebUI.enhancedClick(findTestObject('shrilifeadmission/downloadReports/generate'))

WebUI.waitForAlert(GlobalVariable.G_PageTimeout)

WebUI.acceptAlert()

WebUI.enhancedClick(findTestObject('shrilifeadmission/downloadReports/close'))



WebUI.waitForElementClickable(findTestObject('shrilifeadmission/prfApproval/services'), GlobalVariable.G_PageTimeout)

WebUI.enhancedClick(findTestObject('shrilifeadmission/prfApproval/services'))

WebUI.scrollToElement(findTestObject('shrilifeadmission/prfApproval/prfAccountTracker'), 2)

WebUI.enhancedClick(findTestObject('shrilifeadmission/prfApproval/prfAccountTracker'))

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.selectOptionByLabel(findTestObject('shrilifeadmission/prfApproval/searchBy'), 'Policy Number', false)

WebUI.setText(findTestObject('shrilifeadmission/prfApproval/txtSearch'), data['PolicyNumber'])

WebUI.enhancedClick(findTestObject('shrilifeadmission/prfApproval/search'))

WebUI.enhancedClick(findTestObject('shrilifeadmission/prfApproval/viewPrf'))

WebUI.setText(findTestObject('shrilifeadmission/claimpaymentApproval/paymentRequestform/addEmailid'), data['PRF_EmailID'])

WebUI.setText(findTestObject('shrilifeadmission/claimpaymentApproval/paymentRequestform/remarks'), data['PRF_Remarks'])

WebUI.enhancedClick(findTestObject('shrilifeadmission/claimpaymentApproval/paymentRequestform/approve'))

WebUI.delay(3)

//shrilife brouwser pop handle
WebUI.waitForAlert(GlobalVariable.G_PageTimeout)

WebUI.acceptAlert()

WebUI.delay(3)


WebUI.closeBrowser()