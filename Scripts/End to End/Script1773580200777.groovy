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
import methods.CaptureScreenshot as SS
import methods.createExcel as createExcel

if (Executor.toString().equalsIgnoreCase('yes')) {
    try {
        SS.screenshotDir(TestCaseID)

        createExcel.generateReport()

        WebUI.callTestCase(findTestCase('Test Cases/Claim_Intimation'), [('TestCaseID') : TestCaseID])

        WebUI.callTestCase(findTestCase('Test Cases/Claim_Registration'), [('TestCaseID') : TestCaseID])

        WebUI.callTestCase(findTestCase('Test Cases/Claim_Approval'), [('TestCaseID') : TestCaseID])

		WebUI.callTestCase(findTestCase('Test Cases/Death_Claim_Processing'), [('TestCaseID') : TestCaseID])

//     	WebUI.callTestCase(findTestCase('Test Cases/Login_Page_Shrilife'), [('UserID') : 'S08053'])		   

        WebUI.callTestCase(findTestCase('Test Cases/Death_Claim_Admission'), [('TestCaseID') : TestCaseID])

        WebUI.callTestCase(findTestCase('Test Cases/Death_Claim_Approval'), [('TestCaseID') : TestCaseID])

        WebUI.callTestCase(findTestCase('Test Cases/PRF_Approval'), [('TestCaseID') : TestCaseID])

        WebUI.callTestCase(findTestCase('Test Cases/Death_Claim_Batch_Process'), [('TestCaseID') : TestCaseID])

        WebUI.callTestCase(findTestCase('Test Cases/EFT_File_Generation'), [('TestCaseID') : TestCaseID])

        WebUI.callTestCase(findTestCase('Test Cases/Download_Reports'), [('TestCaseID') : TestCaseID])
    }
    catch (Exception e) {
        SS.capture('Execution_Failure')

        KeywordUtil.markFailed('Step failed: ' + e.message)
    } 
}

