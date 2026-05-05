
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import com.kms.katalon.core.testobject.TestObject



def static "methods.CaptureScreenshot.capture"(
    	String pageName	) {
    (new methods.CaptureScreenshot()).capture(
        	pageName)
}


def static "methods.CaptureScreenshot.screenshotDir"(
    	String tcID	) {
    (new methods.CaptureScreenshot()).screenshotDir(
        	tcID)
}


def static "methods.WriteExcel.writeReportRow"(
    	String policyNumber	) {
    (new methods.WriteExcel()).writeReportRow(
        	policyNumber)
}


def static "methods.WriteExcel.writeDataPoint"(
    	String policyNumber	
     , 	String testcaseDescription	
     , 	String dateofDeath	
     , 	String causeofDeath	
     , 	String dateofAccident	) {
    (new methods.WriteExcel()).writeDataPoint(
        	policyNumber
         , 	testcaseDescription
         , 	dateofDeath
         , 	causeofDeath
         , 	dateofAccident)
}


def static "methods.BrowserPermissions.openChromeWithOptions"() {
    (new methods.BrowserPermissions()).openChromeWithOptions()
}


def static "methods.BrowserPermissions.shrilifePermission"() {
    (new methods.BrowserPermissions()).shrilifePermission()
}


def static "methods.createExcel.generateReport"() {
    (new methods.createExcel()).generateReport()
}


def static "methods.createExcel.createDataPointSheet"() {
    (new methods.createExcel()).createDataPointSheet()
}


def static "methods.select_Date.selectCurrentDate"() {
    (new methods.select_Date()).selectCurrentDate()
}


def static "eft.getPRF.downloadPRF"(
    	String policyNo	) {
    (new eft.getPRF()).downloadPRF(
        	policyNo)
}


def static "methods.CaptureValues.getDataPointValues"() {
    (new methods.CaptureValues()).getDataPointValues()
}


def static "utils.PdfDownloader.downloadPdfWithSession"(
    	String fileUrl	
     , 	String savePath	) {
    (new utils.PdfDownloader()).downloadPdfWithSession(
        	fileUrl
         , 	savePath)
}


def static "methods.ECP_Calculation_test.verifyDataPoints"() {
    (new methods.ECP_Calculation_test()).verifyDataPoints()
}


def static "methods.ECP_Calculation_test.additions"() {
    (new methods.ECP_Calculation_test()).additions()
}


def static "methods.ECP_Calculation_test.deductions"() {
    (new methods.ECP_Calculation_test()).deductions()
}


def static "methods.ModalFactor.getModalFactor"() {
    (new methods.ModalFactor()).getModalFactor()
}


def static "calendar.DateSelector.selectTodayDate"(
    	TestObject dateFieldObject	) {
    (new calendar.DateSelector()).selectTodayDate(
        	dateFieldObject)
}


def static "methods.Calculation.verifyDataPoints"() {
    (new methods.Calculation()).verifyDataPoints()
}


def static "methods.Calculation.matchValues"(
    	Object basicDeathClaim	
     , 	Object abRiderPayable	
     , 	Object fibRiderPayable	
     , 	Object stepRiderPayable	) {
    (new methods.Calculation()).matchValues(
        	basicDeathClaim
         , 	abRiderPayable
         , 	fibRiderPayable
         , 	stepRiderPayable)
}


def static "methods.Calculation.additions"() {
    (new methods.Calculation()).additions()
}


def static "methods.Calculation.deductions"() {
    (new methods.Calculation()).deductions()
}

 /**
	 * Clicks the required EFT checkbox, detects the newly downloaded Excel file in downloadPath,
	 * and moves it to GlobalVariable.screenshotDir (or any target you set).
	 *
	 * @param EFT_Required visible text or data binding used by your TestObject parameterization
	 * @param waitSeconds max seconds to wait for a new file to appear (default 20)
	 * @return Path of the moved file (as String), or null if not found
	 */ 
def static "eft.file.getEftFile"(
    	String EFT_Required	
     , 	int waitSeconds	) {
    (new eft.file()).getEftFile(
        	EFT_Required
         , 	waitSeconds)
}


def static "eft.file.getEftFile"(
    	String EFT_Required	) {
    (new eft.file()).getEftFile(
        	EFT_Required)
}


def static "methods.FetchExcelData.getData"(
    	String sheetName	
     , 	String testcaseID	) {
    (new methods.FetchExcelData()).getData(
        	sheetName
         , 	testcaseID)
}


def static "methods.FetchExcelData.getModalFactor"(
    	String sheetName	
     , 	String planName	) {
    (new methods.FetchExcelData()).getModalFactor(
        	sheetName
         , 	planName)
}


def static "methods.FetchExcelData.getDataPoint"(
    	String sheetName	
     , 	String testcaseID	) {
    (new methods.FetchExcelData()).getDataPoint(
        	sheetName
         , 	testcaseID)
}
