package com.ait.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTests extends TestBase{
    @BeforeMethod
                public void beforeMethod(){
            System.out.println("before methode");
        }


    @Test
    public void testElementone(){
        System.out.println("Test element one");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("after method");
    }
}


////*[@id="header"]/div/a/img