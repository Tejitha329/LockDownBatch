package com.erp.utilities;


	import java.io.FileInputStream;
import java.io.FileOutputStream;
	import java.io.IOException;

	import org.apache.poi.EncryptedDocumentException;
	import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;

	public class ExcelOperation{
			// TODO Auto-generated method stub

		public static  String readData(String sheetname,int rownum, int cellnum) throws EncryptedDocumentException, InvalidFormatException, IOException {
			FileInputStream fis=new FileInputStream("C:\\Users\\Mounika Reddy\\Desktop\\testdata\\userdata.xlsx");
		System.out.println("Reading file");
			Workbook w1= WorkbookFactory.create(fis);
			System.out.println("Workbook created");
		String s=w1.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
		System.out.println("Sheet: "+s);
		return s;
		}
		public static void writeData(String sheetname,int rownum,int cellnum,String data) throws EncryptedDocumentException, InvalidFormatException, IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\Mounika Reddy\\Desktop\\testdata\\userdata.xlsx");
		System.out.println("Writing in excel");
		Workbook w1= WorkbookFactory.create(fis);
		System.out.println("Writing workbook");
		w1.getSheet(sheetname).getRow(rownum).getCell(cellnum).setCellValue(data);
		FileOutputStream fos=new FileOutputStream("C:\\Users\\Mounika Reddy\\Desktop\\testdata\\userdata.xlsx");
		w1.write(fos);
		}
	}
				

