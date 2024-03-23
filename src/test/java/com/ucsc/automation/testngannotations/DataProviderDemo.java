package com.ucsc.automation.testngannotations;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

    @Test(dataProvider = "studentDataProvider")
    public void showStudentDetails(String name, int age){
        System.out.printf("Student name is %s and age is %d \n", name, age);
    }

    @DataProvider
    public Object[][] studentDataProvider(){
        Object[][] studentData = new Object[][]{
                {"Sanath", 35},
                {"Thameera", 28},
                {"Ruwan", 30},
        };
        return studentData;
    }
}
