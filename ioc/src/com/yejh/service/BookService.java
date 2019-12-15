package com.yejh.service;/**
 * @author yejh
 * @create 2019-11_15 19:38
 */

import com.yejh.bean.Book;
import com.yejh.dao.BaseDao;
import com.yejh.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @description: TODO
 **/
@Service
public class BookService extends BaseService<Book> {

    public void addBook(){
        System.out.println("BookService：addBook()");
    }

}
