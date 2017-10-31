package com.test.controller;

import com.test.dao.BookTypeDao;
import com.test.entity.BookType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookTypeController {
    @Autowired
    private BookTypeDao btd;
    @RequestMapping("booktype.do")
    public List<BookType> findBookType(){
        return btd.findBookType();
    }
}
