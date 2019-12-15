package com.yejh.bean;/**
 * @author yejh
 * @create 2019-11_03 23:27
 */

import org.springframework.stereotype.Controller;

/**
 * @description: TODO
 **/


public class Book {
    private String bname;
    private String author;

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
