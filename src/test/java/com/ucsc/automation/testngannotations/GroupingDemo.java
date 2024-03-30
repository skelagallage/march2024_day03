package com.ucsc.automation.testngannotations;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupingDemo {

    @BeforeGroups(groups = "smoke")
    public void beforeSmoke(){
        System.out.println("BeforeSmoke");
    }

    @BeforeGroups(groups = "regression")
    public void beforeRegression(){
        System.out.println("BeforeRegression");
    }

    @AfterGroups(groups = "smoke")
    public void afterSmoke(){
        System.out.println("AfterSmoke");
    }

    @Test(groups = "smoke")
    public void method1(){
        System.out.println("method1");
    }

    @Test(groups = "smoke")
    public void method2(){
        System.out.println("method2");
    }

    @Test(groups = "regression")
    public void method3(){
        System.out.println("method3");
    }

    @Test(groups = "regression")
    public void method4(){
        System.out.println("method4");
    }

    @Test(groups = {"smoke", "regression"})
    public void method5(){
        System.out.println("method5");
    }

    @Test
    public void method6(){
        System.out.println("method6");
    }
}
