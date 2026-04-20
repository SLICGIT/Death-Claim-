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
import calendar.DateSelector
import methods.CaptureScreenshot as SS
import utils.PdfDownloader

Map data = FetchExcelData.getData("Death", TestCaseID)

//login with S08053
WebUI.callTestCase(findTestCase('Test Cases/Login_Page_Shrilife'), [('UserID') : 'S08053'])

WebUI.waitForElementClickable(findTestObject('shrilifeadmission/claimsadmission/claims'), GlobalVariable.G_PageTimeout)

WebUI.enhancedClick(findTestObject('shrilifeadmission/claimsadmission/claims'))

WebUI.scrollToElement(findTestObject('shrilifeadmission/claimpaymentApproval/claimPayment/cliamPaymentApproval'), 2)

WebUI.enhancedClick(findTestObject('shrilifeadmission/claimpaymentApproval/claimPayment/cliamPaymentApproval'))

WebUI.setText(findTestObject('shrilifeadmission/claimpaymentApproval/claimPayment/policyNo'), data['PolicyNumber'])

WebUI.enhancedClick(findTestObject('shrilifeadmission/claimpaymentApproval/claimPayment/go'))

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

CustomKeywords.'calendar.DateSelector.selectTodayDate'(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/claimPayment/legalAllocationDate'))

WebUI.enhancedClick(findTestObject('shrilifeadmission/claimpaymentApproval/claimPayment/approve'))

SS.capture("Claim_Payment_Approval")


//WebUI.scrollToElement(findTestObject, 0, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/claimPayment/OkBtn-PaymentApproved'), GlobalVariable.G_PageTimeout)

WebUI.delay(1)



//Click ok on 'Payment Details Approved Successfully"
WebUI.enhancedClick(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/claimPayment/OkBtn-PaymentApproved'))

WebUI.enhancedClick(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/claimPayment/CloseBtn'))

WebUI.waitForElementClickable(findTestObject('shrilifeadmission/deathclaimPaymentbacthprocess/payments'), GlobalVariable.G_PageTimeout)

WebUI.enhancedClick(findTestObject('shrilifeadmission/deathclaimPaymentbacthprocess/payments'))

WebUI.enhancedClick(findTestObject('shrilifeadmission/deathclaimPaymentbacthprocess/deathclaimPayment'))

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.selectOptionByLabel(findTestObject('shrilifeadmission/deathclaimPaymentbacthprocess/claimType'), 'First Time Payment',
	false)

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.selectOptionByLabel(findTestObject('shrilifeadmission/deathclaimPaymentbacthprocess/paymentMode'), data['PaymentMode'], false)

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.enhancedClick(findTestObject('shrilifeadmission/deathclaimPaymentbacthprocess/view'))

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.enhancedClick(findTestObject('shrilifeadmission/deathclaimPaymentbacthprocess/checkbox', [('PolicyNo') : data['PolicyNumber']]))

//int parentFrame = WebUI.getWindowIndex()
//
//WebUI.enhancedClick(findTestObject('shrilifeadmission/deathclaimPaymentbacthprocess/checklist'))
//
////Capture the brwoser URL and download the PDF and store
//
//WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)
//
//WebUI.switchToWindowIndex(parentFrame + 1)
//
////Capture the PDF UR
//String pdfUrl = WebUI.getUrl()
//KeywordUtil.logInfo("PDF URL: " + pdfUrl)
//
////CustomKeywords.'utils.PdfDownloader.downloadPdfWithSession'(pdfUrl, GlobalVariable.G_ScreenshotDir)
//
//WebUI.switchToWindowIndex(parentFrame)

WebUI.enhancedClick(findTestObject('shrilifeadmission/deathclaimPaymentbacthprocess/process'))

WebUI.delay(1)

WebUI.acceptAlert()

WebUI.waitForAlert(GlobalVariable.G_PageTimeout)

String batchIDText = WebUI.getAlertText()

String batchID = batchIDText.substring(38)

WebUI.acceptAlert()

//Display batchID in Log viewer
WebUI.comment(batchID)

WebUI.closeBrowser()

//WebUI.enhancedClick(findTestObject('shrilifeadmission/deathclaimPaymentbacthprocess/close'))
//handle browser popup
