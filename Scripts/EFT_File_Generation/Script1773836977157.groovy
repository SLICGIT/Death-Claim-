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
import eft.file

Map data = FetchExcelData.getData("Death", TestCaseID)

//login with S08053
WebUI.callTestCase(findTestCase('Test Cases/Login_Page_Shrilife'), [('UserID') : 'N01426'])

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.waitForElementClickable(findTestObject('shrilifeadmission/eftProcess/payments'), GlobalVariable.G_PageTimeout)

WebUI.delay(1)

WebUI.enhancedClick(findTestObject('shrilifeadmission/eftProcess/payments'))

WebUI.scrollToElement(findTestObject('shrilifeadmission/eftProcess/eftPayment'), 2)

WebUI.enhancedClick(findTestObject('shrilifeadmission/eftProcess/eftPayment'))

WebUI.scrollToElement(findTestObject('shrilifeadmission/eftProcess/eftFileGeneration'), 2)

WebUI.enhancedClick(findTestObject('shrilifeadmission/eftProcess/eftFileGeneration'))

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.selectOptionByLabel(findTestObject('Object Repository/shrilifeadmission/eftProcess/eftGeneration/transferType'), 'Transfer', false)

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.enhancedClick(findTestObject('shrilifeadmission/eftProcess/eftGeneration/paymentBank'))

WebUI.enhancedClick(findTestObject('shrilifeadmission/eftProcess/eftGeneration/paymentBankOption'))

WebUI.enhancedClick(findTestObject('Object Repository/shrilifeadmission/eftProcess/eftGeneration/transferType'))

WebUI.delay(5)

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.enhancedClick(findTestObject('shrilifeadmission/eftProcess/eftGeneration/batchNo'))

WebUI.enhancedClick(findTestObject('shrilifeadmission/eftProcess/eftGeneration/batchNoselection'))

SS.capture("EFT_File_Generation")

WebUI.enhancedClick(findTestObject('shrilifeadmission/eftProcess/eftGeneration/checkList'))

//WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)
//
//WebUI.delay(2)

file.getEftFile('Yes')

WebUI.delay(1)

WebUI.enhancedClick(findTestObject('Object Repository/shrilifeadmission/eftProcess/eftGeneration/CloseBtn'))

//String movedPath = file.getEftFile('Yes')  // or whatever your EFT_Required param is
//assert movedPath != null : 'EFT Excel was not downloaded/moved'