package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AllData {
	
	public static void allData() throws IOException {
		
		File f = new File("C:\\Users\\anandraj\\Desktop\\amazon.xlsx");
		FileInputStream fi =new  FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s= w.getSheet("amazon2");
		int r = s.getPhysicalNumberOfRows();
		
		for(int i=0; i<r;i++) {
			
			Row row = s.getRow(i);
			int c = row.getPhysicalNumberOfCells();
			
			for(int j=0;j<c;j++) {
				Cell c1 = row.getCell(j);
				CellType ce= c1.getCellType();
				if(ce.equals(CellType.STRING)) {
					String str=c1.getStringCellValue();
					System.out.print(str);}
				else if(ce.equals(CellType.NUMERIC)) {
					double d=c1.getNumericCellValue();
					int in=(int)d;
					System.out.print(in);
					}
				System.out.print("||");
				}
			System.out.println();
			
			}
		
		
	}

	public static void main(String[] args) throws IOException {
		allData();

	}

}
