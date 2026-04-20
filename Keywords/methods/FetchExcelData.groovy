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

import internal.GlobalVariable
//import com.kms.katalon.core.testdata.TestDataFactory
import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFWorkbook
//import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testdata.reader.ExcelFactory

public class FetchExcelData {

	@Keyword
	static Map<String, String> getData(String sheetName, String testcaseID) {
		FileInputStream fis = new FileInputStream(new File(GlobalVariable.G_testDataPath))
		Workbook workbook = new XSSFWorkbook(fis)
		Sheet sheet = workbook.getSheet(sheetName)

		Map<String, String> rowData = [:]
		Row headerRow = sheet.getRow(0)
		int colCount = headerRow.getLastCellNum()

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i)
			if (row.getCell(0).getStringCellValue() == testcaseID) {
				for (int j = 0; j < colCount; j++) {
					String colName = headerRow.getCell(j).getStringCellValue()
					String value = row.getCell(j)?.toString()
					rowData[colName] = value
				}
				break
			}
		}
		workbook.close()
		return rowData
	}

	@Keyword
	static Map<String, String> getModalFactor(String sheetName, String planName) {
		FileInputStream fis = new FileInputStream(new File(GlobalVariable.G_testDataPath))
		Workbook workbook = new XSSFWorkbook(fis)
		Sheet sheet = workbook.getSheet(sheetName)

		Map<String, String> rowData = [:]
		Row headerRow = sheet.getRow(0)
		int colCount = headerRow.getLastCellNum()

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i)
			if (row.getCell(0).getStringCellValue() == planName) {
				for (int j = 0; j < colCount; j++) {
					String colName = headerRow.getCell(j).getStringCellValue()
					String value = row.getCell(j)?.toString()
					rowData[colName] = value
				}
				break
			}
		}
		workbook.close()
		return rowData
	}

	@Keyword
	static Map<String, String> getDataPoint(String sheetName, String testcaseID) {

		def filePath = GlobalVariable.G_ReportPath + "${GlobalVariable.G_Date}/${GlobalVariable.G_PlanName}/Data_Points.xlsx"
		FileInputStream fis = new FileInputStream(new File(filePath))
		Workbook workbook = new XSSFWorkbook(fis)
		Sheet sheet = workbook.getSheet(sheetName)

		Map<String, String> rowData = [:]
		Row headerRow = sheet.getRow(0)
		int colCount = headerRow.getLastCellNum()

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i)
			if (row.getCell(0).getStringCellValue() == testcaseID) {
				for (int j = 0; j < colCount; j++) {
					String colName = headerRow.getCell(j).getStringCellValue()
					String value = row.getCell(j)?.toString()
					rowData[colName] = value
				}
				break
			}
		}
		workbook.close()
		return rowData
	}
}
