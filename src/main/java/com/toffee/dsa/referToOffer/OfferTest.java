package com.toffee.dsa.referToOffer;

/**
 * @Author glz
 * @Description
 * @ Date 2019-12-01 下午5:47
 */
public class OfferTest {
    public static void main (String[] args) {

        Topic20MinStack stack = new Topic20MinStack();
        stack.push(3);
        System.out.println(stack.min());
        stack.push(4);
        System.out.println(stack.min());
        stack.push(2);
        System.out.println(stack.min());
        stack.push(3);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.push(0);
        System.out.println(stack.min());
    }

}
