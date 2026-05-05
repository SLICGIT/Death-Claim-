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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory
import javax.swing.JOptionPane as JOptionPane


import methods.FetchExcelData
import methods.BrowserPermissions
import methods.CaptureScreenshot as SS

BrowserPermissions.openChromeWithOptions()

WebUI.navigateToUrl(GlobalVariable.G_IntimationUrl)

WebUI.maximizeWindow()

Map data = FetchExcelData.getData("Death", TestCaseID)

WebUI.enhancedClick(findTestObject('Object Repository/Claim Intimation/HomePage/IntimateClaimBtn'))

WebUI.enhancedClick(findTestObject('Object Repository/Claim Intimation/HomePage/GotItBtn'))

WebUI.delay(1)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Claim Intimation/HomePage/RequestType'), data['RequestType'], false)

WebUI.setText(findTestObject('Object Repository/Claim Intimation/HomePage/Input-PolicyNumber'), data['PolicyNumber'])

WebUI.enhancedClick(findTestObject('Object Repository/Claim Intimation/HomePage/ProceedBtn'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Claim Intimation/HomePage/Input-Others'), GlobalVariable.G_PageTimeout)

WebUI.setText(findTestObject('Object Repository/Claim Intimation/HomePage/Input-Others'), 'Ok')

WebUI.waitForElementClickable(findTestObject('Object Repository/Claim Intimation/HomePage/ProceedBtn'), 10)

WebUI.enhancedClick(findTestObject('Object Repository/Claim Intimation/HomePage/ProceedBtn'))

//****************************************Death Details**********************************************

WebUI.waitForElementClickable(findTestObject('Object Repository/Claim Intimation/DeathDetails/DemiseDate'), GlobalVariable.G_PageTimeout)

WebUI.setText(findTestObject('Object Repository/Claim Intimation/DeathDetails/DemiseDate'), data['DemiseDate'])

WebUI.selectOptionByLabel(findTestObject('Object Repository/Claim Intimation/DeathDetails/IntimationReceivedFrom'), data['IntimationReceivedFrom'], false)

WebUI.setText(findTestObject('Object Repository/Claim Intimation/DeathDetails/ClaimantMobileNo'), data['MobileNo'])


WebUI.enhancedClick(findTestObject('Object Repository/Claim Intimation/DeathDetails/GetOTPBtn'))

//JOptionPane.showMessageDialog(null, 'Click OK to continue')


WebUI.setText(findTestObject('Object Repository/Claim Intimation/DeathDetails/Input-EnterOTP'), '123456')

WebUI.enhancedClick(findTestObject('Object Repository/Claim Intimation/DeathDetails/VerifyOTP'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Claim Intimation/DeathDetails/ProceedBtn'), GlobalVariable.G_PageTimeout)

SS.capture("Death_Details")

WebUI.enhancedClick(findTestObject('Object Repository/Claim Intimation/DeathDetails/ProceedBtn'))

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.enhancedClick(findTestObject('Object Repository/Claim Intimation/InsuredDetails/PersonalDetailsTab'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Claim Intimation/InsuredDetails/MaritalStatus'), data['MaritalStatus'], false)

WebUI.setText(findTestObject('Object Repository/Claim Intimation/InsuredDetails/LastEmployerName'), 'Satyam')

WebUI.setText(findTestObject('Object Repository/Claim Intimation/InsuredDetails/LastOccupation'), 'Employee')

WebUI.enhancedClick(findTestObject('Object Repository/Claim Intimation/InsuredDetails/OtherDetailsTab'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Claim Intimation/InsuredDetails/DemiseManner'), data['DemiseManner'], false)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Claim Intimation/InsuredDetails/DemisePlace'), data['DemisePlace'], false)

WebUI.setText(findTestObject('Object Repository/Claim Intimation/InsuredDetails/DemiseCause'), data['DemiseCause'])

WebUI.setText(findTestObject('Object Repository/Claim Intimation/InsuredDetails/DoctorName-DeathDeclared'), 'Doctor')

WebUI.setText(findTestObject('Object Repository/Claim Intimation/InsuredDetails/DoctorAddress-DeathDeclared'), 'Address1')

WebUI.setText(findTestObject('Object Repository/Claim Intimation/InsuredDetails/DoctorName-Postmortem'), 'Doctor')

WebUI.setText(findTestObject('Object Repository/Claim Intimation/InsuredDetails/DoctorAddress-PostMortem'), 'Address1')

WebUI.setText(findTestObject('Object Repository/Claim Intimation/InsuredDetails/PoliceStationName'), 'Police Station')

SS.capture("Other_Details")

WebUI.enhancedClick(findTestObject('Object Repository/Claim Intimation/InsuredDetails/ProceedBtn'))

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

//****************************************Claimant Details*******************************************

WebUI.waitForElementClickable(findTestObject('Object Repository/Claim Intimation/ClaimantDetails/ClaimantName'), 10)

WebUI.setText(findTestObject('Object Repository/Claim Intimation/ClaimantDetails/ClaimantName'), 'Claimant')

WebUI.selectOptionByLabel(findTestObject('Object Repository/Claim Intimation/ClaimantDetails/ClaimantLARelationship'), data['ClaimantRelation'], false)

WebUI.setText(findTestObject('Object Repository/Claim Intimation/ClaimantDetails/ClaimantDOB'), data['ClaimantDOB'])

WebUI.selectOptionByLabel(findTestObject('Object Repository/Claim Intimation/ClaimantDetails/ClaimantGender'), data['ClaimantGender'], false)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Claim Intimation/ClaimantDetails/ClaimantTitle'), data['ClaimantTitle'], false)

WebUI.setText(findTestObject('Object Repository/Claim Intimation/ClaimantDetails/ClaimantPermanentAddress'), data['ClaimantAddress'])

WebUI.enhancedClick(findTestObject('Object Repository/Claim Intimation/ClaimantDetails/ProceedBtn'))

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

//****************************************Bank Details*******************************************

WebUI.waitForElementClickable(findTestObject('Object Repository/Claim Intimation/BankDetails/AccountNumber'), GlobalVariable.G_PageTimeout)

WebUI.setText(findTestObject('Object Repository/Claim Intimation/BankDetails/AccountNumber'), data['AccountNo'])

WebUI.setText(findTestObject('Object Repository/Claim Intimation/BankDetails/ConfirmAccountNumber'), data['AccountNo'])

WebUI.setText(findTestObject('Object Repository/Claim Intimation/BankDetails/IFSCCode'), data['IFSCCode'])

WebUI.enhancedClick(findTestObject('Object Repository/Claim Intimation/BankDetails/ProceedBtn'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Claim Intimation/BankDetails/AccountType'), GlobalVariable.G_PageTimeout)

//WebUI.waitForElementPresent(findTestObject('Object Repository/Claim Intimation/BankDetails/AccountType'), GlobalVariable.G_PageTimeout)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Claim Intimation/BankDetails/AccountType'), data['AccountType'], false)

WebUI.setText(findTestObject('Object Repository/Claim Intimation/BankDetails/AccountHolderName'), 'Satyam')

WebUI.enhancedClick(findTestObject('Object Repository/Claim Intimation/BankDetails/ProceedBtn'))

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

//***********************************Document Upload****************************************

WebUI.uploadFile(findTestObject('Object Repository/Claim Intimation/DocumentUpload/DeathCertificate'), data['Documents'])

WebUI.uploadFile(findTestObject('Object Repository/Claim Intimation/DocumentUpload/ClaimFormA'), data['Documents'])

WebUI.uploadFile(findTestObject('Object Repository/Claim Intimation/DocumentUpload/NomineeAadhaarID'), data['Documents'])

WebUI.uploadFile(findTestObject('Object Repository/Claim Intimation/DocumentUpload/NomineeBankPassbook'), data['Documents'])

WebUI.uploadFile(findTestObject('Object Repository/Claim Intimation/DocumentUpload/PolicyDocument'), data['Documents'])

WebUI.uploadFile(findTestObject('Object Repository/Claim Intimation/DocumentUpload/FIRCopy'), data['Documents'])

WebUI.uploadFile(findTestObject('Object Repository/Claim Intimation/DocumentUpload/PostMortemReport'), data['Documents'])

WebUI.uploadFile(findTestObject('Object Repository/Claim Intimation/DocumentUpload/HospitalRecords'), data['Documents'])

WebUI.uploadFile(findTestObject('Object Repository/Claim Intimation/DocumentUpload/Signature'), data['Documents'])

WebUI.uploadFile(findTestObject('Object Repository/Claim Intimation/DocumentUpload/ClaimFormB'), data['Documents'])

WebUI.uploadFile(findTestObject('Object Repository/Claim Intimation/DocumentUpload/NomineeNonAadharID'), data['Documents'])

WebUI.enhancedClick(findTestObject('Object Repository/Claim Intimation/DocumentUpload/ProceedBtn'))

WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

WebUI.delay(3)

WebUI.enhancedClick(findTestObject('Object Repository/Claim Intimation/SummaryPage/Checkbox1'))

WebUI.enhancedClick(findTestObject('Object Repository/Claim Intimation/SummaryPage/Checkbox2'))

WebUI.enhancedClick(findTestObject('Object Repository/Claim Intimation/SummaryPage/Checkbox3'))

WebUI.enhancedClick(findTestObject('Object Repository/Claim Intimation/SummaryPage/ProceedBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Claim Intimation/SummaryPage/ReferenceNumber'), GlobalVariable.G_PageTimeout)

WebUI.delay(2)

GlobalVariable.G_ReferenceNo = WebUI.getText(findTestObject('Object Repository/Claim Intimation/SummaryPage/ReferenceNumber'))

SS.capture("Reference_Number")

WebUI.delay(0.5)

WebUI.enhancedClick(findTestObject('Object Repository/Claim Intimation/SummaryPage/CloseBtn'))

WebUI.closeBrowser()
