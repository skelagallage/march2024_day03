package com.ucsc.automation.testngannotations;

import org.testng.annotations.Test;

public class DependsOnDemo {

    @Test(dependsOnMethods = "makeWall")
    public void makeRoof(){
        System.out.println("makeRoof");
    }

    @Test(dependsOnMethods = "makeFoundation")
    public void makeWall(){
        System.out.println("makeWall");
    }

    @Test
    public void makeFoundation(){
        System.out.println("makeFoundation");
    }

    @Test(dependsOnMethods = {"makeWall", "makeRoof"})
    public void makeElectricity(){
        System.out.println("makeElectricity");
    }
}
