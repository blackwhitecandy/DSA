package com.toffee.dsa.structure;

/**
 * @Author: glz
 * @Description: 数组实现 线性表   无法扩容。。。
 * @Date: Create in 9:37 2019/10/28
 */
public class GArrayList<E> {
    private Object[] element;//线性表数组元素

    private static int DEFAULT_CAPAITCY = 32;//线性表默认初始容量

    private int listLength;//线性表长度

    private int length;//数组长度 包含元素个数

    GArrayList(){
        this.element = new Object[DEFAULT_CAPAITCY];
    }

    GArrayList(int capacity) throws Exception {
        if (capacity > 0) {
            this.element = new Object[capacity];
            this.listLength = capacity;
        } else  if (capacity == 0) {
            this.element = new Object[DEFAULT_CAPAITCY];
            this.listLength = DEFAULT_CAPAITCY;
        } else {
            throw new Exception("invalid list capacity : " + capacity);
        }
    }

    //判断线性表是否为空
     boolean isEmpty() {
        if (this.length == 0) {
            return true;
        }
        return false;
     }

    /**
     * 清空线性表
     */
    void clearList() {
        //this.element = null;//let gc do its work

        for (int i = 0; i < length; i++)
            element[i] = null;
        this.length = 0;
     }

    /**
     * 获取对应下标的元素
     * @param index
     * @return
     */
     public Object getElem(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("invalid array index : " + index);
        } else {
            return element[index];
         }
     }

    /**
     * 获取对应元素的下标，找不到返回-1
     * @param o
     * @return
     */
     public int locateElement(Object o) {
        if (null == o) {
            for (int i = 0; i < this.length; i++) {
                if (element[i] == o) {
                    return i;
                }
            }
        } else if (null != o) {
            for (int i = 0; i < this.length; i++) {
                if (o.equals(element[i])) {
                    return i;
                }
            }
        }

        return -1;
     }

    /**
     * 添加元素
     * @param o
     * @throws Exception
     */
     public void add (Object o) throws Exception {
        if (length == listLength) {
            throw new Exception("list is full");
        } else if (length < listLength) {
            element[length++] = o;
         }
     }

    /**
     * 指定索引添加元素
     * @param index
     * @param o
     */
     public void add (int index, Object o) throws Exception {
         if (index >= length) {
             throw new IndexOutOfBoundsException("array index out of bounds :" + index);
         } else if (length == listLength || length < listLength - 1) {
             throw new Exception("list is full");
         } else if (length < listLength - 1) {
             System.arraycopy(element, index, element, index + 1, listLength - length);
         }
         element[index] = o;
     }


    /**
     * 删除指定下标的元素
     * @param index
     * @return
     */
     public Object delete(int index) {
         Object o = null;
        if (index > listLength - 1) {
            throw new IndexOutOfBoundsException("invalid index of array");
        } else {
            o = element[index];
            System.arraycopy(element, index, element, index - 1, listLength - length);
        }
        return o;
     }
    /**
     * 获取数组长度
     * @return
     */
     public int getListLength() {
         return length;
     }
}
