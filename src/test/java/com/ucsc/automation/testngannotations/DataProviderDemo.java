package com.ucsc.automation.testngannotations;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DataProviderDemo {

    private static final String FILE_NAME = "studentData.xlsx";

    @Test(dataProvider = "studentDataProvider")
    public void showStudentDetails(String name, int age){
        System.out.printf("Student name is %s and age is %d \n", name, age);
    }

    @DataProvider
    public Object[][] studentDataProvider() throws IOException {
        List<Object[]> studentsData = new ArrayList<>();
        InputStream inputStream = new FileInputStream(FILE_NAME);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet xssfSheet = workbook.getSheet("Sheet1");
        int lastRowNumber = xssfSheet.getLastRowNum();
        for(int i = 0; i<lastRowNumber+1; i++){
            if(i==0)
                continue;
            List<Object> rowData = new ArrayList<>();
            XSSFRow xssfRow = xssfSheet.getRow(i);
            int lastCellNum = xssfRow.getLastCellNum();
            for(int j = 0; j<lastCellNum; j++){
                XSSFCell xssfCell = xssfRow.getCell(j);
//                System.out.print(xssfRow.getCell(j) + "\t");
                if(xssfCell.getCellType().equals(CellType.NUMERIC)){
                    rowData.add((int)xssfCell.getNumericCellValue());
                }else{
                    rowData.add(xssfCell.getStringCellValue());
                }
            }
            studentsData.add(rowData.toArray(new Object[0]));
//            System.out.println();
        }
//        Object[][] studentData = new Object[][]{
//                {"Sanath", 35},
//                {"Thameera", 28},
//                {"Ruwan", 30},
//        };
//        return studentData;
        return studentsData.toArray(new Object[0][]);
    }
}
