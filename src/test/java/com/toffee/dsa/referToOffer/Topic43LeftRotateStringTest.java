package com.toffee.dsa.referToOffer;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* Topic43LeftRotateString Tester. 
* 
* @author glz 
* @since <pre>12/24/2019</pre> 
* @version 1.0 
*/ 
public class Topic43LeftRotateStringTest { 

    @Before
    public void before() throws Exception { 
        
    } 
    
    @After
    public void after() throws Exception { 
        
    } 

    /** 
    * 
    * Method: leftRotateString(String str, int n) 
    * 
    */ 
    @Test
    public void testLeftRotateString() throws Exception { 
        //TODO: Test goes here... 
        Topic43LeftRotateString test = new Topic43LeftRotateString();

        System.out.println(test.leftRotateString("abcdefg", 7));
    } 
}
