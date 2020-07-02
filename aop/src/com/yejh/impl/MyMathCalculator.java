package com.yejh.impl;/**
 * @author yejh
 * @create 2019-11_16 11:20
 */

import com.yejh.inter.Calculator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @description: TODO
 **/

@Component
public class MyMathCalculator implements Calculator{

    //@Override
    public int add(int i, int j) {
        return i + j;
    }

    //@Override
    public int div(int i, int j){
        return i / j;
    }
}
