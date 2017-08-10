package com.ctli.it.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils {
	
private	static Properties prop;
	
	
	static private void readFeatureInputFromExcelFile(Properties simonProp) {
		String pathName = null;
		String fileName = null;
		String tabName = null;
		System.out.println(prop.getProperty("FeatureInput")+"featureinput");
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
		 prop.put("FeatureInput", "ReadingExcel.xlsx");
		 prop.put("FeatureTab", "TEST");
		readFeatureInputFromExcelFile(prop);
	}
	
	
	public static  Properties getPropertiesValue()
	{
		return prop;
		
		
	}
	
	
	public static void WriteInsertResultToExcel2( Properties superFinalResult, String ResultTab)
			throws  IOException {
		ArrayList<String> al=new ArrayList<String>();
		String pathName = prop.getProperty("FeatureInputDirectory");
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String fileName = "Demower" + ".xlsx";
		String tabName = ResultTab;
		XSSFRow row;
		XSSFWorkbook workbook = null;
		boolean newSheet = false;
		try {
			Path pHome = Paths.get(pathName, fileName);
			String sFileToWrite = pHome.toString();
			File file = new File(sFileToWrite);
			if (file.exists()) {
				FileInputStream fileOut = new FileInputStream(sFileToWrite);
				workbook = (XSSFWorkbook) WorkbookFactory.create(fileOut);
				int noofsheet = workbook.getNumberOfSheets();
				System.out.println(noofsheet);
				int count1=0;
				for(int k=0;k<noofsheet;k++)
				{
					al.add(workbook.getSheetName(k));
					count1++;
					if(al.get(k).equals(tabName))
					{
						System.out.println("Existing sheet");
						//newSheet = true;
						break;
						
					}
					
					else if(count1==noofsheet)
					{
						newSheet = true;
						
					}
					
				}
			} else {
				workbook = new XSSFWorkbook();
				newSheet = true;
			}
			
			

			int rowid = 0;
			Set keySet = superFinalResult.keySet();
			Object[] keys = keySet.toArray();
			
			System.out.println(keys.length+"length");

			// add headers
			if (newSheet) {
				XSSFSheet spreadsheet = workbook.createSheet(tabName);
				row = spreadsheet.createRow(rowid++);
				boolean flag=true;
				for (int i = 0; i < keys.length; i++) {
					if (i == 0) {
						String sKey = (String) keys[i];
						row.createCell(i).setCellValue((String) sKey);
					} else {
						String sKey = (String) keys[i];
						row.createCell(i).setCellValue((String) sKey);
					}
				}
				// add data
				row = spreadsheet.createRow(rowid++);
				for (int i = 0; i < keys.length; i++) {
					if (i == 0) {
						String sKey = (String) keys[i];
						String value = superFinalResult.getProperty(sKey);
						row.createCell(i).setCellValue(value);
					} else {
						String sKey = (String) keys[i];
						String value = superFinalResult.getProperty(sKey);
						row.createCell(i).setCellValue(value);
					}
				}
			} else {

				// append data
				XSSFSheet spreadsheet = workbook.getSheet(tabName);
				row = spreadsheet.createRow(spreadsheet.getLastRowNum() + 1);
				for (int i = 0; i < keys.length; i++) {
					if (i == 0) {
						String sKey = (String) keys[i];
						String value = superFinalResult.getProperty(sKey);
						row.createCell(i).setCellValue(value);
					} else {
						String sKey = (String) keys[i];
						String value = superFinalResult.getProperty(sKey);
						row.createCell(i).setCellValue(value);
					}

				}
			}

			FileOutputStream fileOut = new FileOutputStream(sFileToWrite);
			workbook.write(fileOut);
			fileOut.flush();
			workbook.close();
			fileOut.close();

		} catch (Exception e) {
			System.out.println("InsertData failed. Write result data to excel failed. Please check.");
			e.printStackTrace();
		//	throw new InsertDataException("InsertData failed. Write result data to excel failed. Please check.");
		} finally {
			workbook.close();
		}
	}
	

}
