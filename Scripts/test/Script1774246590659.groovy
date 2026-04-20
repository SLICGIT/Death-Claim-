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
import eft.file


//Map data = FetchExcelData.getData("Death", TestCaseID)

//login with S08053
WebUI.callTestCase(findTestCase('Test Cases/Login_Page_Shrilife'), [('UserID') : 'N01426'])

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

int parentFrame = WebUI.getWindowIndex()

WebUI.click(findTestObject('Object Repository/shrilifeadmission/downloadReports/reportTray'))

WebUI.delay(3)

String policyNo='NP012512025219'

WebUI.waitForPageLoad(5) // or use a wait for window count as in Option A
WebUI.switchToWindowIndex(parentFrame + 1)

WebUI.waitForElementPresent(findTestObject('Object Repository/shrilifeadmission/downloadReports/ReportDownload', [('policyNo') : data['PolicyNumber']]), 5)

WebUI.enhancedClick(findTestObject('Object Repository/shrilifeadmission/downloadReports/viewReport', [('policyNo') : data['PolicyNumber']]))

JOptionPane.showMessageDialog(null, 'Click OK to continue')


file.getEftFile('Yes')

WebUI.closeBrowser()
