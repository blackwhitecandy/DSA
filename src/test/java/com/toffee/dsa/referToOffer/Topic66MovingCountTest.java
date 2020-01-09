package com.toffee.dsa.referToOffer;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* Topic66MovingCount Tester. 
* 
* @author glz 
* @since <pre>01/09/2020</pre> 
* @version 1.0 
*/ 
public class Topic66MovingCountTest { 

    @Before
    public void before() throws Exception { 
        
    } 
    
    @After
    public void after() throws Exception { 
        
    } 

    /** 
    * 
    * Method: movingCount(int threshold, int rows, int cols) 
    * 
    */ 
    @Test
    public void testMovingCount() throws Exception { 
        //TODO: Test goes here... 
        Topic66MovingCount test = new Topic66MovingCount();
        System.out.println(test.movingCount(1, 5, 5));
    } 

    /** 
    * 
    * Method: checkNum(int threshold, int currentRow, int currentCol) 
    * 
    */ 
    @Test
    public void testCheckNum() throws Exception { 
        //TODO: Test goes here... 
        Topic66MovingCount test = new Topic66MovingCount();
    }


        /** 
    * 
    * Method: checkPath(int threshold, int rows, int cols, int currentRow, int currentCol, boolean[][] path) 
    * 
    */ 
    @Test
    public void testCheckPath() throws Exception { 
        //TODO: Test goes here... 
            /* 
            try { 
               Method method = Topic66MovingCount.getClass().getMethod("checkPath", int.class, int.class, int.class, int.class, int.class, boolean[][].class); 
               method.setAccessible(true); 
               method.invoke(<Object>, <Parameters>); 
            } catch(NoSuchMethodException e) { 
            } catch(IllegalAccessException e) { 
            } catch(InvocationTargetException e) { 
            } 
            */ 
        } 

} 
