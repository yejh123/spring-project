package com.yejh.service;/**
 * @author yejh
 * @create 2019-11_15 23:50
 */

import com.yejh.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: TODO
 **/

public class BaseService<T> {
    @Autowired
    private BaseDao<T> baseDao;

    public void save(){
        System.out.println("自动注入 " + baseDao);
    }
}
