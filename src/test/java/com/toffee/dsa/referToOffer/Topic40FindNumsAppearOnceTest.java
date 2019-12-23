package com.toffee.dsa.referToOffer;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* Topic40FindNumsAppearOnce Tester. 
* 
* @author glz 
* @since <pre>12/23/2019</pre> 
* @version 1.0 
*/ 
public class Topic40FindNumsAppearOnceTest { 

    @Before
    public void before() throws Exception { 
        
    } 
    
    @After
    public void after() throws Exception { 
        
    } 

    /** 
    * 
    * Method: findNumsAppearOnce1(int [] array, int num1[], int num2[]) 
    * 
    */ 
    @Test
    public void testFindNumsAppearOnce1() throws Exception { 
        //TODO: Test goes here... 
        Topic40FindNumsAppearOnce test = new Topic40FindNumsAppearOnce();
        int[] array = {3, 5, 9, 22, 3, 9};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        test.findNumsAppearOnce1(array, num1, num2);
        System.out.println(num1[0] + "---" +  num2[0]);
    } 

    /** 
    * 
    * Method: quicklySort(int[] array, int start, int end) 
    * 
    */ 
    @Test
    public void testQuicklySort() throws Exception { 
        //TODO: Test goes here... 
    }


        /** 
    * 
    * Method: getDiviotIndex(int[] array, int start, int end) 
    * 
    */ 
    @Test
    public void testGetDiviotIndex() throws Exception { 
        //TODO: Test goes here... 
            /* 
            try { 
               Method method = Topic40FindNumsAppearOnce.getClass().getMethod("getDiviotIndex", int[].class, int.class, int.class); 
               method.setAccessible(true); 
               method.invoke(<Object>, <Parameters>); 
            } catch(NoSuchMethodException e) { 
            } catch(IllegalAccessException e) { 
            } catch(InvocationTargetException e) { 
            } 
            */ 
        } 

} 
