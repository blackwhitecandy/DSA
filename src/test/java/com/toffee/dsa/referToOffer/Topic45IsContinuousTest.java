package com.toffee.dsa.referToOffer;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* Topic45IsContinuous Tester. 
* 
* @author glz 
* @since <pre>12/24/2019</pre> 
* @version 1.0 
*/ 
public class Topic45IsContinuousTest { 

    @Before
    public void before() throws Exception { 
        
    } 
    
    @After
    public void after() throws Exception { 
        
    } 

    /** 
    * 
    * Method: isContinuous(int[] numbers) 
    * 
    */ 
    @Test
    public void testIsContinuous() throws Exception { 
        //TODO: Test goes here... 
        Topic45IsContinuous test = new Topic45IsContinuous();
        int[] numbers = {1,0,7,0,0};
        test.isContinuous(numbers);
    } 


    } 
