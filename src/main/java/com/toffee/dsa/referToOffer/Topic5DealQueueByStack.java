package com.toffee.dsa.referToOffer;

import java.util.ListIterator;
import java.util.Stack;

/**
 * @Auther glz
 * @Description 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
 * @ Date 2019-11-24
 */
public class Topic5DealQueueByStack {
    private static Stack<Integer> stack1 = new Stack<Integer>();
    private static Stack<Integer> stack2 = new Stack<Integer>();

    public static void main (String[] args) {
        push(1);
        push(2);
        push(3);
        System.out.println(pop());
        System.out.println(pop());
        push(4);
        System.out.println(pop());
        push(5);
        System.out.println(pop());
        System.out.println(pop());


        //push(4);
    }
    /**
     * 队列是FIFO   栈是LIFO   所以用stack1用来push  用stack2用来pop
     * @param node
     */
    public static void push(int node) {
        stack1.push(node);//stack1正序存放元素
        stack2.clear();//清空stack2  重新反序存放元素 pop时弹出最后一个元素 也就是队列的地一个
        int stack1Length = stack1.size();
        for (int i = stack1Length - 1; i >= 0; i--) {
            stack2.push(stack1.elementAt(i));
        }
    }

    public static int pop() {

        int result  = 0;
        try {

            if (!stack2.isEmpty()) {
                result = stack2.pop();//弹出一个元素
            }

            // 如果弹出元素后  stack2变为空，则把stack1变为空
            if (stack2.isEmpty()) {
                stack1.clear();
            } else {
                stack1.clear();//清空stack1  重新正序存放元素 push时依照队列的元素顺序存放接下来的新的元素
                int stack2Length = stack2.size();
                for (int i = stack2Length - 1; i >= 0; i--) {
                    stack1.push(stack2.elementAt(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
