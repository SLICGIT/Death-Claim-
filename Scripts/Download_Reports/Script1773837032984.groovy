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


import methods.FetchExcelData
import calendar.DateSelector
import methods.CaptureScreenshot as SS

Map data = FetchExcelData.getData("Death", TestCaseID)

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.waitForElementClickable(findTestObject('shrilifeadmission/downloadReports/reports'), GlobalVariable.G_PageTimeout)

WebUI.delay(2)

WebUI.enhancedClick(findTestObject('shrilifeadmission/downloadReports/reports'))

WebUI.scrollToElement(findTestObject('shrilifeadmission/downloadReports/accountingReports'), 2)

WebUI.enhancedClick(findTestObject('shrilifeadmission/downloadReports/accountingReports'))

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.enhancedClick(findTestObject('shrilifeadmission/downloadReports/policywsieTransactionReport'))

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.setText(findTestObject('shrilifeadmission/downloadReports/policyNo'), data['PolicyNumber'])

WebUI.setText(findTestObject('shrilifeadmission/downloadReports/fromDate'), '01/01/2005')

WebUI.enhancedClick(findTestObject('Object Repository/shrilifeadmission/downloadReports/toDate'))

//WebUI.acceptAlert()

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

CustomKeywords.'calendar.DateSelector.selectTodayDate'(findTestObject('Object Repository/shrilifeadmission/downloadReports/toDate'))

String policyNo = data['PolicyNumber']

WebUI.setText(findTestObject('shrilifeadmission/downloadReports/reportName'), "Two_" + policyNo)

SS.capture("Accounting_Report")

WebUI.enhancedClick(findTestObject('shrilifeadmission/downloadReports/generate'))

WebUI.waitForAlert(GlobalVariable.G_PageTimeout)

WebUI.acceptAlert()

WebUI.enhancedClick(findTestObject('shrilifeadmission/downloadReports/close'))

//int parentFrame = WebUI.getWindowIndex()
//
//WebUI.click(findTestObject('Object Repository/shrilifeadmission/downloadReports/reportTray'))
//
//WebUI.delay(3)
//
//WebUI.waitForPageLoad(5) // or use a wait for window count as in Option A
//WebUI.switchToWindowIndex(parentFrame + 1)
//
//WebUI.waitForElementPresent(findTestObject('Object Repository/shrilifeadmission/downloadReports/ReportDownload', [('policyNo') : data['PolicyNumber']]), 5)
//
//WebUI.enhancedClick(findTestObject('Object Repository/shrilifeadmission/downloadReports/viewReport', [('policyNo') : data['PolicyNumber']]))
//
//JOptionPane.showMessageDialog(null, 'Click OK to continue')
//
//WebUI.switchToWindowIndex(parentFrame)



