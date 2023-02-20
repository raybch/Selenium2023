package utils;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.poi.ss.usermodel.*;

import javax.naming.ConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class FileOperations {

	/**
	 * @param filePath
	 * @param key
	 * @return
	 */
	public static String getConfigValue(String filePath, String key) {
		String keyValue = null;
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(filePath));
			keyValue = prop.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return keyValue;
	}

	/**
	 * @param filePath
	 * @param key
	 * @param value
	 * @throws IOException
	 * @throws ConfigurationException
	 * @throws org.apache.commons.configuration.ConfigurationException
	 */
	public static void updateConfigValue(String filePath, String key, String value)
			throws IOException, ConfigurationException, org.apache.commons.configuration.ConfigurationException {

		PropertiesConfiguration config = new PropertiesConfiguration(filePath);
		config.setProperty(key, value);
		config.save();
	}

	@SuppressWarnings("deprecation")
	public static String readColumnValueUsingKeyFromExcel(String filePath, String fileName, String sheetName,
														  String keyName) {
		File file = new File(filePath + File.separator + fileName);
		String value = null;
		FileInputStream inputStream;
		Workbook workbook = null;
		Row row = null;

		try {
			inputStream = new FileInputStream(file);
			workbook = WorkbookFactory.create(inputStream);
		} catch (Exception e) {

		}
		Sheet sheet = workbook.getSheet(sheetName);
		Row firstRow = sheet.getRow(0);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		for (int i = 1; i <= rowCount; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < firstRow.getLastCellNum(); j++) {
				if (row.getCell(j).getStringCellValue().equals(keyName)) {
					row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
					if (!row.getCell(j).getStringCellValue().trim().equals("")) {
						if (firstRow.getCell(j).getStringCellValue() != null) {
							Cell cell = row.getCell(j + 1);
							switch (cell.getCellType()) {
								case Cell.CELL_TYPE_STRING:
									value = cell.getRichStringCellValue().getString();
									break;
								case Cell.CELL_TYPE_NUMERIC:
									value = Integer.toString(((int) cell.getNumericCellValue()));
									break;
							}

							break;
						}
					}
				} else
					break;
			}

		}

		return value;

	}

	public static HashMap<String, String> getListFromExcel(String filePath, String fileName, String sheetName) {
		File file = new File(filePath + File.separator + fileName);
		String value = null;
		FileInputStream inputStream;
		Workbook workbook = null;
		Row row = null;
		HashMap<String, String> map = new HashMap<String, String>();
		try {
			inputStream = new FileInputStream(file);
			workbook = WorkbookFactory.create(inputStream);
		} catch (Exception e) {

		}
		Sheet sheet = workbook.getSheet(sheetName);
		Row firstRow = sheet.getRow(0);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		for (int i = 1; i <= rowCount; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < firstRow.getLastCellNum(); j++) {
					row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
					if (!row.getCell(j).getStringCellValue().trim().equals("")) {
						if (firstRow.getCell(j).getStringCellValue() != null) {
							Cell cell = row.getCell(j + 1);
							switch (cell.getCellType()) {
								case Cell.CELL_TYPE_STRING:
									value = cell.getRichStringCellValue().getString();
									map.put(row.getCell(j).getStringCellValue(), value);
									break;
								case Cell.CELL_TYPE_NUMERIC:
									value = Integer.toString(((int) cell.getNumericCellValue()));
									map.put(row.getCell(j).getStringCellValue(), value);
									break;
							}
							break;
						}
					}
				}

		}
		return map;
	}


	public static void cleanDir(String dirName) {
		File directory = new File(dirName);

		// Get all files in directory
		File[] files = directory.listFiles();
		for (File file : files) {
			// Delete each file
			if (!file.delete()) {
				// Failed to delete file
				System.out.println("Failed to delete " + file);
			}
		}
	}

}
