package com.toffee.dsa.referToOffer;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* Topic64MaxInWindows Tester. 
* 
* @author glz 
* @since <pre>01/08/2020</pre> 
* @version 1.0 
*/ 
public class Topic64MaxInWindowsTest { 

    @Before
    public void before() throws Exception { 
        
    } 
    
    @After
    public void after() throws Exception { 
        
    } 

    /** 
    * 
    * Method: maxInWindows(int[] num, int size) 
    * 
    */ 
    @Test
    public void testMaxInWindows() throws Exception { 
        //TODO: Test goes here... 
        Topic64MaxInWindows test = new Topic64MaxInWindows();
        int[] num = {2,3,4,2,6,2,5,1};
        test.maxInWindows(num, 3);
    } 

    /** 
    * 
    * Method: findMaxOfWindows(int maxIndex, int[] num, int right, ArrayList<Integer> resultList) 
    * 
    */ 
    @Test
    public void testFindMaxOfWindows() throws Exception { 
        //TODO: Test goes here... 
        Topic64MaxInWindows test = new Topic64MaxInWindows();
    }


    } 
