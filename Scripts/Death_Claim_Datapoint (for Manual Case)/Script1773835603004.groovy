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
import calendar.DateSelector
import methods.CaptureValues
import methods.createExcel
import methods.WriteExcel
import methods.select_Date

Map data = FetchExcelData.getData("Death", TestCaseID)

WebUI.waitForElementClickable(findTestObject('shrilifeadmission/claimsadmission/claims'), GlobalVariable.G_PageTimeout)

WebUI.enhancedClick(findTestObject('shrilifeadmission/claimsadmission/claims'))

WebUI.scrollToElement(findTestObject('shrilifeadmission/claimpaymentApproval/claimPayment/cliamPaymentApproval'), 2)

WebUI.enhancedClick(findTestObject('shrilifeadmission/claimpaymentApproval/claimPayment/cliamPaymentApproval'))

WebUI.setText(findTestObject('shrilifeadmission/claimpaymentApproval/claimPayment/policyNo'), data['PolicyNumber'])

WebUI.enhancedClick(findTestObject('shrilifeadmission/claimpaymentApproval/claimPayment/go'))

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.delay(1)

SS.capture("Death_Claim_Approval")

WebUI.delay(1)

if(WebUI.waitForElementPresent(findTestObject('Object Repository/shrilifeadmission/Benefit_Details'), 2)) {
	
	WebUI.scrollToElement(findTestObject('Object Repository/shrilifeadmission/Benefit_Details'), 2)
	SS.capture("Benefit_Payble")
}

WebUI.enhancedClick(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/claimPayment/PolicyInformation'))

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.delay(3)

CaptureValues.getDataPointValues()

createExcel.createDataPointSheet()

WebUI.delay(3)

WriteExcel.writeDataPoint(data['PolicyNumber'], data['TestCaseDescription'], data['DeathDate'], data['DeathCause'], data['AccidentDate'])

//WebUI.enhancedClick(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/claimPayment/Close-PolicyInfo'))
//
//WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.delay(1)

//WebUI.scrollToElement(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/PolicyInfo1'), 2)
//
//SS.capture("Policy_Info1")
//
//WebUI.scrollToElement(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/PolicyInfo2'), 2)
//
//SS.capture("Policy_Info2")

//WebUI.enhancedClick(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/claimPayment/Close-PolicyInfo'))

WebUI.delay(2)



String netAmountRaw = WebUI.getAttribute(findTestObject('shrilifeadmission/claimpaymentApproval/claimPayment/netAmountPayable'),
	'value')

WebUI.enhancedClick(findTestObject('shrilifeadmission/claimpaymentApproval/claimPayment/edit'))

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.scrollToElement(findTestObject('shrilifeadmission/claimpaymentApproval/claimPayment/amount'), 2)

String netAmountClean = netAmountRaw

//WebUI.enhancedClick(findTestObject('shrilifeadmission/claimpaymentApproval/claimPayment/amount'))

WebUI.setText(findTestObject('shrilifeadmission/claimpaymentApproval/claimPayment/amount'), netAmountClean)

WebUI.enhancedClick(findTestObject('shrilifeadmission/claimpaymentApproval/claimPayment/update'))

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.scrollToElement(findTestObject('shrilifeadmission/claimpaymentApproval/claimPayment/edit'), 2)

SS.capture("Death_Claim_Approval")

WebUI.enhancedClick(findTestObject('shrilifeadmission/claimpaymentApproval/claimPayment/editBeneficaryDetails'))

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.enhancedClick(findTestObject('shrilifeadmission/claimpaymentApproval/beneficaryDetails/beneficiaryName'))

//CustomKeywords.'com.utils.DropdownKeywords.selectDropdown'(findTestObject('shrilifeadmission/claimpaymentApproval/beneficaryDetails/paymentMode'),
//	'EFT' // or '87'
//	, 'label' // use 'value' to select by value attribute
//	, 10)

WebUI.selectOptionByLabel(findTestObject('shrilifeadmission/claimpaymentApproval/beneficaryDetails/paymentMode'), data['PaymentMode'], false)

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.enhancedClick(findTestObject('shrilifeadmission/claimpaymentApproval/beneficaryDetails/paymentConfirm'))

WebUI.setText(findTestObject('shrilifeadmission/claimpaymentApproval/beneficaryDetails/mobileno'), data['MobileNo'])

WebUI.setText(findTestObject('shrilifeadmission/claimpaymentApproval/beneficaryDetails/bankName'), data['Benef_BankName'])

WebUI.setText(findTestObject('shrilifeadmission/claimpaymentApproval/beneficaryDetails/bankAccountNo'), data['Benef_AccountNo'])

WebUI.setText(findTestObject('shrilifeadmission/claimpaymentApproval/beneficaryDetails/branchName'), data['Benef_BankBranch'])

//CustomKeywords.'com.utils.DropdownKeywords.selectDropdown'(findTestObject('shrilifeadmission/claimpaymentApproval/beneficaryDetails/accountType'),
//	'Savings Account' // or '87'
//	, 'label' // use 'value' to select by value attribute
//	, 10)

WebUI.selectOptionByLabel(findTestObject('shrilifeadmission/claimpaymentApproval/beneficaryDetails/accountType'), data['Benef_AccountType'], false)

WebUI.setText(findTestObject('shrilifeadmission/claimpaymentApproval/beneficaryDetails/bankIfsc'), data['Benef_IFSCCode'])

WebUI.enhancedClick(findTestObject('shrilifeadmission/claimpaymentApproval/beneficaryDetails/update'))

//WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)
WebUI.waitForAlert(GlobalVariable.G_PageTimeout)

WebUI.acceptAlert()

WebUI.enhancedClick(findTestObject('shrilifeadmission/claimpaymentApproval/beneficaryDetails/backtoPyamentApproval'))

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.delay(1)

//CustomKeywords.'calendar.DateSelector.selectTodayDate'(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/claimPayment/requirementRcdDate'))

//select_Date.selectCurrentDate()

WebUI.enhancedClick(findTestObject('Object Repository/Calendar/CalendarIcon'))
WebUI.delay(1)

WebUI.enhancedClick(findTestObject('Object Repository/Calendar/currDate', [('Date') : data['CurrentDate']]))

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.delay(3)

//WebUI.enhancedClick(findTestObject('shrilifeadmission/claimpaymentApproval/claimPayment/generatePRF'))
//
//WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)
//
//WebUI.setText(findTestObject('shrilifeadmission/claimpaymentApproval/paymentRequestform/addEmailid'), data['PRF_EmailID'])
//
//WebUI.setText(findTestObject('shrilifeadmission/claimpaymentApproval/paymentRequestform/remarks'), data['PRF_Remarks'])
//
//SS.capture("PRF_Form")
//
//JOptionPane.showMessageDialog(null, 'Click OK to continue')
//
//WebUI.enhancedClick(findTestObject('shrilifeadmission/claimpaymentApproval/paymentRequestform/approve'))
//
//WebUI.waitForAlert(GlobalVariable.G_PageTimeout)
//
//WebUI.acceptAlert()

WebUI.closeBrowser()

//createExcel.createDataPointSheet()
//
//WebUI.delay(0.5)
//
//WriteExcel.writeDataPoint(data['PolicyNumber'])



