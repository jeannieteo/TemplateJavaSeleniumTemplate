package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
public class ExcelReader {
    public FileInputStream fileinput = null;
    public FileOutputStream fileOutput = null;
   
    private XSSFWorkbook workbook = null;
    private XSSFSheet sheet= null;
    private XSSFRow row = null;
    private XSSFCell cell = null;

    public ExcelReader() {

        try {
        	fileinput = new FileInputStream(Constants.excelPath);}
        catch (IOException e) {
        	throw new RuntimeException(e);
        }
        try {
			workbook = new XSSFWorkbook(fileinput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        sheet = workbook.getSheetAt(0);
        
        //try {
        //	workbook.close();
        //    fileInput.close();
        //} catch (IOException e) {
        //    throw new RuntimeException(e);
        //}
    }
    //provides total number of rows in worksheet
    public int getSheetRows(String Sheetname) {
        int index = workbook.getSheetIndex(Sheetname);
        sheet = workbook.getSheetAt(index);

        return (sheet.getLastRowNum() +1);

    }
    //provides total number of columns in worksheet
    public int getSheetColumns(String Sheetname) {
        int index = workbook.getSheetIndex(Sheetname);
        sheet = workbook.getSheetAt(index);
        row = sheet.getRow(0);
        return (row.getLastCellNum());

    }
    //provides cell value using column number
    public String getCellData(String sheetname, int colnum, int rownum) {
        int index = workbook.getSheetIndex(sheetname);
        sheet = workbook.getSheetAt(index);
        row = sheet.getRow(rownum);
        cell = row.getCell(colnum);

        return (cell.getStringCellValue());
    }
    
  //provides cell value using column number
    public List<String> getColumnDatas(String sheetname, String colname) {
        int index = workbook.getSheetIndex(sheetname);
        int colindex = 0;
        ArrayList<String> colData = new ArrayList<String>();
        sheet = workbook.getSheetAt(index);
        int numcolumns = getSheetColumns(sheetname);
        for (int j =0; j < numcolumns; j++)
        {
            row = sheet.getRow(0);
            cell = row.getCell(j);
            if(cell.getStringCellValue().equals(colname)) {
                colindex = cell.getColumnIndex();
                break;
            }
        }
        for (int i =0; i < getSheetRows(sheetname); i++)
        {
        row = sheet.getRow(i);
        cell = row.getCell(colindex);
        if(cell.getStringCellValue().equalsIgnoreCase("---"))
        	{ break;}
        else 
        	{ colData.add(cell.getStringCellValue());}
        }
        return colData;
    }

    //provides cell value using column name
    public String getCellDataN(String sheetname, String colname, int rownum) {
        int colnum = -1;
        int index = workbook.getSheetIndex(sheetname);
        sheet = workbook.getSheetAt(index);

        for (int i =0; i < getSheetColumns(sheetname); i++)
        {
            row = sheet.getRow(0);
            cell = row.getCell(i);
            if(cell.getStringCellValue().equals(colname)) {
                colnum = cell.getColumnIndex();

            }
        }
        row = sheet.getRow(rownum);
        cell = row.getCell(colnum);
        return (cell.getStringCellValue());

    }
    
    public void writeCelldata(String sheetname, int colnum, int rownum, String strW) {

        int index = workbook.getSheetIndex(sheetname);
        sheet = workbook.getSheetAt(index);

        row = sheet.getRow(rownum);
        cell = row.createCell(colnum);
        cell.setCellValue(strW);

        try {
            fileOutput = new FileOutputStream(Constants.excelPath);
            try {
                workbook.write(fileOutput);
                fileOutput.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }


    
        //ExcelReader reader =  new ExcelReader();
        //System.out.println(reader.getSheetRows("LogintestData"));
        //System.out.println(reader.getSheetRows("SignuptestData"));
        //System.out.println(reader.getSheetColumns("LogintestData"));
        //System.out.println(reader.getSheetColumns("SignuptestData"));
        //System.out.println(reader.getCellData("SignuptestData", 0, 1));
        //System.out.println(reader.getCellData("SignuptestData", 0, 2));
        //System.out.println(reader.getCellData("SignuptestData", 0, 3));
        //System.out.println(reader.getCellDataN("SignuptestData", "email", 2));

        //reader.writeCelldata("LogintestData", 6, 1,  "myloginpw");
    

}
