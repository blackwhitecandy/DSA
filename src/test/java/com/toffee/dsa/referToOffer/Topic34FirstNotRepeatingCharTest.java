package com.toffee.dsa.referToOffer;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* Topic34FirstNotRepeatingChar Tester. 
* 
* @author glz 
* @since <pre>12/19/2019</pre> 
* @version 1.0 
*/ 
public class Topic34FirstNotRepeatingCharTest { 

    @Before
    public void before() throws Exception { 
        
    } 
    
    @After
    public void after() throws Exception { 
        
    } 

    /** 
    * 
    * Method: firstNotRepeatingChar(String str) 
    * 
    */ 
    @Test
    public void testFirstNotRepeatingChar() throws Exception { 
        //TODO: Test goes here... 
        Topic34FirstNotRepeatingChar test = new Topic34FirstNotRepeatingChar();

        System.out.println(test.firstNotRepeatingChar("wfjklsljdfklsjdlfjaskldfjaldfhghghsp"));
    }

    @Test
    public void testFirstNotRepeatingChar1() throws Exception {
        //TODO: Test goes here...
        Topic34FirstNotRepeatingChar test = new Topic34FirstNotRepeatingChar();

        System.out.println(test.firstNotRepeatingChar1("qaCkq"));
    }
}
