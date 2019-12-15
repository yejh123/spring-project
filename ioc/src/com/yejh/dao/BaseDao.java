package com.yejh.dao;/**
 * @author yejh
 * @create 2019-11_15 23:51
 */

import org.springframework.stereotype.Repository;

/**
 * @description: TODO
 **/

public abstract class BaseDao<T> {

    public abstract void save();
}
