package com.toffee.dsa.referToOffer;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* Topic62KthNode Tester. 
* 
* @author glz 
* @since <pre>01/07/2020</pre> 
* @version 1.0 
*/ 
public class Topic62KthNodeTest { 

    @Before
    public void before() throws Exception { 
        
    } 
    
    @After
    public void after() throws Exception { 
        
    } 

    /** 
    * 
    * Method: kthNode(TreeNode pRoot, int k) 
    * 
    */ 
    @Test
    public void testKthNode() throws Exception { 
        //TODO: Test goes here...
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode11 = new TreeNode(11);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode10 = new TreeNode(10);
        treeNode8.left = treeNode6;
        treeNode8.right = treeNode10;

        treeNode6.left = treeNode5;
        treeNode6.right = treeNode7;

        treeNode10.left = treeNode9;
        treeNode10.right = treeNode11;

        Topic62KthNode test = new Topic62KthNode();
        test.kthNode1(treeNode8, 1);
    } 


        /** 
    * 
    * Method: getKthNode(TreeNode[] kArray, TreeNode pRoot, int k) 
    * 
    */ 
    @Test
    public void testGetKthNode() throws Exception { 
        //TODO: Test goes here... 
            /* 
            try { 
               Method method = Topic62KthNode.getClass().getMethod("getKthNode", TreeNode[].class, TreeNode.class, int.class); 
               method.setAccessible(true); 
               method.invoke(<Object>, <Parameters>); 
            } catch(NoSuchMethodException e) { 
            } catch(IllegalAccessException e) { 
            } catch(InvocationTargetException e) { 
            } 
            */ 
        } 

} 
