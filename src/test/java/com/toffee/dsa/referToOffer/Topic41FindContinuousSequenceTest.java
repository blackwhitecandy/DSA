package com.toffee.dsa.referToOffer;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import java.util.ArrayList;

/** 
* Topic41FindContinuousSequence Tester. 
* 
* @author glz 
* @since <pre>12/23/2019</pre> 
* @version 1.0 
*/ 
public class Topic41FindContinuousSequenceTest { 

    @Before
    public void before() throws Exception { 
        
    } 
    
    @After
    public void after() throws Exception { 
        
    } 

    /** 
    * 
    * Method: findContinuousSequence(int sum) 
    * 
    */ 
    @Test
    public void testFindContinuousSequence() throws Exception { 
        //TODO: Test goes here... 
        Topic41FindContinuousSequence test = new Topic41FindContinuousSequence();
        ArrayList<ArrayList<Integer>> resultList = test.findContinuousSequence(9);
        resultList.toString();
    } 


}
