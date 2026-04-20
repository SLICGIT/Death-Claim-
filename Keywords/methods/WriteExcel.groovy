package methods

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows


import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.common.usermodel.HyperlinkType

import internal.GlobalVariable

public class WriteExcel {

	@Keyword
	static def writeReportRow(String policyNumber) {

		def filePath = GlobalVariable.G_ReportPath + "${GlobalVariable.G_Date}/Test_Report.xlsx"
		def file = new File(filePath)

		//	file.parentFile.mkdirs() // Ensure directory exists

		// Open existing workbook
		def inputStream = new FileInputStream(file)
		Workbook workbook = new XSSFWorkbook(inputStream)
		//	def sheet = workbook.getSheet("Report")
		inputStream.close()

		def sheet = workbook.getSheet("Report")
		if (sheet == null) {
			sheet = workbook.createSheet("Report")
		}

		// Prepare data row

		def nextRowIndex = (sheet.getLastRowNum() == 0 && sheet.getRow(0) == null) ? 0 : sheet.getLastRowNum() + 1
		def row = sheet.createRow(nextRowIndex)

		def data = [
			GlobalVariable.G_TestCaseID,
			policyNumber,
			GlobalVariable.G_Status,
			GlobalVariable.G_Date + "_" + GlobalVariable.G_Time,
			GlobalVariable.G_ExecutionTime
		]
		data.eachWithIndex { value, idx ->
			row.createCell(idx).setCellValue(value ?: "")
		}

		// Save workbook
		def outputStream = new FileOutputStream(file)
		workbook.write(outputStream)
		outputStream.close()
		workbook.close()

		println "Row appended successfully to: ${filePath}"
	}


	//	@Keyword
	//	static def writeDataPoint(String policyNumber) {
	//
	//		def filePath = GlobalVariable.G_ReportPath + "${GlobalVariable.G_Date}/${GlobalVariable.G_PlanName}/Data_Points.xlsx"
	//		def file = new File(filePath)
	//
	//		//	file.parentFile.mkdirs() // Ensure directory exists
	//
	//		// Open existing workbook
	//		def inputStream = new FileInputStream(file)
	//		Workbook workbook = new XSSFWorkbook(inputStream)
	//		//	def sheet = workbook.getSheet("Report")
	//		inputStream.close()
	//
	//		def sheet = workbook.getSheet("Report")
	//		if (sheet == null) {
	//			sheet = workbook.createSheet("Report")
	//		}
	//
	//		// Prepare data row
	//
	//		def nextRowIndex = (sheet.getLastRowNum() == 0 && sheet.getRow(0) == null) ? 0 : sheet.getLastRowNum() + 1
	//		def row = sheet.createRow(nextRowIndex)
	//
	//		def data = [
	//			GlobalVariable.G_TestCaseID,
	//			policyNumber,
	//			GlobalVariable.G_PlanName,
	//			GlobalVariable.G_LaDOB,
	//			GlobalVariable.G_Age,
	//			GlobalVariable.G_Gender,
	//			GlobalVariable.G_DOC,
	//			GlobalVariable.G_SumAssured,
	//			GlobalVariable.G_PaidUpSA,
	//			GlobalVariable.G_PolicyTerm,
	//			GlobalVariable.G_PremiumTerm,
	//			GlobalVariable.G_Mode,
	//			GlobalVariable.G_InstallmentPremium,
	//			GlobalVariable.G_RiderPremium,
	//			GlobalVariable.G_ExtraPremium,
	//			GlobalVariable.G_InstallmentNumber,
	//			GlobalVariable.G_FUP,
	//			GlobalVariable.G_DivisionName
	//		]
	//		data.eachWithIndex { value, idx ->
	//			row.createCell(idx).setCellValue(value ?: "")
	//		}
	//
	//		// Save workbook
	//		def outputStream = new FileOutputStream(file)
	//		workbook.write(outputStream)
	//		outputStream.close()
	//		workbook.close()
	//
	//		println "Row appended successfully to: ${filePath}"
	//	}



	@Keyword
	static def writeDataPoint(String policyNumber, String testcaseDescription, String dateofDeath, String causeofDeath, String dateofAccident) {

		String filePath = GlobalVariable.G_ReportPath + "${GlobalVariable.G_Date}/${GlobalVariable.G_PlanName}/Data_Points.xlsx"

		File file = new File(filePath)

		// ✅ ENSURE DIRECTORY EXISTS
		file.parentFile.mkdirs()

		Workbook workbook
		Sheet sheet

		// ✅ CREATE or OPEN WORKBOOK
		if (file.exists()) {
			FileInputStream fis = new FileInputStream(file)
			workbook = new XSSFWorkbook(fis)
			fis.close()
		} else {
			workbook = new XSSFWorkbook()
		}

		// ✅ GET or CREATE SHEET
		sheet = workbook.getSheet("DataPoint")
		if (sheet == null) {
			sheet = workbook.createSheet("DataPoint")
		}

		// ✅ APPEND ROW SAFELY
		int nextRowIndex = sheet.getLastRowNum() + 1
		Row row = sheet.createRow(nextRowIndex)

		def data = [
			GlobalVariable.G_TestCaseID,
			testcaseDescription,
			policyNumber,
			GlobalVariable.G_PlanName,
			GlobalVariable.G_LaDOB,
			GlobalVariable.G_Age,
			GlobalVariable.G_Gender,
			GlobalVariable.G_DOC,
			GlobalVariable.G_SumAssured,
			GlobalVariable.G_PaidUpSA,
			GlobalVariable.G_PolicyTerm,
			GlobalVariable.G_PremiumTerm,
			GlobalVariable.G_Mode,
			GlobalVariable.G_InstallmentPremium,
			GlobalVariable.G_RiderPremium,
			GlobalVariable.G_ExtraPremium,
			GlobalVariable.G_BasicPremium,
			GlobalVariable.G_Annualized_Premium,
			GlobalVariable.G_AB_Rider_SA,
			GlobalVariable.G_FIB_Rider_SA,
			GlobalVariable.G_EIC_Rider_SA,
			GlobalVariable.G_STEPUP_Rider_SA,
			GlobalVariable.G_InstallmentNumber,
			GlobalVariable.G_FUP,
			GlobalVariable.G_DivisionName,
			dateofDeath,
			dateofAccident,
			causeofDeath,
			GlobalVariable.G_Interim_Bonus,
			GlobalVariable.G_Vested_Bonus,
			GlobalVariable.G_Unpaid_SB,
			GlobalVariable.G_Outstanding_Deposit,
			GlobalVariable.G_Disability_Benefit,
			GlobalVariable.G_Fund_Value_Interest,
			GlobalVariable.G_Advance_Premium_Deposit,
			GlobalVariable.G_Unclaimed_Amount,
			/*GlobalVariable.G_Reversal_Charges,*/
			GlobalVariable.G_Outstanding_Premium_Due,
			GlobalVariable.G_Outstanding_Premium_Interest,
			GlobalVariable.G_Interest_on_Difference_Premium,
			GlobalVariable.G_LoanAmount,
			GlobalVariable.G_LoanInterest,
			GlobalVariable.G_Balance_Premium,
			GlobalVariable.G_XCharge,
			GlobalVariable.G_Survival_Benefit_Paid,
			GlobalVariable.G_NB_Conversion_Amount,
			GlobalVariable.G_AB_Rider_Amount,
			GlobalVariable.G_FIB_Rider_Amount,
			GlobalVariable.G_EIC_Rider_Amount,
			GlobalVariable.G_StepUp_Rider_Amount,
			GlobalVariable.G_Basic_Death_Claim,
			GlobalVariable.G_Net_Payable_Amount,
			GlobalVariable.G_Calculation_Status,
			GlobalVariable.G_Calculation_Remarks
		]

		data.eachWithIndex { value, idx ->
			row.createCell(idx).setCellValue(value?.toString() ?: "")
		}

		// ✅ WRITE TO FILE
		FileOutputStream fos = new FileOutputStream(file)
		workbook.write(fos)
		fos.flush()
		fos.close()
		workbook.close()

		println "✅ Excel updated successfully -> ${filePath}"
	}
}
