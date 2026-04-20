import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

import methods.FetchExcelData
import methods.WriteExcel

class ExecutionListener {
	
	long startTime
	
	@BeforeTestCase
	def setGlobalVariablesBeforeEachCase() {
		
		GlobalVariable.G_SSCount = 1
		GlobalVariable.G_ScreenshotDir = "E:/Death Screenshots/"
		GlobalVariable.G_ReferenceNo = ""
		GlobalVariable.G_TestCaseID = ""
		GlobalVariable.G_Status = ""
		GlobalVariable.G_ExecutionTime = ""
		GlobalVariable.G_PlanName = ""
		GlobalVariable.G_LaDOB = ""
		GlobalVariable.G_Age = ""
		GlobalVariable.G_Gender = ""
		GlobalVariable.G_DOC = ""
		GlobalVariable.G_SumAssured = ""
		GlobalVariable.G_PaidUpSA = ""
		GlobalVariable.G_PolicyTerm = ""
		GlobalVariable.G_PremiumTerm = ""
		GlobalVariable.G_Mode = ""
		GlobalVariable.G_InstallmentPremium = ""
		GlobalVariable.G_RiderPremium = ""
		GlobalVariable.G_ExtraPremium = ""
		GlobalVariable.G_BasicPremium = ""
		GlobalVariable.G_AB_Rider_SA = ""
		GlobalVariable.G_FIB_Rider_SA = ""
		GlobalVariable.G_InstallmentNumber = ""
		GlobalVariable.G_FUP = ""
		GlobalVariable.G_DivisionName = ""
		GlobalVariable.G_Interim_Bonus = "0"
		GlobalVariable.G_Unpaid_SB = ""
		GlobalVariable.G_Outstanding_Deposit = ""
		GlobalVariable.G_Disability_Benefit = ""
		GlobalVariable.G_Fund_Value_Interest = ""
		GlobalVariable.G_Advance_Premium_Deposit = ""
		GlobalVariable.G_Unclaimed_Amount = ""
		GlobalVariable.G_Reversal_Charges = ""
		GlobalVariable.G_Outstanding_Premium_Due = ""
		GlobalVariable.G_Outstanding_Premium_Interest = ""
		GlobalVariable.G_Interest_on_Difference_Premium = ""
		GlobalVariable.G_LoanAmount = ""
		GlobalVariable.G_LoanInterest = ""
		GlobalVariable.G_Balance_Premium = ""
		GlobalVariable.G_XCharge = ""
		GlobalVariable.G_Survival_Benefit_Paid = ""
		GlobalVariable.G_NB_Conversion_Amount = ""
		GlobalVariable.G_Basic_Death_Claim = ""
		GlobalVariable.G_Net_Payable_Amount = ""
		GlobalVariable.G_USER = ""
		GlobalVariable.G_EIC_Rider_SA = ""
		GlobalVariable.G_STEPUP_Rider_SA = ""
		GlobalVariable.G_StepUp_Rider_Amount = ""
		GlobalVariable.G_AB_Rider_Amount = ""
		GlobalVariable.G_FIB_Rider_Amount = ""
		GlobalVariable.G_Annualized_Premium = ""
		GlobalVariable.G_Calculation_Status = ""
		GlobalVariable.G_Calculation_Remarks = ""
		GlobalVariable.G_Vested_Bonus = "0"
		startTime = System.currentTimeMillis()

	}
	
	
	@AfterTestCase
	def afterCase(TestCaseContext testCaseContext) {
		
		Map flag = FetchExcelData.getData("Death", GlobalVariable.G_TestCaseID)
		if(flag['Executor'].toString().equalsIgnoreCase("Yes")) {
			GlobalVariable.G_Status = testCaseContext.getTestCaseStatus()
			long endTime = System.currentTimeMillis()
			long elapsedTime = (endTime - startTime) / 1000
			
			long minutes = elapsedTime / 60
			long seconds = elapsedTime % 60
			
			GlobalVariable.G_ExecutionTime = "${minutes} min ${seconds} sec"
			
			WriteExcel.writeReportRow(flag['PolicyNumber'])	
		}
			
	}
	
}