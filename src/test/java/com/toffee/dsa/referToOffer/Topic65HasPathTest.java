package com.toffee.dsa.referToOffer;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* Topic65HasPath Tester. 
* 
* @author glz 
* @since <pre>01/09/2020</pre> 
* @version 1.0 
*/ 
public class Topic65HasPathTest { 

    @Before
    public void before() throws Exception { 
        
    } 
    
    @After
    public void after() throws Exception { 
        
    } 

    /** 
    * 
    * Method: hasPath(char[] matrix, int rows, int cols, char[] str) 
    * 
    */ 
    @Test
    public void testHasPath() throws Exception { 
        //TODO: Test goes here... 
        Topic65HasPath test = new Topic65HasPath();
        char[] matrix = "ABCESFCSADEE".toCharArray();
        char[] str = "SEE".toCharArray();

        System.out.println(test.hasPath(matrix, 3, 4, str));
    } 

}
