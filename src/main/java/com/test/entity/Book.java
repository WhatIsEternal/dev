package com.test.entity;

import org.springframework.stereotype.Repository;

import java.io.Serializable;


public class Book implements Serializable{
    private String id;
    private String title;
    private String typeid;
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public BookType getBtype() {
        return btype;
    }

    public void setBtype(BookType btype) {
        this.btype = btype;
    }

    private BookType btype;
    private String bookcontent;
    private String bookpic;
    private float price;
    private String numbers;

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public Book() {
    }

    public Book(String id, String title, String typeid, String bookcontent, String bookpic, float price,String numbers) {
        this.id = id;
        this.title = title;
        this.typeid = typeid;
        this.bookcontent = bookcontent;
        this.bookpic = bookpic;
        this.price = price;
        this.numbers=numbers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }

    public String getBookcontent() {
        return bookcontent;
    }

    public void setBookcontent(String bookcontent) {
        this.bookcontent = bookcontent;
    }

    public String getBookpic() {
        return bookpic;
    }

    public void setBookpic(String bookpic) {
        this.bookpic = bookpic;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                ", title='" + title + '\'' +
                ", num=" + num +

                '}';
    }
}
