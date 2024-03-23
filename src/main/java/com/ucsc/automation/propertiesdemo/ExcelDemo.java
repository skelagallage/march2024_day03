package com.ucsc.automation.propertiesdemo;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ExcelDemo {

    Map<Integer, Object[]> map = new HashMap<>();

    private static final String FILE_NAME = "studentData.xlsx";

    {
        map.put(0, new Object[]{"Name", "Age"});
        map.put(1, new Object[]{"Sanath", 35});
        map.put(2, new Object[]{"Thameera", 28});
        map.put(3, new Object[]{"Ruwan", 30});
    }

    public void createStudentDataExcel() throws IOException {
        OutputStream outputStream = new FileOutputStream(FILE_NAME);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();

        XSSFSheet xssfSheet = xssfWorkbook.createSheet("Sheet1");
        for(Map.Entry<Integer, Object[]> dataRow : map.entrySet()){
            XSSFRow xssfRow = xssfSheet.createRow(dataRow.getKey());
            Object[] data = dataRow.getValue();
            for(int i=0; i<data.length; i++){
                XSSFCell xssfCell;
                if(data[i] instanceof Integer){
                    xssfCell = xssfRow.createCell(i, CellType.NUMERIC);
                    xssfCell.setCellValue((int)data[i]);
                }else if(data[i] instanceof String){
                    xssfCell = xssfRow.createCell(i, CellType.STRING);
                    xssfCell.setCellValue((String)data[i]);
                }


            }
        }

        xssfWorkbook.write(outputStream);
    }

    public void readStudentDataExcel() throws IOException {
        InputStream inputStream = new FileInputStream(FILE_NAME);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet xssfSheet = workbook.getSheet("Sheet1");
        int lastRowNumber = xssfSheet.getLastRowNum();
        for(int i = 0; i<lastRowNumber+1; i++){
            XSSFRow xssfRow = xssfSheet.getRow(i);
            int lastCellNum = xssfRow.getLastCellNum();
            for(int j = 0; j<lastCellNum; j++){
                System.out.print(xssfRow.getCell(j) + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
//        new ExcelDemo().createStudentDataExcel();
        new ExcelDemo().readStudentDataExcel();
    }
}
