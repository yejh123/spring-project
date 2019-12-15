package com.yejh.dao;/**
 * @author yejh
 * @create 2019-11_15 19:37
 */

import com.yejh.bean.Book;
import org.springframework.stereotype.Repository;

/**
 * @description: TODO
 **/

@Repository
public class BookDao extends BaseDao<Book>{
    public void addBook(){
        System.out.println("BookDao: addBook()");
    }

    public void save() {
        System.out.println("BookDao: save()");
    }



/*
方法上有@Autowired的话
1、这个方法在bean创建的时候会自动运行
2、这个方法上的每一个参数都会自动注入值
3、参数上也可以标注注解

@Autowired、@Resource、@Inject都可以自动装配
@Autowired：最强大，Spring自己的注解
@Resource：j2ee，java的标准，扩展性更强。跨框架
 */
}
