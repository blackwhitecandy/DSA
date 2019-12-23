package com.toffee.dsa.referToOffer;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* Topic38TreeDepth Tester. 
* 
* @author glz 
* @since <pre>12/20/2019</pre> 
* @version 1.0 
*/ 
public class Topic38TreeDepthTest { 

    @Before
    public void before() throws Exception { 
        
    } 
    
    @After
    public void after() throws Exception { 
        
    } 

    /** 
    * 
    * Method: treeDepthByQueue(TreeNode root) 
    * 
    */ 
    @Test
    public void testTreeDepthByQueue() throws Exception { 
        //TODO: Test goes here... 
        Topic38TreeDepth test = new Topic38TreeDepth();
    }

    /** 
    * 
    * Method: treeDepthByArrayList(TreeNode root) 
    * 
    */ 
    @Test
    public void testTreeDepthByArrayList() throws Exception { 
        //TODO: Test goes here... 
        Topic38TreeDepth test = new Topic38TreeDepth();
    }

    /** 
    * 
    * Method: treeDepthByArray(TreeNode root) 
    * 
    */ 
    @Test
    public void testTreeDepthByArray() throws Exception { 
        //TODO: Test goes here...
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode10 = new TreeNode(10);
        treeNode6.left = treeNode4;
        treeNode6.right = treeNode8;

        treeNode4.left = treeNode1;
        treeNode4.right = treeNode5;

        treeNode1.right = treeNode3;
        treeNode3.left = treeNode2;

        treeNode8.left = treeNode7;
        treeNode8.right = treeNode9;
        treeNode9.right = treeNode10;

        Topic38TreeDepth test = new Topic38TreeDepth();
        System.out.println(test.treeDepthByArray(treeNode6));
    } 


}
