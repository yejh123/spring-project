package com.yejh.service;/**
 * @author yejh
 * @create 2019-11_18 17:19
 */

import com.yejh.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.transaction.annotation.Isolation.READ_COMMITTED;
import static org.springframework.transaction.annotation.Isolation.READ_UNCOMMITTED;

/**
 * @description: TODO
 *
 * 事务细节
 * isolation-Isolation：事务隔离级别
 * propagation-Propagation：事务的传播行为
 *      REQUIRED：将之前事务的connection传递给这个方法使用
 *      REQUIRED_NEW：这个方法直接使用新的connection
 *      如果是REQUIRED：事务的属性都是继承于大事务
 *
 * noRollbackFor-Class[]：哪些异常事务可以不回滚
 * noRollbackForClassName-String[]：写String全类名
 *
 * rollbackFor-Class[]：哪些异常事务需要回滚
 * rollbackForClassName-String[]
 *
 * 默认发生运行时异常都回滚，编译时异常不回滚
 *
 * readOnly-boolean：设置事务为只读事务，可以进行查询事务优化
 *      readOnly=true：加快查询速度，不用管事务管理操作
 *
 * timeout-int（s为单位）：事务超出指定时长后自动终止并回滚
 *
 *
 *
 **/

@Service
public class BookService {
    @Autowired
    BookDao bookDao;

    public void checkout(String userName, String isbn){
        bookDao.updateStock(isbn);
        int price = bookDao.getPrice(isbn);
        bookDao.updateBalance(userName, price);
        int i = 1/0;
    }

    public void getPrice(){

    }

    public void setPrice(String isbn, int price){
        bookDao.setPrice(isbn, price);
    }
}
