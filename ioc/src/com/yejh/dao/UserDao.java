package com.yejh.dao;/**
 * @author yejh
 * @create 2019-11_15 23:51
 */

import com.yejh.bean.Book;
import com.yejh.bean.User;
import org.springframework.stereotype.Repository;

/**
 * @description: TODO
 **/
@Repository
public class UserDao extends BaseDao<User> {

    @Override
    public void save() {
        System.out.println("UserDao: save()");
    }
}
