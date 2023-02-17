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





public class Singledata {
	static String value;
	public static String singleData(String name, int row, int cell) throws IOException {
	
	File f=new File("C:\\Users\\anandraj\\Desktop\\amazon.xlsx");
	FileInputStream fi= new FileInputStream(f);
	Workbook w=new XSSFWorkbook(fi);
    Sheet s= w.getSheet(name);
    Row r= s.getRow(row);
	Cell c= r.getCell(cell);
	CellType ce= c.getCellType();
	if(ce.equals(CellType.STRING)) {
		 value=c.getStringCellValue();
		//System.out.println(str);
		}
	else if(ce.equals(CellType.NUMERIC)) {
		double d=c.getNumericCellValue();
		int in=(int)d;
		 value=String.valueOf(in);
		//System.out.println(i);
	}
	
	return value;
	
	
	
}
	public static void main(String[] args) throws IOException {
		singleData(value, 0, 0);

	}

}
