package com.yejh.factory;/**
 * @author yejh
 * @create 2019-11_13 16:35
 */

import com.yejh.bean.Book;
import org.springframework.stereotype.Component;

/**
 * @description: TODO
 **/

@Component
public class BookStaticFactory {
    public static Book BookInstance(String bname, String author){
        System.out.println("BookStaticFactory正在为你造书本。。。");
        Book book =  new Book();
        book.setBname(bname);
        book.setAuthor(author);
        return book;
    }


}
