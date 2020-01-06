package com.toffee.dsa.referToOffer;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* Topic56DeleteDuplication Tester. 
* 
* @author glz 
* @since <pre>01/06/2020</pre> 
* @version 1.0 
*/ 
public class Topic56DeleteDuplicationTest { 

    @Before
    public void before() throws Exception { 
        
    } 
    
    @After
    public void after() throws Exception { 
        
    } 

    /** 
    * 
    * Method: deleteDuplication(ListNode pHead) 
    * 
    */ 
    @Test
    public void testDeleteDuplication() throws Exception { 
        //TODO: Test goes here... 
        Topic56DeleteDuplication test = new Topic56DeleteDuplication();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        test.deleteDuplication(listNode1);
    } 


    } 
