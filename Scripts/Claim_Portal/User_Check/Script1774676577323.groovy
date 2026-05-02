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
import methods.BrowserPermissions
import methods.CaptureScreenshot as SS


Map data = FetchExcelData.getData('Death', TestCaseID)
 
WebUI.callTestCase(findTestCase('Test Cases/Claim_Portal/Login_Page'), [('UserID') : 'K02979'])
 
WebUI.mouseOver(findTestObject('Claim Intimation Shrilife/Page_Dashboard - SHRILIFE/Claim_option'))
 
WebUI.mouseOver(findTestObject('Claim Intimation Shrilife/Page_Dashboard - SHRILIFE/Claim_Intimation'))
 
WebUI.click(findTestObject('Claim Intimation Shrilife/Page_Dashboard - SHRILIFE/a_Death Claim'))
 
WebUI.delay(1)

WebUI.waitForElementVisible(findTestObject('Claim Intimation Shrilife/Page_Death Claims - SHRILIFE/Assigned_Claims'), 10)
 
WebUI.click(findTestObject('Claim Intimation Shrilife/Page_Death Claims - SHRILIFE/Assigned_Claims'))
 
WebUI.delay(5)
 
WebUI.waitForElementVisible(findTestObject('Claim Intimation Shrilife/Page_Death Claims - SHRILIFE/grid_table'), 60)
 
WebUI.setText(findTestObject('Claim Intimation Shrilife/Page_Death Claims - SHRILIFE/input_policy_no'), data['PolicyNumber'])
 
WebUI.delay(5)
 
WebUI.click(findTestObject('Claim Intimation Shrilife/Page_Death Claims - SHRILIFE/View_Remark'))
 
WebUI.delay(5)
 
GlobalVariable.G_USER = WebUI.getText(findTestObject('Object Repository/Claim Intimation Shrilife/Page_Death Claims - SHRILIFE/Assigned_User'))
 
WebUI.comment(GlobalVariable.G_USER)
 
WebUI.callTestCase(findTestCase('Claim_Portal/Logout_Function'), [:], FailureHandling.STOP_ON_FAILURE)