package com.yejh.service;/**
 * @author yejh
 * @create 2019-11_21 17:32
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description: TODO
 **/
@Service
public class MultiService {
    @Autowired
    BookService bookService;

    @Transactional(propagation = Propagation.REQUIRED)
    public void txTest(){
        //REQUIRES_NEW
        bookService.checkout("Tom", "ISBN-001");

        //REQUIRED
        bookService.setPrice("ISBN-001", 777);

        int i = 1/0;
    }
}
