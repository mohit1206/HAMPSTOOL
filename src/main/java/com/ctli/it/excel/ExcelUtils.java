package com.ctli.it.excel;

import java.util.Iterator;
import java.util.Properties;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class ExcelUtils {
	
private	static Properties prop;
	
	
	static private void readFeatureInputFromExcelFile(Properties simonProp) {
		String pathName = null;
		String fileName = null;
		String tabName = null;
		System.out.println(simonProp.getProperty("FeatureInput")+"featureinput");
		if (simonProp.getProperty("FeatureInputDirectory") != null && simonProp.getProperty("FeatureInput") != null
				&& simonProp.getProperty("FeatureTab") != null) {

			pathName = simonProp.getProperty("FeatureInputDirectory");
			fileName = simonProp.getProperty("FeatureInput");
			tabName = simonProp.getProperty("FeatureTab");
		}

		if (pathName != null && fileName != null && tabName != null) {
			Path pHome = Paths.get(pathName, fileName);
			String excelFilePath = pHome.toString();
			try {
				FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

				Workbook workbook = new XSSFWorkbook(inputStream);
				readFeatureInputTabFromExcelFile(simonProp, workbook, tabName);
				//readFeatureInputTabFromExcelFile(simonProp, workbook, simonProp.getProperty("SimonEnvironment"));
				//readFeatureInputTabFromExcelFile(simonProp, workbook, simonProp.getProperty("DBEvironment"));

				workbook.close();
				inputStream.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	static private void readFeatureInputTabFromExcelFile(Properties simonProp, Workbook workbook, String tabName) {
		Sheet firstSheet = workbook.getSheet(tabName);
		Iterator<Row> iterator = firstSheet.iterator();

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			simonProp.put(nextRow.getCell(0).getStringCellValue(), nextRow.getCell(1).getStringCellValue());
		}
	}
	public static void setPropertiesValue()
	{
		prop=new Properties();
		String afgg = System.getProperty("user.dir")+"/src/test/resources";
		System.out.println(afgg);
		
		 prop.put("FeatureInputDirectory", afgg);
		 prop.put("FeatureInput", "Demo.xlsx");
		 prop.put("FeatureTab", "TEST");
		readFeatureInputFromExcelFile(prop);
	}
	
	
	public static  Properties getPropertiesValue()
	{
		return prop;
		
		
	}
	

}
