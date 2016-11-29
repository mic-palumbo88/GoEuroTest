package com.projects.goeurotest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.function.Consumer;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class CityWriter {
	
	File file;
	String fileName=null;
	HSSFWorkbook workbook =null;
	HSSFSheet sheet =null;
	int rownum;
	
	CityWriter(String cityName) {
		  this.fileName=cityName;
		  this.file = new File(fileName+".csv");
		  this.workbook = new HSSFWorkbook();
		  this.sheet = workbook.createSheet(fileName);
		  this.rownum=0;
		  writeHeaders();
	}

	private void writeHeaders() {
		Row row = sheet.createRow(rownum++);
        int cellnum=0;
        //_id, name, type, latitude, longitude
        Cell cell = row.createCell(cellnum++);
        cell.setCellValue("_ID");
        cell = row.createCell(cellnum++);
        cell.setCellValue("Name");
        cell = row.createCell(cellnum++);
        cell.setCellValue("Type");
        cell = row.createCell(cellnum++);
        cell.setCellValue("GeoPosition (LAT,LONG)");
	}

	public void printOnFile(){		
		try {
			FileOutputStream out = new FileOutputStream(file);
			workbook.write(out);
			out.close();
			System.out.println("Excel written successfully and saved in: "+this.file.getAbsolutePath());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	   
	Consumer<Map.Entry<String, City>> printit = city -> {
	    	 
			 City c = city.getValue();
			 
			 System.out.println("\n========================================");
	         System.out.println("city _ID is: " + c.getId());
	         System.out.println("city Name is: " + c.getName());
	         System.out.println("city Full Name is: " + c.getFullName());
	         System.out.println();
	         
	         Row row = sheet.createRow(rownum++);
	         int cellnum=0;
	         //_id, name, type, latitude, longitude
	         Cell cell = row.createCell(cellnum++);
	         cell.setCellValue(c.getId());
	         cell = row.createCell(cellnum++);
	         cell.setCellValue(c.getName());
	         cell = row.createCell(cellnum++);
	         cell.setCellValue(c.getType());
	         cell = row.createCell(cellnum++);
	         cell.setCellValue(c.getGeoPosition().getLatitute()+" , "+c.getGeoPosition().getLongitude());
	         
	    };
}
