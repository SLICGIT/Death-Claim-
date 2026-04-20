package eft

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.util.concurrent.TimeUnit
import javax.swing.JOptionPane as JOptionPane

class file {

	/**
	 * Clicks the required EFT checkbox, detects the newly downloaded Excel file in downloadPath,
	 * and moves it to GlobalVariable.screenshotDir (or any target you set).
	 *
	 * @param EFT_Required visible text or data binding used by your TestObject parameterization
	 * @param waitSeconds max seconds to wait for a new file to appear (default 20)
	 * @return Path of the moved file (as String), or null if not found
	 */
	@Keyword
	static String getEftFile(String EFT_Required, int waitSeconds = 20) {

		// --- Directories from GlobalVariables ---
		String DOWNLOAD_DIR = GlobalVariable.G_DownloadPath
		String TARGET_DIR   = GlobalVariable.G_ScreenshotDir    // change if needed

		// --- Null/Existence checks ---
		if (DOWNLOAD_DIR == null || DOWNLOAD_DIR.trim().isEmpty()) {
			WebUI.comment("DOWNLOAD_DIR is not set in GlobalVariables")
			return null
		}
		if (TARGET_DIR == null || TARGET_DIR.trim().isEmpty()) {
			WebUI.comment("TARGET_DIR is not set in GlobalVariables (screenshotDir)")
			return null
		}

		File downloadFolder = new File(DOWNLOAD_DIR)
		if (!downloadFolder.exists()) {
			WebUI.comment("Download folder does not exist: ${DOWNLOAD_DIR}")
			return null
		}

		// --- Snapshot BEFORE download (Excel only) ---
		Set<String> beforeFiles = listExcelFileNames(downloadFolder) as Set<String>

		// --- Perform UI action that triggers download ---
		WebUI.enhancedClick(findTestObject('shrilifeadmission/eftProcess/eftGeneration/checkList'))

		JOptionPane.showMessageDialog(null, 'Click OK to continue')
		//		WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)
		//
		//		WebUI.delay(2)

		// afterFiles and beforeFiles are lists of file names from the directory
		List<String> afterFiles = new File(DOWNLOAD_DIR).list() as List
		beforeFiles = beforeFiles ?: [] // ensure not null
		// Find new files (.xls only)
		Set<String> newFiles = (afterFiles.toSet() - beforeFiles.toSet())
				.findAll { it?.toLowerCase()?.endsWith(".xls") } as Set<String>

		if (!newFiles.isEmpty()) {
			String xlsFile = newFiles[0] // Assuming only one new .xls file
			Path source = Paths.get("${DOWNLOAD_DIR}/${xlsFile}")
			Path target = Paths.get("${GlobalVariable.G_ScreenshotDir}/${xlsFile}")

			// Ensure target directory exists
			Files.createDirectories(target.getParent())

			// Move file (replace if exists)
			Files.move(source, target, StandardCopyOption.REPLACE_EXISTING)
			println "File moved: ${xlsFile}"
		} else {
			println "No new .xls files found to move."
		}







		//		// --- Wait for a new Excel file to appear ---
		//		String newFileName = waitForNewExcel(downloadFolder, beforeFiles, waitSeconds)
		//		if (newFileName == null) {
		//			WebUI.comment("No new Excel file detected within ${waitSeconds}s")
		//			return null
		//		}
		//
		//		// --- Optional: wait briefly for file to finish writing (no .crdownload/temp growth) ---
		//		waitForFileStability(new File(downloadFolder, newFileName), 2, 500)
		//
		//		// --- Ensure target directory exists ---
		//		Files.createDirectories(Paths.get(TARGET_DIR))
		//
		//		// --- Move file ---
		//		Path source = Paths.get(DOWNLOAD_DIR, newFileName)
		//		Path target = Paths.get(TARGET_DIR, newFileName)
		//		Files.move(source, target, StandardCopyOption.REPLACE_EXISTING)
		//
		//		WebUI.comment("File moved: ${newFileName} -> ${target.toString()}")
		//		return target.toString()
	}

	// ---------- Helpers ----------

	private static List<String> listExcelFileNames(File folder) {
		String[] arr = folder.list({ dir, name ->
			name?.toLowerCase()?.endsWith('.xlsx') || name?.toLowerCase()?.endsWith('.xls')
		} as FilenameFilter)
		return (arr == null) ? [] : Arrays.asList(arr)
	}

	private static String waitForNewExcel = { File folder, Set<String> before, int waitSeconds ->
		long start = System.currentTimeMillis()
		long timeoutMs = TimeUnit.SECONDS.toMillis(waitSeconds)

		while (System.currentTimeMillis() - start < timeoutMs) {
			List<String> current = listExcelFileNames(folder)
			Set<String> diff = (current as Set<String>) - before
			if (!diff.isEmpty()) {
				// Return the first new file
				return diff.iterator().next()
			}
			sleep(500)
		}
		return null
	}

	/**
	 * Ensures the file size is stable across a couple of checks.
	 * Useful when browsers write files progressively.
	 */
	private static void waitForFileStability(File file, int checks = 2, long intervalMs = 500) {
		long lastSize = -1
		int stableCount = 0
		for (int i = 0; i < 20 && stableCount < checks; i++) {
			// hard cap to avoid long waits
			if (!file.exists()) {
				sleep(intervalMs)
				continue
			}
			long size = file.length()
			if (size == lastSize && size > 0) {
				stableCount++
			} else {
				stableCount = 0
			}
			lastSize = size
			sleep(intervalMs)
		}
	}
}