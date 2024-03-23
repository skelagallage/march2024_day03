package com.ucsc.automation.testngannotations;

import org.testng.annotations.Test;

public class PriorityDemo {

    @Test(priority = 1)
    public void method1(){
        System.out.println("method1-priority 1");
    }

    @Test(priority = 3)
    public void method2(){
        System.out.println("method2-priority 3");
    }

    @Test(priority = 2)
    public void method3(){
        System.out.println("method3-priority 2");
    }

    @Test
    public void method4(){
        System.out.println("method4-No priority");
    }
}
