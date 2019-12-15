package com.yejh.inter;/**
 * @author yejh
 * @create 2019-11_16 10:52
 */

/**
 * @description: TODO
 * 接口不用加在容器中，但是可以加，加了不创建对象
 **/
public interface Calculator {
    int add(int i, int j);

    int div(int i, int j);
}
