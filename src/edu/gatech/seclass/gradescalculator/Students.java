package edu.gatech.seclass.gradescalculator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.text.DecimalFormat;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Students {
	private LinkedList<Student> _studentList;
	
	public Students(String studentsDb) throws IOException {
		_studentList = new LinkedList<Student>();
		FileInputStream file;
		file = new FileInputStream(new File(studentsDb));
        
		//Get the workbook instance for XLS file 
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		//Get first sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(0);
		 
		//Get iterator to all the rows in current sheet
		Iterator<Row> rowIterator = sheet.iterator();
		rowIterator.next(); // skip a header row
		DecimalFormat df = new DecimalFormat("#########");
		while(rowIterator.hasNext()) {
			Row row = (Row)rowIterator.next();
			String name = "", gtid = "", email = "";
			//Get iterator to all cells of current row
			Iterator<Cell> cellIterator = row.cellIterator();
			while(cellIterator.hasNext()){
				Cell cell = (Cell)cellIterator.next();
				switch( cell.getColumnIndex()) {
				case 0:
					name = cell.getStringCellValue();
					break;
				case 1:
					gtid = df.format(cell.getNumericCellValue());
					break;
				case 2:
					email = cell.getStringCellValue();
					break;
				}
				if ( cell.getColumnIndex() == 2)
					break;
			}
			if ( name.equals(""))
				break;
			Student student = new Student( name, gtid, email);
			_studentList.add(student);
		}		
	}

	public int getNum() {
		return _studentList.size();
	}

}
