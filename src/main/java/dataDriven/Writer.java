package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Writer {

	public static void uploadd() throws IOException {
		
		File f = new File("C:\\Users\\anandraj\\Desktop\\amazon.xlsx");
		FileInputStream fi =new  FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s= w.createSheet("amazon1");
		Row r= s.createRow(0);
		Cell c= r.createCell(0);
		c.setCellValue("Home");
		//Workbook w1= new XSSFWorkbook(fi);
	    Sheet s1= w.getSheet("amazon1");
	    s1.createRow(2).createCell(2).setCellValue("KIDS");
		
	    FileOutputStream fo = new FileOutputStream(f);
	    w.write(fo);
	    w.close();
		
		
	}
	
	
	public static void main(String[] args) throws IOException {
		uploadd();
		System.out.println("done");
	}

}
