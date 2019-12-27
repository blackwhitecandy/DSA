package com.toffee.dsa.referToOffer;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* Topic50Multiply Tester. 
* 
* @author glz 
* @since <pre>12/27/2019</pre> 
* @version 1.0 
*/ 
public class Topic50MultiplyTest { 

    @Before
    public void before() throws Exception { 
        
    } 
    
    @After
    public void after() throws Exception { 
        
    } 

    /** 
    * 
    * Method: multiply(int[] A) 
    * 
    */ 
    @Test
    public void testMultiply() throws Exception { 
        //TODO: Test goes here... 
        Topic50Multiply test = new Topic50Multiply();
        int[] array = {1, 2, 3, 4, 5};
        test.multiply(array);
    } 
}
