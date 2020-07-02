package com.yejh.impl;/**
 * @author yejh
 * @create 2020-03_24 20:27
 */

import org.springframework.stereotype.Component;

/**
 * @description: TODO
 **/
@Component
public class MyMathCalculator2 {
    public int add(int i, int j) {
        return i + j;
    }

    public int div(int i, int j){
        return i / j;
    }
}
