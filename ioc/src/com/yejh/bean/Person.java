package com.yejh.bean;/**
 * @author yejh
 * @create 2019-11_03 17:28
 */

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @description: TODO
 **/
public class Person {
    private String name;
    private int age;
    private Book book;

    private List<Book> books;
    private Map<String, Object> maps;
    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Person() {
        System.out.println("Person已创建");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", book=" + book +
                ", books=" + books +
                ", maps=" + maps +
                ", properties=" + properties +

                '}';
    }
}
