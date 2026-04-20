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
import java.nio.file.*

import internal.GlobalVariable

public class createExcel {

	@Keyword
	static def generateReport() {

		// Define file path
		def filePath = GlobalVariable.G_ReportPath + "${GlobalVariable.G_Date}/Test_Report.xlsx"
		def file = new File(filePath)

		// Create directory if not exists
		file.parentFile.mkdirs()

		if (!file.exists()) {

			// Create workbook and sheet
			def workbook = new XSSFWorkbook()
			def sheet = workbook.createSheet("Report")

			// Create header style
			def headerFont = workbook.createFont()
			headerFont.setBold(true)
			headerFont.setColor(IndexedColors.WHITE.getIndex())

			def headerStyle = workbook.createCellStyle()
			headerStyle.setFont(headerFont)
			headerStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex())
			headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND)

			// Create header row
			def headers = [
				"TestCase_ID",
				"Policy_Number",
				"Status",
				"Date & Time",
				"Execution_Duration"
			]
			def headerRow = sheet.createRow(0)
			headers.eachWithIndex { header, idx ->
				def cell = headerRow.createCell(idx)
				cell.setCellValue(header)
				cell.setCellStyle(headerStyle)
			}

			// Auto-size columns for better readability
			headers.size().times { sheet.autoSizeColumn(it) }

			// Write workbook to file
			def outputStream = new FileOutputStream(file)
			workbook.write(outputStream)
			outputStream.close()
			workbook.close()

			println "Excel report generated at: ${filePath}"
		}
	}


	@Keyword
	static def createDataPointSheet() {

		// Define file path
		def filePath = GlobalVariable.G_ReportPath + "${GlobalVariable.G_Date}/${GlobalVariable.G_PlanName}/Data_Points.xlsx"
		def file = new File(filePath)

		// Create directory if not exists
		file.parentFile.mkdirs()

		if (!file.exists()) {

			// Create workbook and sheet
			def workbook = new XSSFWorkbook()
			def sheet = workbook.createSheet("DataPoint")

			// Create header style
			def headerFont = workbook.createFont()
			headerFont.setBold(true)
			headerFont.setColor(IndexedColors.WHITE.getIndex())

			def headerStyle = workbook.createCellStyle()
			headerStyle.setFont(headerFont)
			headerStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex())
			headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND)

			// Create header row
			def headers = [
				"TestCase_ID",
				"TestCase_Description",
				"Policy_Number",
				"Plan_Name",
				"LA_DOB",
				"LA_Age",
				"LA_Gender",
				"Commencement_Date",
				"Base_SA",
				"PaidUP_SA",
				"Policy_Term",
				"Premium_Term",
				"Frequency",
				"Installment_Premium",
				"Rider_Premium",
				"Extra_Premium",
				"Basic_Premium",
				"Annualized_Premium",
				"AB_Rider_SA",
				"FIB_Rider_SA",
				"EIC_Rider_SA",
				"StepUP_Rider_SA",
				"No_of_Installment_Paid",
				"FUP_Date",
				"DO_Name",
				"Date_of_Death",
				"Date_of_Accident",
				"Cause_of_Death",
				"Interim_Bonus",
				"Vested_Bonus",
				"Add_Unpaid_SB",
				"Add_Outstanding_Deposit",
				"Add_Disability_Benefit",
				"Add_Fund_Value_Interest",
				"Add_Advance_Premium_Deposit",
				"Add_Unclaimed_Amount",
				/*"Add_Reversal_Charges",*/
				"Ded_Outstanding_Premium_Due",
				"Ded_Outstanding_Premium_Due_Interest",
				"Ded_Interest_on_Difference_Premium",
				"Ded_Loan_Amount",
				"Ded_Loan_Interest",
				"Ded_Balance_Premium",
				"Ded_Xcharge",
				"Ded_SB_Paid_After_Death",
				"Ded_NB_Conversion_Amount",
				"AB_Rider_Payable_Amount",
				"FIB_Rider_Payable_Amount",
				"EIC_Rider_Payable_Amount",
				"StepUP_Rider_Payable_Amount",
				"Basic_Death_Claim",
				"Net_Payable_Amount",
				"Calculation_Status",
				"Calculation_Remarks_for_Payable_Amount"
			]
			def headerRow = sheet.createRow(0)
			headers.eachWithIndex { header, idx ->
				def cell = headerRow.createCell(idx)
				cell.setCellValue(header)
				cell.setCellStyle(headerStyle)
			}

			// Auto-size columns for better readability
			headers.size().times { sheet.autoSizeColumn(it) }

			// Write workbook to file
			def outputStream = new FileOutputStream(file)
			workbook.write(outputStream)
			outputStream.close()
			workbook.close()

			println "Excel report generated at: ${filePath}"
		}
	}
}
