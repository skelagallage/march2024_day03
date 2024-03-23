package com.ucsc.automation.testngannotations;

import org.testng.annotations.*;

public class TestNGOrder {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite is called");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite is called");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest is called");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest is called");
    }

    @BeforeClass
    public void beforeClassMethod(){
        System.out.println("BeforeClass is called");
    }

    @AfterClass
    public void afterClassMethod(){
        System.out.println("AfterClass is called");
    }

    @BeforeMethod
    public void beforeTestMethod(){
        System.out.println("BeforeMethod is called");
    }

    @AfterMethod
    public void afterTestMethod(){
        System.out.println("AfterMethod is called");
    }

    @Test
    public void test(){
        System.out.println("Test method is called");
    }
}
