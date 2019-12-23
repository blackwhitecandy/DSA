package com.toffee.dsa.referToOffer;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* Topic36FindFirstCommonNode Tester. 
* 
* @author glz 
* @since <pre>12/20/2019</pre> 
* @version 1.0 
*/ 
public class Topic36FindFirstCommonNodeTest { 

    @Before
    public void before() throws Exception { 
        
    } 
    
    @After
    public void after() throws Exception { 
        
    } 

    /** 
    * 
    * Method: findFirstCommonNode(ListNode pHead1, ListNode pHead2) 
    * 
    */ 
    @Test
    public void testFindFirstCommonNode() throws Exception { 
        //TODO: Test goes here...
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        listNode4.next = listNode3;


        Topic36FindFirstCommonNode test = new Topic36FindFirstCommonNode();
        System.out.println(test.findFirstCommonNode(listNode1, listNode4).val);
    } 

    /** 
    * 
    * Method: getFirstCommonNode2(ListNode pHead1, ListNode pHead2) 
    * 
    */ 
    @Test
    public void testGetFirstCommonNode2() throws Exception { 
        //TODO: Test goes here... 

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        listNode4.next = listNode3;


        Topic36FindFirstCommonNode test = new Topic36FindFirstCommonNode();
        System.out.println(test.getFirstCommonNode2(listNode1, listNode4).val);
    } 


    } 
