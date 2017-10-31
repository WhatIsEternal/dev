package com.test.dao;

import com.test.entity.BookType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookTypeDao {
    List<BookType> findBookType();

}

