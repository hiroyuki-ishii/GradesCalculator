package edu.gatech.seclass.gradescalculator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Grades {
	private Map<String,Grade> _gradeMap;
	
	public Grades(String gradesDb) throws IOException {
		_gradeMap = new HashMap<>();
		
		FileInputStream file;
		file = new FileInputStream(new File(gradesDb));
        
		//Get the workbook instance for XLS file 
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		//Get first sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(0);
		 
		//Get iterator to all the rows in Attendance sheet
		Iterator<Row> rowIterator = sheet.iterator();
		rowIterator.next(); // skip a header row
		DecimalFormat df = new DecimalFormat("#########");
		while(rowIterator.hasNext()) {
			Row row = (Row)rowIterator.next();
			String gtid = "";
			Double attendance = 0.0;
			//Get iterator to all cells of current row
			Iterator<Cell> cellIterator = row.cellIterator();
			while(cellIterator.hasNext()){
				Cell cell = (Cell)cellIterator.next();
				switch( cell.getColumnIndex()) {
				case 0:
					gtid = df.format(cell.getNumericCellValue());
					break;
				case 1:
					attendance = cell.getNumericCellValue();
					break;
				}
				if ( cell.getColumnIndex() == 1)
					break;
			}
			if ( gtid.equals(""))
				break;
			Grade grade = new Grade( gtid, attendance);
			_gradeMap.put(gtid,grade);
		}		
	}

}
