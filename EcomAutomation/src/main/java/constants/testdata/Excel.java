package constants.testdata;

import constants.path.Path;
import utils.FileOperations;

public interface Excel {

	// EXCEL TEST DATA
	String FIRST_NAME = getExcelData("FirstName");
	String LAST_NAME = getExcelData("LastName");
	String ADDRESS = getExcelData("Address");
	String CITY = getExcelData("City");
	String ZIPCODE = getExcelData("Zipcode");
	String PHONE = getExcelData("Phone");

	// METHODS
	/*
	 * Read Excel Data
	 */
	
	public static String getExcelData(String key) {
		return FileOperations.readColumnValueUsingKeyFromExcel(Path.TESTDATA_PATH, "ExcelTestData.xlsx", "Details", key);
	}
}
