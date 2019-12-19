package com.toffee.dsa.referToOffer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: glz
 * @Description:
 * @Date: Create in 11:05 2019/12/19
 */
class Topic32PrintMinNumberTest {

    @Test
    void printMinNumber() {
        int[] numbers = {3, 32, 35, 321};
        System.out.println(new Topic32PrintMinNumber().PrintMinNumber(numbers));
    }
}